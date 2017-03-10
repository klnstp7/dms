package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.UnitBaseDataHisMapper;
import com.yunfang.dms.dao.mapper.UnitBaseDataMapper;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.dto.UnitBaseDataDto;
import com.yunfang.dms.dto.UnitBaseDataHisDto;
import com.yunfang.dms.entity.UnitBaseData;
import com.yunfang.dms.entity.UnitBaseDataCond;
import com.yunfang.dms.entity.UnitBaseDataHis;
import com.yunfang.dms.entity.UnitBaseDataHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IUnitBaseDataHisService;
import com.yunfang.dms.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class UnitBaseDataHisService implements IUnitBaseDataHisService {
    @Autowired
    private UnitBaseDataHisMapper mapper;

    public PageVo<UnitBaseDataHisDto> findByPaging(int start, int length, int draw, Long id) {
        UnitBaseDataHisCond cond = new UnitBaseDataHisCond();
        UnitBaseDataHisCond.Criteria criteria = cond.createCriteria();
        criteria.andUnitIdEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<UnitBaseDataHisDto> pageVo = new PageVo<UnitBaseDataHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<UnitBaseDataHis> unitBaseDatas = mapper.selectByExample(cond);
        List<UnitBaseDataHisDto> result = new ArrayList<UnitBaseDataHisDto>();
        for (UnitBaseDataHis data : unitBaseDatas) {
            result.add(MapperConfig.map(data, UnitBaseDataHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @Override
    public Boolean insert(UnitBaseDataHisDto dto) {
        UnitBaseDataHis entiry = MapperConfig.map(dto, UnitBaseDataHis.class);
        return mapper.insert(entiry) > 0;
    }

    @Override
    public Boolean update(UnitBaseDataHisDto dto) {
        UnitBaseDataHis entity = MapperConfig.map(dto, UnitBaseDataHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    @Override
    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UnitBaseDataHisDto get(Long id) {

        UnitBaseDataHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, UnitBaseDataHisDto.class);
    }

    @Override
    public List<UnitBaseDataHisDto> selectByCond(UnitBaseDataHisCond cond) {
        List<UnitBaseDataHis> list = mapper.selectByExample(cond);
        List<UnitBaseDataHisDto> result = new ArrayList<UnitBaseDataHisDto>();
        for (UnitBaseDataHis data : list) {
            result.add(MapperConfig.map(data, UnitBaseDataHisDto.class));
        }
        return result;
    }
}
