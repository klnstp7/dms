package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.OfferCaseHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.OfferCaseHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface IOfferCaseHisService extends IBaseService<OfferCaseHisDto,OfferCaseHisCond> {
    PageVo<OfferCaseHisDto> findByPaging(int start, int length, int draw, Long id);
}
