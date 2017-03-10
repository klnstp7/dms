package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.dto.ReportCaseDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.ReportCaseCond;
import com.yunfang.dms.exception.CustomException;

import java.util.List;

/**
 * Created by Lthui on 2017/2/22.
 */
public interface IReportCaseService extends IPageService<ReportCaseDto>,IBaseService<ReportCaseDto,ReportCaseCond> {
    List<ReportCaseDto> selectByCond(ReportCaseCond cond,CityInfoDto cityInfoDto);

    UpLoadFileResultDto batchInsertReportCaseData(String filename, String configNodeName) throws CustomException;

    Boolean update(ReportCaseDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids,Integer CompanyId) throws CustomException;
}
