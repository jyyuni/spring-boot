package com.pingan.vprcengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * TODO
 * 启动类
 * @author ThinkPad
 * @date 2018/9/12 10:26
 * @param null
 * @return
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.pingan.vprcengine"})
@EnableJpaRepositories(basePackages = "com.pingan.vprcengine.dao")
@EnableTransactionManagement
@EnableCaching
public class VprcengineApplication {

	public static void main(String[] args) {
		SpringApplication.run(VprcengineApplication.class, args);
	}
}
