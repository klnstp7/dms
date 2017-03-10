package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.UnitBaseDataHisMapper;
import com.yunfang.dms.dao.mapper.UnitBaseDataMapper;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.*;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IUnitBaseDataService;
import com.yunfang.dms.utils.StringUtil;
import com.yunfang.dms.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lthui on 2017/2/27.
 */
@Service
public class UnitBaseDataService implements IUnitBaseDataService {
    @Autowired
    private UnitBaseDataMapper mapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private UnitBaseDataHisMapper hisMapper;

    @Override
    public PageVo<UnitBaseDataDto> findByPaging(int start, int length, int draw, String filter, int companyId) {
        UnitBaseDataCond cond = new UnitBaseDataCond();
        //查询条件
        if (!StringUtil.isNullOrEmpty(filter)) {
            cond.or().andDistrictLike(filter).andCompanyIdEqualTo(companyId);
            cond.or().andRegionLike(filter).andCompanyIdEqualTo(companyId);
            cond.or().andCommunityLike(filter).andCompanyIdEqualTo(companyId);
        }
        else {
            cond.createCriteria().andCompanyIdEqualTo(companyId);
        }
        cond.setOrderByClause("ID DESC");
        long total = mapper.countByExample(cond);
        PageVo<UnitBaseDataDto> pageVo = new PageVo<UnitBaseDataDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<UnitBaseData> unitBaseDatas = mapper.selectByExample(cond);
        List<UnitBaseDataDto> result = new ArrayList<UnitBaseDataDto>();
        for (UnitBaseData data : unitBaseDatas) {
            result.add(MapperConfig.map(data, UnitBaseDataDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @Override
    public Boolean insert(UnitBaseDataDto dto) {
        UnitBaseData entiry = MapperConfig.map(dto, UnitBaseData.class);
        return mapper.insert(entiry) > 0;
    }

    @Override
    public Boolean update(UnitBaseDataDto dto) {
        UnitBaseData entity = MapperConfig.map(dto, UnitBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    @Override
    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UnitBaseDataDto get(Long id) {

        UnitBaseData entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, UnitBaseDataDto.class);
    }


    @Override
    public List<UnitBaseDataDto> selectByCond(UnitBaseDataCond cond) {
        List<UnitBaseData> list = mapper.selectByExample(cond);
        List<UnitBaseDataDto> result = new ArrayList<UnitBaseDataDto>();
        for (UnitBaseData data : list) {
            result.add(MapperConfig.map(data, UnitBaseDataDto.class));
        }
        return result;
    }

    //批量插入单元基础数据
    public UpLoadFileResultDto batchInsertUnitBase(String filename, String configNodeName) throws CustomException {
        List<Object> errorList = new ArrayList<Object>();
        List<UnitBaseDataDto> list = commonService.readExcelToList(filename,UnitBaseDataDto.class, configNodeName, SourceTableEmum.UnitBaseData, errorList);
        Integer companyId = UserInfoUtil.getCurrentUserCompanyId();
        String currentUser = UserInfoUtil.getCurrentUser().getLoginName();
        int updateCount = 0;
        int noExistsCount = 0;
        for (UnitBaseDataDto dto:list) {
            //判断小区是否存在
            boolean communityIsExists = commonService.buildingIsExists(dto.getRegion(), dto.getCityName(), dto.getCommunity(), dto.getBuildingName());
            if (!communityIsExists) {
                errorList.add(dto);
                noExistsCount++;
                continue;
            }
            //判断数据是否存在、更新/新增
            UnitBaseDataCond unitBaseDataCond = new UnitBaseDataCond();
            unitBaseDataCond.createCriteria().andCompanyIdEqualTo(companyId).andCommunityEqualTo(dto.getCommunity()).andCityNameEqualTo(dto.getCityName()).andRegionEqualTo(dto.getRegion()).andBuildingNameEqualTo(dto.getBuildingName()).andUnitNameEqualTo(dto.getUnitName());
            List<UnitBaseDataDto> dbDtos = selectByCond(unitBaseDataCond);
            Date now = new Date();
            dto.setCompanyId(companyId);
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            if (dbDtos != null && dbDtos.size() > 0) {
                UnitBaseDataDto updateDto = dbDtos.get(0);//数据库中的记录
                UnitBaseDataHis hisDto = MapperConfig.copy(updateDto,UnitBaseDataDto.class, UnitBaseDataHis.class);
                hisDto.setUnitId(updateDto.getId());
                hisDto.setCreateDateTime(now);
                hisDto.setOperator(currentUser);
                hisMapper.insert(hisDto);
                //更新当前数据
                dto.setId(updateDto.getId());
                dto.setCreateDateTime(updateDto.getCreateDateTime());
                update(dto);
                updateCount++;
            } else {
                insert(dto);
            }
        }
        return commonService.getUpLoadFileResultDto(errorList, list, updateCount, noExistsCount);
    }

    public Boolean update(UnitBaseDataDto dto, Integer CompanyId, String userName) throws CustomException {
        UnitBaseData entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        UnitBaseDataHis his=MapperConfig.copy(entity,UnitBaseData.class,UnitBaseDataHis.class);
        his.setUnitId(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, UnitBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        UnitBaseData entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            UnitBaseData entity = mapper.selectByPrimaryKey(id);
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
