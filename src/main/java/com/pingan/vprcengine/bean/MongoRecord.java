package com.pingan.vprcengine.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

/**
 * TODO
 * MongoDB记录返回数据
 * @author ThinkPad
 * @date 2018/9/11 9:31
 * @param null
 * @return
 */
@Getter
@Setter
@ToString
@Document
@Repository
public class MongoRecord {
    @Id
    private String id;

    private String appId;

    private String scene;

    private String userId;

    private String isRegister;

    private String isVerify;

    private String status;
}
