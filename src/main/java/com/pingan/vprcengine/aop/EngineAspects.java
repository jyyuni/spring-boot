package com.pingan.vprcengine.aop;

import com.pingan.vprcengine.bean.UserInfo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO
 * 切面，开始业务逻辑之前处理数据；返回数据之前记录数据到数据库中
 * 定义切面的步骤：
 * 1.声明bean
 * 2.申明切面@Aspect
 * 3.定义切点，以确定连接点
 * 4.写通知
 * @author
 * @date 2018/9/10 14:48
 * @return
 */

@Aspect
@Component
public class EngineAspects {
    @Before("execution(* com.pingan.vprcengine.service.impl.RegisterServiceImpl.*(..))" +
    "&& args(user)")
    public void ChangeScene(UserInfo user) {
        if(!user.getScene().equals(null)) {
            user.setAppId(user.getAppId()+user.getScene());
        }

    }
}
