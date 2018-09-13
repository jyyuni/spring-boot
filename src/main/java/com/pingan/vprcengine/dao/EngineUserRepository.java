package com.pingan.vprcengine.dao;

import com.pingan.vprcengine.bean.EngineUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 * 用户权限查询接口，对应于EngineUser表的用户的权限查询
 * @author ThinkPad
 * @date 2018/8/23 20:36
 * @param null
 * @return
 */
@Repository
public interface EngineUserRepository extends JpaRepository<EngineUser, Long> {

    EngineUser findByUsername(String username);

}
