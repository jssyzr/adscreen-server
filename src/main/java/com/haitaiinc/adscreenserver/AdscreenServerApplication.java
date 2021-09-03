package com.haitaiinc.adscreenserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.haitaiinc.adscreenserver.mapper")
@SpringBootApplication
public class AdscreenServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdscreenServerApplication.class, args);
    }

}
