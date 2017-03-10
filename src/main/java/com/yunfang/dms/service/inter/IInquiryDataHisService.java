package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.InquiryDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.InquiryDataHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface IInquiryDataHisService extends IBaseService<InquiryDataHisDto,InquiryDataHisCond> {
    PageVo<InquiryDataHisDto> findByPaging(int start, int length, int draw, Long id);
}
