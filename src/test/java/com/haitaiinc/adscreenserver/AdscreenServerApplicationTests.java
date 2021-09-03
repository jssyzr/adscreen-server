package com.haitaiinc.adscreenserver;

import com.haitaiinc.adscreenserver.entity.ReportData;
import com.haitaiinc.adscreenserver.entity.UserInfo;
import com.haitaiinc.adscreenserver.service.ReportDataService;
import com.haitaiinc.adscreenserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AdscreenServerApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    ReportDataService reportDataService;
    @Test
    void contextLoads() {
    }

    @Test
    void getUserInfoByUserID(){

        log.info("cm11");
        UserInfo userInfo = userService.getUserInfoByUserID("admin");
        log.info(userInfo.toString());
    }

    @Test
    void getUserName(){
        String userName = userService.getUserName("admin");
        log.info(userName);
    }

    @Test
    void queryData(){
        ReportData reportData = new ReportData();
        reportData.setReportId("01");
        reportDataService.queryReportData(reportData);
        log.info(reportData.getOutParam());
    }

}
