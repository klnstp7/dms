package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.BuildingBaseDataHisMapper;
import com.yunfang.dms.dto.BuildingBaseDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.BuildingBaseDataHis;
import com.yunfang.dms.entity.BuildingBaseDataHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IBuildingBaseDataHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class BuildingBaseDataHisService implements IBuildingBaseDataHisService {
    @Autowired
    private BuildingBaseDataHisMapper mapper;

    public Boolean insert(BuildingBaseDataHisDto dto) {
        BuildingBaseDataHis entity = MapperConfig.map(dto, BuildingBaseDataHis.class);
        return mapper.insert(entity) > 0;
    }

    public Boolean update(BuildingBaseDataHisDto dto) {
        BuildingBaseDataHis entity = MapperConfig.map(dto, BuildingBaseDataHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id)> 0;
    }

    public BuildingBaseDataHisDto get(Long id) {

        BuildingBaseDataHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, BuildingBaseDataHisDto.class);
    }

    public List<BuildingBaseDataHisDto> selectByCond(BuildingBaseDataHisCond cond) {
        List<BuildingBaseDataHis> list = mapper.selectByExample(cond);
        List<BuildingBaseDataHisDto> result = new ArrayList<BuildingBaseDataHisDto>();
        for(BuildingBaseDataHis data:list){
            result.add(MapperConfig.map(data, BuildingBaseDataHisDto.class));
        }
        return result;
    }

    public PageVo<BuildingBaseDataHisDto> findByPaging(int start, int length, int draw, Long id) {
        BuildingBaseDataHisCond cond = new BuildingBaseDataHisCond();
        BuildingBaseDataHisCond.Criteria criteria = cond.createCriteria();
        criteria.andBuildingidEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<BuildingBaseDataHisDto> pageVo = new PageVo<BuildingBaseDataHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<BuildingBaseDataHis> BuildingBaseDataHiss = mapper.selectByExample(cond);
        List<BuildingBaseDataHisDto> result = new ArrayList<BuildingBaseDataHisDto>();
        for (BuildingBaseDataHis data : BuildingBaseDataHiss) {
            result.add(MapperConfig.map(data, BuildingBaseDataHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
}
