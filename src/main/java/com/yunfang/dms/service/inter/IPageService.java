package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.PageVo;

/**
 * Created by Administrator on 2017/2/10.
 */
public interface IPageService<T>{
    PageVo<T> findByPaging(int start, int length,int draw,String filter,int companyId);
}
