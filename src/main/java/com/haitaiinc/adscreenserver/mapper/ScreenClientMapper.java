package com.haitaiinc.adscreenserver.mapper;

import com.haitaiinc.adscreenserver.entity.ScreenClient;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenClientMapper {
    public ScreenClient getScreenClientByIP(String ipAddress);
}
