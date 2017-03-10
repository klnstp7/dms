package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.BuildingBaseDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.BuildingBaseDataHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface IBuildingBaseDataHisService extends IBaseService<BuildingBaseDataHisDto,BuildingBaseDataHisCond> {
    PageVo<BuildingBaseDataHisDto> findByPaging(int start, int length, int draw, Long id);
}
