package com.haitaiinc.adscreenserver.mapper;

import com.haitaiinc.adscreenserver.entity.ReportData;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDataMapper {
    public void queryReportData(ReportData reportData);
}
