package com.haitaiinc.adscreenserver.config;

import com.haitaiinc.adscreenserver.interceptor.RequestVerifyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LocalConfig implements WebMvcConfigurer {
    @Autowired
    private RequestVerifyInterceptor requestVerifyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestVerifyInterceptor).addPathPatterns("/**").excludePathPatterns("/error");
    }
}
