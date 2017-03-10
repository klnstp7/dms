package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.TransactionCaseHisMapper;
import com.yunfang.dms.dto.TransactionCaseHisDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.TransactionCaseHis;
import com.yunfang.dms.entity.TransactionCaseHisCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.ITransactionCaseHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class TransactionCaseHisService implements ITransactionCaseHisService {
    @Autowired
    private TransactionCaseHisMapper mapper;

    public Boolean insert(TransactionCaseHisDto dto) {
        TransactionCaseHis entity = MapperConfig.map(dto, TransactionCaseHis.class);
        return mapper.insert(entity) > 0;
    }

    public Boolean update(TransactionCaseHisDto dto) {
        TransactionCaseHis entity = MapperConfig.map(dto, TransactionCaseHis.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id)> 0;
    }

    public TransactionCaseHisDto get(Long id) {

        TransactionCaseHis entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, TransactionCaseHisDto.class);
    }

    public List<TransactionCaseHisDto> selectByCond(TransactionCaseHisCond cond) {
        List<TransactionCaseHis> list = mapper.selectByExample(cond);
        List<TransactionCaseHisDto> result = new ArrayList<TransactionCaseHisDto>();
        for(TransactionCaseHis data:list){
            result.add(MapperConfig.map(data, TransactionCaseHisDto.class));
        }
        return result;
    }

    public PageVo<TransactionCaseHisDto> findByPaging(int start, int length, int draw, Long id) {
        TransactionCaseHisCond cond = new TransactionCaseHisCond();
        TransactionCaseHisCond.Criteria criteria = cond.createCriteria();
        criteria.andTransactionIdEqualTo(id);
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<TransactionCaseHisDto> pageVo = new PageVo<TransactionCaseHisDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<TransactionCaseHis> TransactionCaseHiss = mapper.selectByExample(cond);
        List<TransactionCaseHisDto> result = new ArrayList<TransactionCaseHisDto>();
        for (TransactionCaseHis data : TransactionCaseHiss) {
            result.add(MapperConfig.map(data, TransactionCaseHisDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
}
