package com.pingan.vprcengine.security;

import com.pingan.vprcengine.bean.EngineUser;
import com.pingan.vprcengine.dao.EngineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 实现UserDetailsService接口，注意这里的接口是指security里的接口，不用自己新建
 * @author ThinkPad
 * @date 2018/8/23 16:34
 * @return
 */
public class CustomUserService implements UserDetailsService {

    /**
     * 没有采用自动装配，采用java config 利用构造器注入
     * 因为需要提供含参数的构造器，没有用默认构造器
     * 当然也可以采用默认构造器，此时可以自动装配
     */

    @Autowired
    public EngineUserRepository engineUserRepository;
    //private final EngineUserRepository engineUserRepository;

    // public UserSecurityService(EngineUserRepository engineUserRepository) {
    //  this.engineUserRepository = engineUserRepository;
    //}

    /**
     * 查找user，如果找到user，不为空的话，创建权限列表并返回
     * 否则抛出用户不存在的异常
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EngineUser engineUser = engineUserRepository.findByUsername(username);
        if (engineUser != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            return new User(
                    engineUser.getUsername(),
                    engineUser.getPassword(),
                    authorities);
        }

        throw new UsernameNotFoundException(
          "User '" + username + "' not found. ");
    }
}
