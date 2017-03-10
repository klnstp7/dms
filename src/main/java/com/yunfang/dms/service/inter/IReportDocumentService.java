package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.dto.ReportDocumentDto;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public interface IReportDocumentService  {
    void upLoadReportFile(String dirPath,String reportNo) throws UnsupportedEncodingException;

    PageVo<ReportDocumentDto> getReports(int start, int length, int draw, long id);

    ReportDocumentDto get(long id);
}
