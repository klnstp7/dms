package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.TransactionCaseHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.TransactionCaseHisCond;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface ITransactionCaseHisService extends IBaseService<TransactionCaseHisDto,TransactionCaseHisCond> {
    PageVo<TransactionCaseHisDto> findByPaging(int start, int length, int draw, Long id);
}
