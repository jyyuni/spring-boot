package com.pingan.vprcengine.service;

import com.pingan.vprcengine.bean.MongoRecord;
import com.pingan.vprcengine.bean.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 * @author ThinkPad
 * @date 2018/8/20 20:20
 * @param null
 * @return
 */

/**
 * @Component是一个通用的Spring容器管理的单例bean组件，
 * 可以被注入到spring容器进行管理可以被@Repository, @Service, @Controller
 * @Service, @Controller , @Repository = {@Component + 一些特定的功能}。这个就意味着这些注解在部分功能上是一样的。
 * @Controller表现层：注解类进行前端请求的处理，转发，重定向。包括调用Service层的方法
 * @Service业务逻辑层：注解类处理业务逻辑
 * @Repository持久层：注解类作为DAO对象（数据访问对象，Data Access Objects），这些类可以直接对数据库进行操作
 * 有这些分层操作的话，代码之间就实现了松耦合，代码之间的调用也清晰明朗，便于项目的管理；
 * 假想一下，如果只用@Controller注解，那么所有的请求转发，业务处理，数据库操作代码都糅合在一个地方，那这样的代码该有多难拓展和维护。
 *
 * @Transactional添加事物操作
 */
@Service
@Transactional
public interface RegisterService {

    /**
     * TODO
     * 注册
     * 通过webSocket与外部程序通讯，获取注册结果，并将结果写到数据库中
     * @author ThinkPad
     * @date 2018/8/20 20:21
     * @param null
     * @return
     */
    List<UserInfo> register(UserInfo user);

    /**
     * TODO
     * 查询注册结果
     * 依据appId和userId查询关系型数据库，获取注册结果
     * @author ThinkPad
     * @date 2018/8/20 20:22
     * @param null
     * @return
     */
    List<UserInfo> query(String userId);

    /**
     * 注册至MongoDB
     * @param user
     * @return
     */
    List<MongoRecord> registerMongo(MongoRecord user);
}
