package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.BuildingBaseDataMapper;
import com.yunfang.dms.dto.BuildingBaseDataDto;
import com.yunfang.dms.entity.BuildingBaseData;
import com.yunfang.dms.entity.BuildingBaseDataCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IBuildingBaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service
public class BuildingBaseDataService implements IBuildingBaseDataService {

    @Autowired
    private BuildingBaseDataMapper buildingMapper;

    public Boolean insert(BuildingBaseDataDto dto) {
        BuildingBaseData entity = MapperConfig.map(dto, BuildingBaseData.class);
        return buildingMapper.insert(entity) > 0 ? true : false;
    }

    public Boolean update(BuildingBaseDataDto dto) {
        BuildingBaseData entity = MapperConfig.map(dto, BuildingBaseData.class);
        return buildingMapper.updateByPrimaryKey(entity) > 0 ? true : false;

    }

    public Boolean delete(Long id) {

        return buildingMapper.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    public BuildingBaseDataDto get(Long id) {

        BuildingBaseData entity = buildingMapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, BuildingBaseDataDto.class);
    }

    public List<BuildingBaseDataDto> selectByCond(BuildingBaseDataCond cond) {
        List<BuildingBaseData> list = buildingMapper.selectByExample(cond);
        List<BuildingBaseDataDto> result = new ArrayList<BuildingBaseDataDto>();
        for(BuildingBaseData data:list){
            result.add(MapperConfig.map(data, BuildingBaseDataDto.class));
        }
        return result;
    }


}
