package com.yunfang.dms.service.inter;

import java.util.List;

/**业务基础接口
 * Created by Administrator on 2017/2/7.
 */
public interface IBaseService<T,C> {
    Boolean insert(T dto);

    Boolean update(T dto);

    Boolean delete(Long id);

    T get(Long id);

    List<T> selectByCond(C cond);
}
