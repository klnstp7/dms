package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.ReportCaseHisMapper;
import com.yunfang.dms.dto.ReportCaseHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.ReportCaseHis;
import com.yunfang.dms.entity.ReportCaseHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IReportCaseHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class ReportCaseHisService implements IReportCaseHisService {
    @Autowired
    private ReportCaseHisMapper mapper;

    public Boolean insert(ReportCaseHisDto dto) {
        ReportCaseHis entity = MapperConfig.map(dto, ReportCaseHis.class);
        return mapper.insert(entity) > 0;
    }

    public Boolean update(ReportCaseHisDto dto) {
        ReportCaseHis entity = MapperConfig.map(dto, ReportCaseHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id)> 0;
    }

    public ReportCaseHisDto get(Long id) {

        ReportCaseHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, ReportCaseHisDto.class);
    }

    public List<ReportCaseHisDto> selectByCond(ReportCaseHisCond cond) {
        List<ReportCaseHis> list = mapper.selectByExample(cond);
        List<ReportCaseHisDto> result = new ArrayList<ReportCaseHisDto>();
        for(ReportCaseHis data:list){
            result.add(MapperConfig.map(data, ReportCaseHisDto.class));
        }
        return result;
    }

    public PageVo<ReportCaseHisDto> findByPaging(int start, int length, int draw, Long id) {
        ReportCaseHisCond cond = new ReportCaseHisCond();
        ReportCaseHisCond.Criteria criteria = cond.createCriteria();
        criteria.andReportCaseIdEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<ReportCaseHisDto> pageVo = new PageVo<ReportCaseHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<ReportCaseHis> ReportCaseHiss = mapper.selectByExample(cond);
        List<ReportCaseHisDto> result = new ArrayList<ReportCaseHisDto>();
        for (ReportCaseHis data : ReportCaseHiss) {
            result.add(MapperConfig.map(data, ReportCaseHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
}
