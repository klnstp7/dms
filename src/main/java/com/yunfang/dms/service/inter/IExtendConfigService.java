package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.entity.ExtendConfigCond;

import java.util.List;
/**
 * Created by lthui on 2017/2/13.
 */
public interface IExtendConfigService extends IBaseService<ExtendConfigDto> {

    /**
     * 插入
     * @param dto
     * @return
     */
    @Override
    Boolean insert(ExtendConfigDto dto);

    /**
     * 更新
     * @param dto
     * @return
     */
    @Override
    Boolean update(ExtendConfigDto dto);

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
    ExtendConfigDto get(Long id);

    List<ExtendConfigDto> selectByCond(ExtendConfigCond cond);
}
