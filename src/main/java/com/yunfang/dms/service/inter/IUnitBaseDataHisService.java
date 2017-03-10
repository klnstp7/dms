package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.dto.UnitBaseDataDto;
import com.yunfang.dms.dto.UnitBaseDataHisDto;
import com.yunfang.dms.entity.UnitBaseDataCond;
import com.yunfang.dms.entity.UnitBaseDataHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface IUnitBaseDataHisService extends IBaseService<UnitBaseDataHisDto,UnitBaseDataHisCond> {
    PageVo<UnitBaseDataHisDto> findByPaging(int start, int length, int draw, Long id);
}
