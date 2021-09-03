package com.haitaiinc.adscreenserver.entity;

import lombok.Data;

@Data
public class ScreenClient {
    private String clientId;
    private String clientIpAddress;
    private String clientDesc;
    private String clientPage;
    private String flag;
}
