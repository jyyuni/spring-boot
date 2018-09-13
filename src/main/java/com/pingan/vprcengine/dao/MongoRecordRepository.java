package com.pingan.vprcengine.dao;

import com.pingan.vprcengine.bean.MongoRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 * MongoDB Repository
 * MongoRepository<MongoRecord, String>:T映射为MongoRecord, ID映射为String
 * @author ThinkPad
 * @date 2018/9/11 9:39
 * @param null
 * @return
 */
@Repository
public interface MongoRecordRepository extends MongoRepository<MongoRecord, String>{
    /**
     * 按照userId查找用户
     * @param u
     * @return
     */
    List<MongoRecord> findByUserId(String u);

    /**
     * 按照userId和appId查找用户
     * @param u
     * @param a
     * @return
     */
    List<MongoRecord> findByUserIdAndAppId(String u, String a);
}
