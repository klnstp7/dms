package com.yunfang.dms.service.inter;

import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.entity.ExtendConfigCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;

import java.util.List;
/**
 * Created by lthui on 2017/2/13.
 */
public interface IExtendConfigService {

    /**
     * 插入
     * @param dto
     * @return
     */
    Boolean insert(ExtendConfigDto dto) throws CustomException;

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean delete(Long id,Integer companyId) throws CustomException;

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    ExtendConfigDto get(Long id);

    List<ExtendConfigDto> selectByCond(ExtendConfigCond cond);

//    String getExtendTitleString(Integer companyId, SourceTableEmum sourceTableEmum);

    List<ExtendConfigDto> getExtendTitleList(Integer companyId, Integer sourceTableEmumValue);

    List<ExtendConfigDto> getExtendTitleList(Integer companyId, Integer sourceTableEmumValue, CityInfoDto cityInfoDto);

    List<String> getExtendList(Integer companyId, Integer sourceTableEmumValue);
}
