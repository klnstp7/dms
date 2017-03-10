package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.BuildingBaseDataDto;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.BuildingBaseDataCond;
import com.yunfang.dms.exception.CustomException;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
public interface IBuildingBaseDataService extends IBaseService<BuildingBaseDataDto,BuildingBaseDataCond>,IPageService<BuildingBaseDataDto> {

    /**
     * 插入
     * @param dto
     * @return
     */
    @Override
    Boolean insert(BuildingBaseDataDto dto);

    /**
     * 更新
     * @param dto
     * @return
     */
    @Override
    Boolean update(BuildingBaseDataDto dto);

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    Boolean delete(Long id);

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    @Override
    BuildingBaseDataDto get(Long id);

    @Override
    List<BuildingBaseDataDto> selectByCond(BuildingBaseDataCond cond);

    UpLoadFileResultDto batchInsertBuildingBase(String filename, String configNodeName) throws CustomException;
    Boolean update(BuildingBaseDataDto dto,Integer CompanyId, String userName) throws CustomException;

    Boolean delete(Long id,Integer CompanyId) throws CustomException;

    Boolean batchDelete(List<Long> ids,Integer CompanyId) throws CustomException;
}
