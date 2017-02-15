package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.ExtendConfigMapper;
import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.entity.ExtendConfig;
import com.yunfang.dms.entity.ExtendConfigCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IExtendConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by lthui on 2017/2/13.
 */
@Service
public class ExtendConfigService implements IExtendConfigService {
    @Autowired
    private ExtendConfigMapper buildingMapper;

    public Boolean insert(ExtendConfigDto dto) {
//        ExtendConfig entity = MapperConfig.map(dto, ExtendConfig.class);
        ExtendConfig entity =new ExtendConfig();
        entity.setSourceTable(dto.getSourceTable().ordinal());
        entity.setColumnName(dto.getColumnName());
        entity.setCompanyId(dto.getCompanyId());
        entity.setCreateDateTime(dto.getCreateDateTime());
        entity.setOperator(dto.getOperator());
        return buildingMapper.insert(entity) > 0 ? true : false;
    }

    public Boolean update(ExtendConfigDto dto) {
//        ExtendConfig entity = MapperConfig.map(dto, ExtendConfig.class);
        ExtendConfig entity =new ExtendConfig();
        entity.setId(dto.getId());
        entity.setSourceTable(dto.getSourceTable().ordinal());
        entity.setColumnName(dto.getColumnName());
        entity.setCompanyId(dto.getCompanyId());
        entity.setCreateDateTime(dto.getCreateDateTime());
        entity.setOperator(dto.getOperator());
        return buildingMapper.updateByPrimaryKey(entity) > 0 ? true : false;

    }

    public Boolean delete(Long id) {
        return buildingMapper.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    public ExtendConfigDto get(Long id) {
        ExtendConfig entity = buildingMapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, ExtendConfigDto.class);
    }

    public List<ExtendConfigDto> selectByCond(ExtendConfigCond cond) {
        List<ExtendConfig> list = buildingMapper.selectByExample(cond);
        List<ExtendConfigDto> result = new ArrayList<ExtendConfigDto>();
        for(ExtendConfig data:list){
            result.add(MapperConfig.map(data, ExtendConfigDto.class));
        }
        return result;
    }
}
