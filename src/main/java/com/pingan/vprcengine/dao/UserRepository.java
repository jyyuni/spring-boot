package com.pingan.vprcengine.dao;

import com.pingan.vprcengine.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 * 继承JpaRepository,开启repository之后，会自动实现本接口，并提供18个数据查询方法
 *
 * @author ThinkPad
 * @date 2018/8/20 20:45
 * @param null
 * @return
 */

/**
 * @Repository注解于持久层，在注解了@Repository的类上如果数据库操作中抛出了异常，就能对其进行处理，
 * 转而抛出的是翻译后的spring专属数据库异常，方便我们对异常进行排查处理
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>, UserSweeper{

    /**
     * TODO
     * 利用领域特定语言DSL自定义查询方法
     */
    List<UserInfo> findByUserId(String userId);

    /**
     * TODO
     * 利用注解自定义查询方法
     */
    @Query("select user from UserInfo user where user.userId like 'test%'")
    List<UserInfo> findALLTestUser();

    /**
     *
     * 可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作。 注意： JPQL 不支持使用 INSERT；
     * 在 @Query 注解中编写 JPQL 语句， 但必须使用 @Modifying 进行修饰. 以通知 SpringData， 这是一个 UPDATE 或 DELETE 操作
     * UPDATE 或 DELETE 操作需要使用事务，此时需要定义 Service 层，在 Service 层的方法上添加事务操作@Transactional；
     * 默认情况下， SpringData 的每个方法上有事务， 但都是一个只读事务。 他们不能完成修改操作。
     */
    @Modifying
    @Query(value = "update UserInfo u set u.status = ?1 where u.status = ?0")
    int modifyStatusById(String status, Long id);

    /**
     * TODO
     * 混合自定义查询方法
     */
    @Override
    int eliteSweep();
}