package com.haitaiinc.adscreenserver.service;

import com.haitaiinc.adscreenserver.entity.ScreenClient;
import com.haitaiinc.adscreenserver.mapper.ScreenClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenClientService {
    @Autowired
    ScreenClientMapper screenClientMapper;

    public ScreenClient getScreenClientByIP(String ipAddress){
        return screenClientMapper.getScreenClientByIP(ipAddress);
    }

    /**
     * 判断IP是否有效
     * @param ipAddress
     * @return
     */
    public boolean isEffectiveIP(String ipAddress){
        ScreenClient client = getScreenClientByIP(ipAddress);
        if(client==null||!client.getFlag().equals("Y")){
            return false;
        }else{
            return true;
        }
    }
}
