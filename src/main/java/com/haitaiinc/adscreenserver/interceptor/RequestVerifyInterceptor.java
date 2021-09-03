package com.haitaiinc.adscreenserver.interceptor;


import com.haitaiinc.adscreenserver.annotation.RequestVerify;
import com.haitaiinc.adscreenserver.common.LocalUtil;
import com.haitaiinc.adscreenserver.response.RespEnum;
import com.haitaiinc.adscreenserver.service.ScreenClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class RequestVerifyInterceptor extends BaseInterceptor{
    @Autowired
    private ScreenClientService screenClientService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Url=="+request.getRequestURL().toString());
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod method = (HandlerMethod)handler;
        RequestVerify requestVerify = method.getMethodAnnotation(RequestVerify.class);
        if(requestVerify!=null&&!requestVerify.isVerifyIP()){
            return true;
        }

        String ip = LocalUtil.getIp(request);
        log.info("ipAddress="+ip);
        if(screenClientService.isEffectiveIP(ip)){
            setResponse(request,response, RespEnum.NO_AUTH);
            return false;
        }
        return true;
    }

}
