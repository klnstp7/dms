package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.HouseBaseDataDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.HouseBaseDataCond;
import com.yunfang.dms.exception.CustomException;

import java.util.List;

/**
 * Created by Lthui on 2017/2/27.
 */
public interface IHouseBaseDataService extends IPageService<HouseBaseDataDto>,IBaseService<HouseBaseDataDto,HouseBaseDataCond> {

    Boolean update(HouseBaseDataDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException;

    UpLoadFileResultDto batchInsertHouseBase(String filename, String configNodeName) throws CustomException;
}
