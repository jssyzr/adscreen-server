package com.haitaiinc.adscreenserver.interceptor;

import com.alibaba.fastjson.JSON;
import com.haitaiinc.adscreenserver.response.BaseRespInfoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class BaseInterceptor implements HandlerInterceptor {


    public void setResponse(HttpServletRequest request,
                            HttpServletResponse response, BaseRespInfoInterface errorInfoInterface) {

        response.setContentType("application/json;charset=UTF-8");
        try (Writer writer = response.getWriter()) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("code", errorInfoInterface.getResultCode());
            resultMap.put("message", errorInfoInterface.getResultMsg());

            logger(request, resultMap);
            JSON.writeJSONString(writer, resultMap);
            writer.flush();
        } catch (IOException e) {
            log.error("respose 设置操作异常：" + e);
        }
    }


    /**
     * 记录日志
     */
    private void logger(HttpServletRequest request, Map<String, Object> resultMap) {
        StringBuffer msg = new StringBuffer();
        msg.append("异常拦截日志:");
        msg.append("[uri:").append(request.getRequestURI()).append("]");
        Enumeration<String> enumer = request.getParameterNames();
        while (enumer.hasMoreElements()) {
            String name = enumer.nextElement();
            String[] values = request.getParameterValues(name);
            msg.append("[").append(name).append("=");
            if (values != null) {
                int i = 0;
                for (String value : values) {
                    i++;
                    msg.append(value);
                    if (i < values.length) {
                        msg.append("｜");
                    }
                }
            }
            msg.append("]");
        }
        msg.append(JSON.toJSONString(resultMap));

        log.warn(msg.toString());
    }
}

