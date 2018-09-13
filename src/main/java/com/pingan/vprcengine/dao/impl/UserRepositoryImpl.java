package com.pingan.vprcengine.dao.impl;

import com.pingan.vprcengine.dao.UserSweeper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pingan.vprcengine.bean.UserInfo;
/**
 * TODO
 * 混合自定义查询方法
 * 类名必须是原来的UserRepository + impl(后缀名可以通过设置repository-impl-postfix修改）
 * @author ThinkPad
 * @date 2018/8/21 9:42
 * @param null
 * @return
 */
@Repository
public class UserRepositoryImpl implements UserSweeper {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int eliteSweep() {
        String update = "UPDATE UserInfo user SET user.status = '0000' WHERE user.is_register = 'true'";
        return em.createQuery(update).executeUpdate();
    }
}
