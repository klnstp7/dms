package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.TransactionCaseHisMapper;
import com.yunfang.dms.dao.mapper.TransactionCaseMapper;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.TransactionCase;
import com.yunfang.dms.entity.TransactionCaseCond;
import com.yunfang.dms.entity.TransactionCaseHis;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.ITransactionCaseService;
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
public class TransactionCaseService implements ITransactionCaseService {
    @Autowired
    private TransactionCaseMapper mapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private TransactionCaseHisMapper hisMapper;

    @Override
    public List<TransactionCaseDto> selectByCond(TransactionCaseCond cond){
        List<TransactionCase> list = mapper.selectByExample(cond);
        List<TransactionCaseDto> result = new ArrayList<TransactionCaseDto>();
        for (TransactionCase data : list) {
            result.add(MapperConfig.map(data, TransactionCaseDto.class));
        }
        return result;
    }

    public List<TransactionCaseDto> selectByCond(TransactionCaseCond cond,CityInfoDto cityInfoDto){
        List<TransactionCase> list = mapper.selectByExample(cond);
        List<TransactionCaseDto> result = new ArrayList<TransactionCaseDto>();
        for (TransactionCase data : list) {
            result.add(MapperConfig.map(data, TransactionCaseDto.class));
        }
        return result;
    }

    @Override
    public TransactionCaseDto get(Long id) {
        TransactionCase entity=mapper.selectByPrimaryKey(id);
        TransactionCaseDto dto=MapperConfig.map(entity, TransactionCaseDto.class);
        return dto;
    }

    @Override
    public Boolean update(TransactionCaseDto dto) {
        TransactionCase data = MapperConfig.map(dto, TransactionCase.class);
        return mapper.updateByPrimaryKey(data) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean insert(TransactionCaseDto dto) {
        TransactionCase data = MapperConfig.map(dto, TransactionCase.class);
        return mapper.insert(data) > 0;
    }

    public PageVo<TransactionCaseDto> findByPaging(int start, int length, int draw, String filter, int companyId){
        TransactionCaseCond cond = new TransactionCaseCond();
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
        PageVo<TransactionCaseDto> pageVo = new PageVo<TransactionCaseDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<TransactionCase> transactionCases = mapper.selectByExample(cond);
        List<TransactionCaseDto> result = new ArrayList<TransactionCaseDto>();
        for (TransactionCase data : transactionCases) {
            result.add(MapperConfig.map(data, TransactionCaseDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }
    public UpLoadFileResultDto batchInsertTranCaseData(String filename, String configNodeName) throws CustomException {
        List<Object> errorList=new ArrayList<Object>();
        List<TransactionCaseDto> list = commonService.readExcelToList(filename,TransactionCaseDto.class, configNodeName, SourceTableEmum.TransactionCase,errorList);
        for (TransactionCaseDto dto:list ) {
            dto.setCompanyId(UserInfoUtil.getCurrentUserCompanyId());
            Date now = new Date();
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            insert(dto);
        }
        return commonService.getUpLoadFileResultDto(errorList, list,0,0);
    }

    public Boolean update(TransactionCaseDto dto, Integer CompanyId, String userName) throws CustomException {
        TransactionCase entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        TransactionCaseHis his=MapperConfig.copy(entity,TransactionCase.class,TransactionCaseHis.class);
        his.setTransactionId(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, TransactionCase.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        TransactionCase entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            TransactionCase entity = mapper.selectByPrimaryKey(id);
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
