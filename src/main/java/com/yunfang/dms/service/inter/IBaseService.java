package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.PageVo;

import java.util.List;

/**业务基础接口
 * Created by Administrator on 2017/2/7.
 */
public interface IBaseService<T> {
    Boolean insert(T dto);

    Boolean update(T dto);

    Boolean delete(Long id);

    T get(Long id);

}
