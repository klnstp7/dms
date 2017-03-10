package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.InquiryDataHisMapper;
import com.yunfang.dms.dao.mapper.InquiryDataMapper;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.InquiryData;
import com.yunfang.dms.entity.InquiryDataCond;
import com.yunfang.dms.entity.InquiryDataHis;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IInquiryDataService;
import com.yunfang.dms.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/2/10.
 */
@Service
public class InquiryDataService implements IInquiryDataService {
    @Autowired
    private InquiryDataMapper mapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private InquiryDataHisMapper hisMapper;

    @Override
    public PageVo<InquiryDataDto> findByPaging(int start, int length, int draw, String filter, int companyId) {
        InquiryDataCond cond = new InquiryDataCond();
        //查询条件
        if (!StringUtil.isNullOrEmpty(filter)) {
            cond.or().andDistrictLike(filter).andCompanyIdEqualTo(companyId);
            cond.or().andRegionLike(filter).andCompanyIdEqualTo(companyId);
            cond.or().andCommunityLike(filter).andCompanyIdEqualTo(companyId);
            cond.or().andAddressLike(filter).andCompanyIdEqualTo(companyId);
        }
        else {
            cond.createCriteria().andCompanyIdEqualTo(companyId);
        }
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<InquiryDataDto> pageVo = new PageVo<InquiryDataDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<InquiryData> inquiryDatas = mapper.selectByExample(cond);
        List<InquiryDataDto> result = new ArrayList<InquiryDataDto>();
        for (InquiryData data : inquiryDatas) {
            result.add(MapperConfig.map(data, InquiryDataDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @Override
    public Boolean insert(InquiryDataDto dto) {
        InquiryData data = MapperConfig.map(dto, InquiryData.class);
        return mapper.insert(data) > 0;
    }

    @Override
    public Boolean update(InquiryDataDto dto) {
        InquiryData data = MapperConfig.map(dto, InquiryData.class);
        return mapper.updateByPrimaryKey(data) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public InquiryDataDto get(Long id) {
        InquiryData data = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(data, InquiryDataDto.class);
    }

    @Override
    public UpLoadFileResultDto batchInsertInquiryData(String filename, String configNodeName) throws CustomException {
        List<Object> errorList = new ArrayList<Object>();
        List<InquiryDataDto> list = commonService.readExcelToList(filename, InquiryDataDto.class, configNodeName, SourceTableEmum.InquiryData, errorList);
        for (InquiryDataDto dto : list) {
            dto.setCompanyId(UserInfoUtil.getCurrentUserCompanyId());
            Date now = new Date();
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            insert(dto);
        }
        return commonService.getUpLoadFileResultDto(errorList, list, 0, 0);
    }


    @Override
    public List<InquiryDataDto> selectByCond(InquiryDataCond cond) {
        List<InquiryData> list = mapper.selectByExample(cond);
        List<InquiryDataDto> result = new ArrayList<InquiryDataDto>();
        for (InquiryData data : list) {
            result.add(MapperConfig.map(data, InquiryDataDto.class));
        }
        return result;
    }

    public List<InquiryDataDto> selectByCond(InquiryDataCond cond,CityInfoDto cityInfoDto) {
        List<InquiryData> list = mapper.selectByExample(cond);
        List<InquiryDataDto> result = new ArrayList<InquiryDataDto>();
        for (InquiryData data : list) {
            result.add(MapperConfig.map(data, InquiryDataDto.class));
        }
        return result;
    }

    public Boolean update(InquiryDataDto dto, Integer CompanyId, String userName) throws CustomException {
        InquiryData entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        InquiryDataHis his=MapperConfig.copy(entity,InquiryData.class,InquiryDataHis.class);
        his.setInquiryDataId(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, InquiryData.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        InquiryData entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            InquiryData entity = mapper.selectByPrimaryKey(id);
            if (entity.getCompanyId() != CompanyId) {
                throw new CustomException("无权限进行删除");
            }
        }
        for (Long id :
                ids) {
            if (mapper.deleteByPrimaryKey(id) <= 0) {
                return false;
            }
        }
        return true;
    }
}
