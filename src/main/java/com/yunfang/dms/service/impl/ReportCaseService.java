package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.ReportCaseHisMapper;
import com.yunfang.dms.dao.mapper.ReportCaseMapper;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.ReportCase;
import com.yunfang.dms.entity.ReportCaseCond;
import com.yunfang.dms.entity.ReportCaseHis;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IReportCaseService;
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
public class ReportCaseService implements IReportCaseService {
    @Autowired
    private ReportCaseMapper mapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ReportCaseHisMapper hisMapper;

    @Override
    public List<ReportCaseDto> selectByCond(ReportCaseCond cond){
        List<ReportCase> list = mapper.selectByExample(cond);
        List<ReportCaseDto> result = new ArrayList<ReportCaseDto>();
        for (ReportCase data : list) {
            result.add(MapperConfig.map(data, ReportCaseDto.class));
        }
        return result;
    }

    public List<ReportCaseDto> selectByCond(ReportCaseCond cond,CityInfoDto cityInfoDto){
        List<ReportCase> list = mapper.selectByExample(cond);
        List<ReportCaseDto> result = new ArrayList<ReportCaseDto>();
        for (ReportCase data : list) {
            result.add(MapperConfig.map(data, ReportCaseDto.class));
        }
        return result;
    }

    @Override
    public Boolean insert(ReportCaseDto dto)
    {
        ReportCase entity= MapperConfig.map(dto, ReportCase.class);
        return mapper.insert(entity)>0;
    }

    @Override
    public ReportCaseDto get(Long id) {
        ReportCase entity=mapper.selectByPrimaryKey(id);
        ReportCaseDto dto=MapperConfig.map(entity, ReportCaseDto.class);
        return dto;
    }

    @Override
    public Boolean update(ReportCaseDto dto) {
        ReportCase data = MapperConfig.map(dto, ReportCase.class);
        return mapper.updateByPrimaryKey(data) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }
    public PageVo<ReportCaseDto> findByPaging(int start, int length, int draw, String filter, int companyId) {
        ReportCaseCond cond = new ReportCaseCond();
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
        PageVo<ReportCaseDto> pageVo = new PageVo<ReportCaseDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<ReportCase> reportCases = mapper.selectByExample(cond);
        List<ReportCaseDto> result = new ArrayList<ReportCaseDto>();
        for (ReportCase data : reportCases) {
            result.add(MapperConfig.map(data, ReportCaseDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
    public UpLoadFileResultDto batchInsertReportCaseData(String filename, String configNodeName) throws CustomException {
        List<Object> errorList=new ArrayList<Object>();
        List<ReportCaseDto> list = commonService.readExcelToList(filename,ReportCaseDto.class, configNodeName, SourceTableEmum.OfferCase,errorList);
        for (ReportCaseDto dto : list ) {
            dto.setCompanyId(UserInfoUtil.getCurrentUserCompanyId());
            Date now = new Date();
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            insert(dto);
        }
        return commonService.getUpLoadFileResultDto(errorList, list,0,0);
    }

    public Boolean update(ReportCaseDto dto, Integer CompanyId, String userName) throws CustomException {
        ReportCase entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        ReportCaseHis his=MapperConfig.copy(entity,ReportCase.class,ReportCaseHis.class);
        his.setReportCaseId(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, ReportCase.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        ReportCase entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            ReportCase entity = mapper.selectByPrimaryKey(id);
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
