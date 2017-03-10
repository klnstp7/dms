package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.ReportCaseHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.ReportCaseHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface IReportCaseHisService extends IBaseService<ReportCaseHisDto,ReportCaseHisCond> {
    PageVo<ReportCaseHisDto> findByPaging(int start, int length, int draw, Long id);
}
