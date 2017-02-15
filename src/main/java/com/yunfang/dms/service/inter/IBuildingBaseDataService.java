package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.BuildingBaseDataDto;
import com.yunfang.dms.entity.BuildingBaseDataCond;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
public interface IBuildingBaseDataService extends IBaseService<BuildingBaseDataDto> {

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

    List<BuildingBaseDataDto> selectByCond(BuildingBaseDataCond cond);
}
