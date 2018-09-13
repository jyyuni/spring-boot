package com.pingan.vprcengine.controller;

import com.pingan.vprcengine.bean.EngineUser;
import com.pingan.vprcengine.bean.MongoRecord;
import com.pingan.vprcengine.bean.UserInfo;
import com.pingan.vprcengine.dao.EngineUserRepository;
import com.pingan.vprcengine.service.impl.RegisterServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * TODO
 * @author ThinkPad
 * @date 2018/8/23 10:11
 * @param null
 * @return
 */

/**
 * @Controller作用于表现层，是spring-mvc的注解，具有将请求进行转发，重定向的功能。
 */
@Controller
@Slf4j
public class RegisterController {

    @Autowired
    public RegisterServiceImpl registerService;

    @Autowired
    public UserInfo user;

    @Autowired
    public EngineUserRepository engineUserRepository;

    /**
     * 用已经注册过的业务场景的id和账号登录，获取token之后才可以访问
     */
    @RequestMapping(method = RequestMethod.GET, value = "/registerQuery/{userId}")
    public @ResponseBody
    List<UserInfo> registerQuery(@PathVariable String userId) {

        return registerService.query(userId);
    }

    /**
     * 用已经注册过的业务场景的id和账号登录，获取token之后才可以访问
     * 如果不加@RequestBody，用postman的raw接收不到参数，需要用form data
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public @ResponseBody List<UserInfo> register(@RequestBody UserInfo user) {

        log.info("appId:" + user.getAppId());
        log.info("userId:" + user.getUserId());
        return registerService.register(user);
    }

    /**
     * 只有具有root权限的用户可以访问这个api
     * 用于注册业务场景
     */
    @RequestMapping(method=RequestMethod.POST, value="getAuth")
    public void getAuth(EngineUser engineUser) {

        engineUserRepository.save(engineUser);
    }

    /**
     * 注册到MongoDB数据库
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register_mongo")
    public @ResponseBody List<MongoRecord> registerMongo(@RequestBody MongoRecord user) {

        log.info("appId:" + user.getAppId());
        log.info("userId:" + user.getUserId());
        return registerService.registerMongo(user);
    }

}
