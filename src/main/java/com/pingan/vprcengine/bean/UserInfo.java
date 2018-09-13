package com.pingan.vprcengine.bean;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO
 * 保存具体的用户信息
 * @author ThinkPad
 * @date 2018/8/20 16:26
 * @param null
 * @return
 */

/**
 * 在Hibernate中可以利用@DynamicInsert和@DynamicUpdate生成动态SQL语句，即在插入和修改数据的时候,语句中只包括要插入或者修改的字段。
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@DynamicInsert
@Serialization
@Repository
@Table(name="user_info")
public class UserInfo {

    /**
     * @GeneratedValue，@GenericGenerator使用hibernate的uuid主键生成器
     * @Column标记表示所持久化属性所映射表中的字段
     */
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    @Column(name = "id", nullable = false, length = 32, unique = true)
    private String id;

    @Column(name = "app_id", nullable = false, length = 32)
    private String appId;

    @Column(name = "scene", nullable = false, length = 32)
    private String scene;

    @Column(name = "user_id", nullable = false, length = 32)
    private String userId;

    @Column(name = "is_register", length = 32)
    private String isRegister;

    @Column(name = "is_verify", length = 32)
    private String isVerify;

    @Column(name = "status", length = 32)
    private String status;

}
