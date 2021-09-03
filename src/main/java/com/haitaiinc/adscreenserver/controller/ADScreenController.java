package com.haitaiinc.adscreenserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.haitaiinc.adscreenserver.annotation.RequestVerify;
import com.haitaiinc.adscreenserver.entity.ReportData;
import com.haitaiinc.adscreenserver.response.ResultEntity;
import com.haitaiinc.adscreenserver.service.ReportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ADScreenController {
    @Autowired
    ReportDataService reportDataService;

    @RequestMapping(path = "/financial/query")
    @RequestVerify(isVerifyIP = false)
    public String queryReportData(@RequestParam String reportId,@RequestParam(required = false,defaultValue = "") String inParam){
        ReportData reportData = new ReportData();
        reportData.setReportId(reportId);
        reportData.setInParam(inParam);
        reportDataService.queryReportData(reportData);
        Object json = JSONObject.toJSON(reportData.getOutParam());
        String resp = ResultEntity.success(json).toString();
        return resp;
    }
}
