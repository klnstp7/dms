package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.PageVo;

/**
 * Created by Administrator on 2017/2/10.
 */
public interface IPageService<T> extends IBaseService<T> {
    PageVo<T> FindByPagging(T conditon, int index, int rows);
}
