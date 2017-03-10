package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.CommunityBaseDataHisMapper;
import com.yunfang.dms.dao.mapper.CommunityBaseDataHisMapper;
import com.yunfang.dms.dto.CommunityBaseDataHisDto;
import com.yunfang.dms.dto.CommunityBaseDataHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.CommunityBaseDataHis;
import com.yunfang.dms.entity.CommunityBaseDataHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.ICommunityBaseDataHisService;
import com.yunfang.dms.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class CommunityBaseDataHisService implements ICommunityBaseDataHisService {

    @Autowired
    private CommunityBaseDataHisMapper mapper;

    public PageVo<CommunityBaseDataHisDto> findByPaging(int start, int length, int draw, Long id) {
        CommunityBaseDataHisCond cond = new CommunityBaseDataHisCond();
        CommunityBaseDataHisCond.Criteria criteria = cond.createCriteria();
        criteria.andCommunityidEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<CommunityBaseDataHisDto> pageVo = new PageVo<CommunityBaseDataHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<CommunityBaseDataHis> CommunityBaseDataHiss = mapper.selectByExample(cond);
        List<CommunityBaseDataHisDto> result = new ArrayList<CommunityBaseDataHisDto>();
        for (CommunityBaseDataHis data : CommunityBaseDataHiss) {
            result.add(MapperConfig.map(data, CommunityBaseDataHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @Override
    public Boolean insert(CommunityBaseDataHisDto dto) {
        CommunityBaseDataHis entiry = MapperConfig.map(dto, CommunityBaseDataHis.class);
        return mapper.insert(entiry) > 0;
    }

    @Override
    public Boolean update(CommunityBaseDataHisDto dto) {
        CommunityBaseDataHis entity = MapperConfig.map(dto, CommunityBaseDataHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    @Override
    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public CommunityBaseDataHisDto get(Long id) {

        CommunityBaseDataHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, CommunityBaseDataHisDto.class);
    }


    @Override
    public List<CommunityBaseDataHisDto> selectByCond(CommunityBaseDataHisCond cond) {
        List<CommunityBaseDataHis> list = mapper.selectByExample(cond);
        List<CommunityBaseDataHisDto> result = new ArrayList<CommunityBaseDataHisDto>();
        for (CommunityBaseDataHis data : list) {
            result.add(MapperConfig.map(data, CommunityBaseDataHisDto.class));
        }
        return result;
    }
}
