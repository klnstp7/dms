package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.InquiryDataMapper;
import com.yunfang.dms.dto.InquiryDataDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.InquiryData;
import com.yunfang.dms.entity.InquiryDataCond;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IInquiryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */
@Service
public class InquiryDataService implements IInquiryDataService {
    @Autowired
    private InquiryDataMapper mapper;

    @Override
    public  PageVo<InquiryDataDto> FindByPagging(InquiryDataDto conditon, int start, int length) {

        InquiryDataCond cond = new InquiryDataCond();
        InquiryDataCond.Criteria criteria  =cond.createCriteria();
        if(conditon.getAddress() !=null &&conditon.getAddress().trim().equals("")){
            criteria.andAddressLike( conditon.getAddress());
        }
        cond.setOrderByClause("ID");
        long total= mapper.countByExample(cond);
        PageVo<InquiryDataDto> pageVo = new PageVo<InquiryDataDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<InquiryData>  inquiryDatas =  mapper.selectByPaging(cond);
        List<InquiryDataDto> result = new ArrayList<InquiryDataDto>();
        for(InquiryData data:inquiryDatas){
            result.add(MapperConfig.map(data, InquiryDataDto.class));
        }
        pageVo.setAaData(result);
        return pageVo;
    }

    @Override
    public Boolean insert(InquiryDataDto dto) {
        InquiryData data=MapperConfig.map(dto, InquiryData.class);
        return mapper.insert(data)>0;
    }

    @Override
    public Boolean update(InquiryDataDto dto) {
        InquiryData data=MapperConfig.map(dto, InquiryData.class);
        return mapper.updateByPrimaryKey(data)>0;
    }

    @Override
    public Boolean delete(Long id) {
        return mapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public InquiryDataDto get(Long id) {
        InquiryData data= mapper.selectByPrimaryKey(id);
        return MapperConfig.map(data, InquiryDataDto.class);
    }
}
