package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.dto.OfferCaseDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.OfferCaseCond;
import com.yunfang.dms.exception.CustomException;

import java.util.List;

/**
 * Created by Lthui on 2017/2/22.
 */
public interface IOfferCaseService extends IPageService<OfferCaseDto>,IBaseService<OfferCaseDto,OfferCaseCond> {
    List<OfferCaseDto> selectByCond(OfferCaseCond cond,CityInfoDto cityInfoDto);

    UpLoadFileResultDto batchInsertOfferCaseData(String filename, String configNodeName) throws CustomException;

    Boolean update(OfferCaseDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids,Integer CompanyId) throws CustomException;
}
