package com.pingan.vprcengine.service.impl;

import com.pingan.vprcengine.bean.MongoRecord;
import com.pingan.vprcengine.bean.UserInfo;
import com.pingan.vprcengine.dao.MongoRecordRepository;
import com.pingan.vprcengine.dao.UserRepository;
import com.pingan.vprcengine.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * @author xwy
 * @date 2018/8/20 15:12
 * @return
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    public UserRepository  userRepository;

    @Autowired
    public MongoRecordRepository mongoRecordRepository;

    @Override
    public List<UserInfo> register(UserInfo user) {
        List<UserInfo> userInfo = new ArrayList<>();
        userRepository.save(user);
        userInfo.add(user);
        return userInfo;
    }

    @Override
    public List<UserInfo> query(String userId) {

        return userRepository.findByUserId(userId);

    }

    @Override
    public List<MongoRecord> registerMongo(MongoRecord user) {
        List<MongoRecord> userInfo = new ArrayList<>();
        mongoRecordRepository.save(user);
        userInfo.add(user);
        return userInfo;
    }


}

