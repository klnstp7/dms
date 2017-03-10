package com.yunfang.dms.service.inter;


import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.dto.InquiryDataDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.InquiryData;
import com.yunfang.dms.entity.InquiryDataCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import org.dom4j.DocumentException;

import java.util.List;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */

public interface IInquiryDataService extends IBaseService<InquiryDataDto,InquiryDataCond>,IPageService<InquiryDataDto> {
    List<InquiryDataDto> selectByCond(InquiryDataCond cond,CityInfoDto cityInfoDto);
    /*
    * 批量导入Excel数据
    * */
    UpLoadFileResultDto batchInsertInquiryData(String filename, String configNodeName) throws CustomException;

    Boolean update(InquiryDataDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids,Integer CompanyId) throws CustomException;
}
