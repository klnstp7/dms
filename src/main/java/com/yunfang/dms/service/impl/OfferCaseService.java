package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.OfferCaseHisMapper;
import com.yunfang.dms.dao.mapper.OfferCaseMapper;
import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.dto.OfferCaseDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.OfferCase;
import com.yunfang.dms.entity.OfferCaseCond;
import com.yunfang.dms.entity.OfferCaseHis;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IOfferCaseService;
import com.yunfang.dms.utils.UserInfoUtil;
import com.yunfang.dms.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lthui on 2017/2/22.
 */
@Service
public class OfferCaseService implements IOfferCaseService {
    @Autowired
    private OfferCaseMapper mapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private OfferCaseHisMapper hisMapper;

    @Override
    public List<OfferCaseDto> selectByCond(OfferCaseCond cond){
        List<OfferCase> list = mapper.selectByExample(cond);
        List<OfferCaseDto> result = new ArrayList<OfferCaseDto>();
        for (OfferCase data : list) {
            result.add(MapperConfig.map(data, OfferCaseDto.class));
        }
        return result;
    }

    public List<OfferCaseDto> selectByCond(OfferCaseCond cond,CityInfoDto cityInfoDto){
        List<OfferCase> list = mapper.selectByExample(cond);
        List<OfferCaseDto> result = new ArrayList<OfferCaseDto>();
        for (OfferCase data : list) {
            result.add(MapperConfig.map(data, OfferCaseDto.class));
        }
        return result;
    }

    @Override
    public Boolean insert(OfferCaseDto dto)
    {
        OfferCase entity= MapperConfig.map(dto, OfferCase.class);
        return mapper.insert(entity)>0;
    }

    @Override
    public OfferCaseDto get(Long id) {
        OfferCase entity=mapper.selectByPrimaryKey(id);
        OfferCaseDto dto=MapperConfig.map(entity, OfferCaseDto.class);
        return dto;
    }

    @Override
    public Boolean update(OfferCaseDto dto) {
        OfferCase data = MapperConfig.map(dto, OfferCase.class);
        return mapper.updateByPrimaryKey(data) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }


    @Override
    public PageVo<OfferCaseDto> findByPaging(int start, int length,int draw,String filter,int companyId) {
        OfferCaseCond cond = new OfferCaseCond();
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
        PageVo<OfferCaseDto> pageVo = new PageVo<OfferCaseDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<OfferCase> offerCases = mapper.selectByExample(cond);
        List<OfferCaseDto> result = new ArrayList<OfferCaseDto>();
        for (OfferCase data : offerCases) {
            result.add(MapperConfig.map(data, OfferCaseDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
    public UpLoadFileResultDto batchInsertOfferCaseData(String filename, String configNodeName) throws CustomException {
        List<Object> errorList=new ArrayList<Object>();
        List<OfferCaseDto> list = commonService.readExcelToList(filename,OfferCaseDto.class, configNodeName, SourceTableEmum.OfferCase,errorList);
        for (OfferCaseDto dto:list ) {
            dto.setCompanyId(UserInfoUtil.getCurrentUserCompanyId());
            Date now = new Date();
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            insert(dto);
        }
        return commonService.getUpLoadFileResultDto(errorList, list,0,0);
    }

    public Boolean update(OfferCaseDto dto, Integer CompanyId, String userName) throws CustomException {
        OfferCase entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        OfferCaseHis his=MapperConfig.copy(entity,OfferCase.class,OfferCaseHis.class);
        his.setOfferCaseId(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, OfferCase.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        OfferCase entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            OfferCase entity = mapper.selectByPrimaryKey(id);
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
