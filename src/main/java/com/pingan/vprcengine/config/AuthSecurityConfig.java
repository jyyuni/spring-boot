package com.pingan.vprcengine.config;

import com.pingan.vprcengine.dao.EngineUserRepository;
import com.pingan.vprcengine.security.CustomUserService;
import com.pingan.vprcengine.security.EnginePasswordEncoder;
import com.pingan.vprcengine.security.TokenAuthenticationFilter;
import com.pingan.vprcengine.security.TokenGenerateFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * TODO
 * Spring Security 配置文件
 * Spring Security 能够在Web请求级别和方法调用级别处理身份认证和授权
 * Spring Security 利用了依赖注入和面向切面技术；使用Servlet规范中的Filter保护web请求并限制URL级别的访问；
 * 使用Spring AOP保护方法调用——借助于对象代理和使用通知，能够确保只有具备适当权限的用户才能访问安全保护的方法
 * 这里不需要@EnableWebSecurity，因为spring boot会在引入依赖后默认开启Web安全功能
 * Spring Security必须配置在一个实现了WebSecurityConfigurer的bean中，或者简单起见扩展WebSecurityConfigurerAdapter
 * 通过重载Cconfigure()方法来配置web安全性
 * 此处采用configure(HttpSecurity)配置通过拦截器保护请求
 * configure(AuthenticationManagerBuilder)配置用户存储认证，自定义的用户服务
 * @author ThinkPad
 * @date 2018/8/23 14:19
 * @return
 */
@Configuration
@EnableWebSecurity
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    EngineUserRepository engineUserRepository;

    @Autowired
    EnginePasswordEncoder enginePasswordEncoder;

    /**
     * 定义用户角色
     */
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    /**
     * 用户存储认证，包含基于内存的用户配置、基于数据库表进行认证、基于LDAP进行认证
     * 这里采用用户自定义的方法
     * userDetailsService()方法会同内存、数据库、LDAP的方式一样配置一个用户存储，
     * 但是这里使用的不是Spring提供的用户存储，而是使用UserDetailsService的实现
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 不加passwordEncoder(new MyPasswordEncoder())
         * 就不是以明文的方式进行匹配，会报错
         * passwordEncoder(new MyPasswordEncoder())
         * 这样，页面提交时候，密码以明文的方式进行匹配。
         */
        auth
                .userDetailsService(customUserService()).passwordEncoder(enginePasswordEncoder);
    }
    /**
     *指定该如何保护HTTP请求，以及客户端认证的方案
     * 通过调用authorizeRequests()和.anyRequest().authenticated()要求所有进入应用的HTTP请求都要认证
     * 也配置了Spring Security 支持基本表单的登录以及HTTP Basic方式的认证
     * 如果不配置configure(AuthenticationManagerBuilder auth)用户存储认证，将导致没有用户存储，
     * 以至于所有请求都要认证，但是没有请求可以认证成功
     * 增加过滤器，TokenGenerateFilter，如果engineUser表里有该用户的注册信息，验证通过，生成token
     * TokenAuthenticationFilter，以后每次访问都需要带上该token，校验合法性
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .addFilter(new TokenGenerateFilter(authenticationManager()))
                .addFilter(new TokenAuthenticationFilter(authenticationManager()));
    }

}
