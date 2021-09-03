package com.haitaiinc.adscreenserver.service;

import com.haitaiinc.adscreenserver.entity.ReportData;
import com.haitaiinc.adscreenserver.mapper.ReportDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportDataService {
    @Autowired
    ReportDataMapper reportDataMapper;
    public void queryReportData(ReportData reportData){
        reportDataMapper.queryReportData(reportData);
    }
}
