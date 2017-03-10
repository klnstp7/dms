package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.OfferCaseHisMapper;
import com.yunfang.dms.dto.OfferCaseHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.OfferCaseHis;
import com.yunfang.dms.entity.OfferCaseHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IOfferCaseHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lthui on 2017/3/3.
 */
@Service
public class OfferCaseHisService implements IOfferCaseHisService {
    @Autowired
    private OfferCaseHisMapper mapper;

    public Boolean insert(OfferCaseHisDto dto) {
        OfferCaseHis entity = MapperConfig.map(dto, OfferCaseHis.class);
        return mapper.insert(entity) > 0;
    }

    public Boolean update(OfferCaseHisDto dto) {
        OfferCaseHis entity = MapperConfig.map(dto, OfferCaseHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id)> 0;
    }

    public OfferCaseHisDto get(Long id) {

        OfferCaseHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, OfferCaseHisDto.class);
    }

    public List<OfferCaseHisDto> selectByCond(OfferCaseHisCond cond) {
        List<OfferCaseHis> list = mapper.selectByExample(cond);
        List<OfferCaseHisDto> result = new ArrayList<OfferCaseHisDto>();
        for(OfferCaseHis data:list){
            result.add(MapperConfig.map(data, OfferCaseHisDto.class));
        }
        return result;
    }

    public PageVo<OfferCaseHisDto> findByPaging(int start, int length, int draw, Long id) {
        OfferCaseHisCond cond = new OfferCaseHisCond();
        OfferCaseHisCond.Criteria criteria = cond.createCriteria();
        criteria.andOfferCaseIdEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<OfferCaseHisDto> pageVo = new PageVo<OfferCaseHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<OfferCaseHis> OfferCaseHiss = mapper.selectByExample(cond);
        List<OfferCaseHisDto> result = new ArrayList<OfferCaseHisDto>();
        for (OfferCaseHis data : OfferCaseHiss) {
            result.add(MapperConfig.map(data, OfferCaseHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
}
