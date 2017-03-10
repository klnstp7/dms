package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.HouseBaseDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.HouseBaseDataHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface IHouseBaseDataHisService extends IBaseService<HouseBaseDataHisDto,HouseBaseDataHisCond> {
    PageVo<HouseBaseDataHisDto> findByPaging(int start, int length, int draw, Long id);
}
