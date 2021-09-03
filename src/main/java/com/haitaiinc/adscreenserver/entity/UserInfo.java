package com.haitaiinc.adscreenserver.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class UserInfo {
    private String userId;
    private String userName;

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
