package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.HouseBaseDataHisMapper;
import com.yunfang.dms.dto.HouseBaseDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.HouseBaseDataHis;
import com.yunfang.dms.entity.HouseBaseDataHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IHouseBaseDataHisService;
import com.yunfang.dms.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class HouseBaseDataHisService implements IHouseBaseDataHisService {
    @Autowired
    private HouseBaseDataHisMapper mapper;

    public PageVo<HouseBaseDataHisDto> findByPaging(int start, int length, int draw, Long id) {
        HouseBaseDataHisCond cond = new HouseBaseDataHisCond();
        HouseBaseDataHisCond.Criteria criteria = cond.createCriteria();
        criteria.andHouseIdEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<HouseBaseDataHisDto> pageVo = new PageVo<HouseBaseDataHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<HouseBaseDataHis> HouseBaseDataHiss = mapper.selectByExample(cond);
        List<HouseBaseDataHisDto> result = new ArrayList<HouseBaseDataHisDto>();
        for (HouseBaseDataHis data : HouseBaseDataHiss) {
            result.add(MapperConfig.map(data, HouseBaseDataHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @Override
    public Boolean insert(HouseBaseDataHisDto dto){
        HouseBaseDataHis entiry=MapperConfig.map(dto, HouseBaseDataHis.class);
        return mapper.insert(entiry) > 0;
    }

    @Override
    public Boolean update(HouseBaseDataHisDto dto) {
        HouseBaseDataHis entity = MapperConfig.map(dto, HouseBaseDataHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    @Override
    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id)> 0;
    }

    @Override
    public HouseBaseDataHisDto get(Long id) {

        HouseBaseDataHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, HouseBaseDataHisDto.class);
    }


    @Override
    public List<HouseBaseDataHisDto> selectByCond(HouseBaseDataHisCond cond) {
        List<HouseBaseDataHis> list = mapper.selectByExample(cond);
        List<HouseBaseDataHisDto> result = new ArrayList<HouseBaseDataHisDto>();
        for (HouseBaseDataHis data : list) {
            result.add(MapperConfig.map(data, HouseBaseDataHisDto.class));
        }
        return result;
    }
}
