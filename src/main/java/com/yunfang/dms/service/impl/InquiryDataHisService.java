package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.InquiryDataHisMapper;
import com.yunfang.dms.dto.InquiryDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.InquiryDataHis;
import com.yunfang.dms.entity.InquiryDataHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IInquiryDataHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lthui on 2017/3/3.
 */
@Service
public class InquiryDataHisService implements IInquiryDataHisService {
    @Autowired
    private InquiryDataHisMapper mapper;

    public Boolean insert(InquiryDataHisDto dto) {
        InquiryDataHis entity = MapperConfig.map(dto, InquiryDataHis.class);
        return mapper.insert(entity) > 0;
    }

    public Boolean update(InquiryDataHisDto dto) {
        InquiryDataHis entity = MapperConfig.map(dto, InquiryDataHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    public Boolean delete(Long id) {
        return mapper.deleteByPrimaryKey(id)> 0;
    }

    public InquiryDataHisDto get(Long id) {
        InquiryDataHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, InquiryDataHisDto.class);
    }

    public List<InquiryDataHisDto> selectByCond(InquiryDataHisCond cond) {
        List<InquiryDataHis> list = mapper.selectByExample(cond);
        List<InquiryDataHisDto> result = new ArrayList<InquiryDataHisDto>();
        for(InquiryDataHis data:list){
            result.add(MapperConfig.map(data, InquiryDataHisDto.class));
        }
        return result;
    }

    public PageVo<InquiryDataHisDto> findByPaging(int start, int length, int draw, Long id) {
        InquiryDataHisCond cond = new InquiryDataHisCond();
        InquiryDataHisCond.Criteria criteria = cond.createCriteria();
        criteria.andInquiryDataIdEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<InquiryDataHisDto> pageVo = new PageVo<InquiryDataHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<InquiryDataHis> InquiryDataHiss = mapper.selectByExample(cond);
        List<InquiryDataHisDto> result = new ArrayList<InquiryDataHisDto>();
        for (InquiryDataHis data : InquiryDataHiss) {
            result.add(MapperConfig.map(data, InquiryDataHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
}
