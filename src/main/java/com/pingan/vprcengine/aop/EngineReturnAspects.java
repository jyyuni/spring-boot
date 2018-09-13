package com.pingan.vprcengine.aop;

import com.pingan.vprcengine.bean.MongoRecord;
import com.pingan.vprcengine.dao.MongoRecordRepository;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * TODO
 * 返回数据之前记录数据到数据库mogodb中,没有实现，不知道怎么获取字段名和字段值
 * @After与@Afterreturning的区别是：
 * @After会在目标方法正常返回或者出现异常时调用
 * @Afterreturning只会在正常返回之后调用
 * @author
 * @date 2018/9/10 14:48
 * @return
 */

@Aspect
@Component
@Slf4j
public class EngineReturnAspects {
    //@Autowired
    //MongoRecordRepository mongoRecordRepository;

    //@Autowired
    //MongoRecord mongoRecord;

    @AfterReturning(pointcut = "execution(* com.pingan.vprcengine.controller.RegisterController.*(..))",returning = "response")
    public void mongoRecord(JoinPoint joinPoint, HttpResponse response) {
        Object[] args = joinPoint.getArgs();
        //mongoRecord.setId(args[0].toString());
        //mongoRecord.setAppId(args.get(1).toString());
        //mongoRecord.setScene(args.get(2).toString());
        //mongoRecord.setUserId(args.get(3).toString());
        //mongoRecord.setIsRegister(args.get(4).toString());
        //mongoRecord.setIsVerify(args.get(5).toString());
        //mongoRecord.setStatus(args.get(6).toString());
        //mongoRecordRepository.save(mongoRecord);
        log.info("record register result 0:" + args[0].toString());
    }
}
