package com.pingan.vprcengine.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * TODO
 * 可访问本应用的业务的角色
 * @author ThinkPad
 * @date 2018/8/23 18:00
 * @param null
 * @return
 */

/**
 * @Entity定义相应的实体类，在应用启动时，系统会根据实体类创建相应的数据表
 */
@Entity
@Getter
@Setter
@ToString
public class EngineRole {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    @Column(name = "id", nullable = false, length = 32, unique = true)
    private Long id;

    @Column(name = "role", nullable = false, length = 32)
    private String role;
}
