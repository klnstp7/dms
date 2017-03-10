package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.CommunityBaseDataDto;
import com.yunfang.dms.dto.CommunityBaseDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.CommunityBaseDataCond;
import com.yunfang.dms.entity.CommunityBaseDataHis;
import com.yunfang.dms.entity.CommunityBaseDataHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface ICommunityBaseDataHisService extends IBaseService<CommunityBaseDataHisDto,CommunityBaseDataHisCond> {
    PageVo<CommunityBaseDataHisDto> findByPaging(int start, int length, int draw, Long id);
}
