package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.dto.TransactionCaseDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.TransactionCaseCond;
import com.yunfang.dms.exception.CustomException;

import java.util.List;

/**
 * Created by Lthui on 2017/2/22.
 */
public interface ITransactionCaseService extends IPageService<TransactionCaseDto>,IBaseService<TransactionCaseDto,TransactionCaseCond> {
    List<TransactionCaseDto> selectByCond(TransactionCaseCond cond,CityInfoDto cityInfoDto);

    UpLoadFileResultDto batchInsertTranCaseData(String filename, String configNodeName) throws CustomException;

    Boolean update(TransactionCaseDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids,Integer CompanyId) throws CustomException;
}
