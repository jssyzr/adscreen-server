package com.haitaiinc.adscreenserver.mapper;

import com.haitaiinc.adscreenserver.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    public UserInfo getUserByUserID(String userId);

    public void getUserName(UserInfo parameterMap);
}
