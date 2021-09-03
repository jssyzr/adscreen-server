package com.haitaiinc.adscreenserver.service;

import com.haitaiinc.adscreenserver.entity.UserInfo;
import com.haitaiinc.adscreenserver.mapper.UserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public UserInfo getUserInfoByUserID(String userId){
        return userMapper.getUserByUserID(userId);
    }

    public String getUserName(String userId){
//        Map<String, String> parameterMap = new HashMap<String, String>();
//        parameterMap.put("userId",userId);
//        parameterMap.put("userName","");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userMapper.getUserName(userInfo);
        return userInfo.getUserName();
    }

}
