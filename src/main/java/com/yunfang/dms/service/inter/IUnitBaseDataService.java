package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.UnitBaseDataDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.UnitBaseDataCond;
import com.yunfang.dms.exception.CustomException;

import java.util.List;

/**
 * Created by Lthui on 2017/2/27.
 */
public interface IUnitBaseDataService extends IPageService<UnitBaseDataDto>,IBaseService<UnitBaseDataDto,UnitBaseDataCond> {
    UpLoadFileResultDto batchInsertUnitBase(String filename, String configNodeName) throws CustomException;
    Boolean update(UnitBaseDataDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException;
}
