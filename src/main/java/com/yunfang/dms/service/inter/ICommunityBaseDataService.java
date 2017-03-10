package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.CommunityBaseDataDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.CommunityBaseDataCond;
import com.yunfang.dms.exception.CustomException;

import java.util.List;

/**
 * Created by Lthui on 2017/2/27.
 */
public interface ICommunityBaseDataService extends IPageService<CommunityBaseDataDto>,IBaseService<CommunityBaseDataDto,CommunityBaseDataCond> {
    UpLoadFileResultDto batchInsertCommunityBase(String filename, String configNodeName) throws CustomException;

    Boolean update(CommunityBaseDataDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids,Integer CompanyId) throws CustomException;
}
