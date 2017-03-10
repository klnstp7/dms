package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.BuildingBaseDataHisMapper;
import com.yunfang.dms.dao.mapper.BuildingBaseDataMapper;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.*;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IBuildingBaseDataService;
import com.yunfang.dms.utils.StringUtil;
import com.yunfang.dms.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service
public class BuildingBaseDataService implements IBuildingBaseDataService {

    @Autowired
    private BuildingBaseDataMapper mapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private BuildingBaseDataHisMapper hisMapper;

    public Boolean insert(BuildingBaseDataDto dto) {
        BuildingBaseData entity = MapperConfig.map(dto, BuildingBaseData.class);
        return mapper.insert(entity) > 0;
    }

    public Boolean update(BuildingBaseDataDto dto) {
        BuildingBaseData entity = MapperConfig.map(dto, BuildingBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public BuildingBaseDataDto get(Long id) {

        BuildingBaseData entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, BuildingBaseDataDto.class);
    }

    public List<BuildingBaseDataDto> selectByCond(BuildingBaseDataCond cond) {
        List<BuildingBaseData> list = mapper.selectByExample(cond);
        List<BuildingBaseDataDto> result = new ArrayList<BuildingBaseDataDto>();
        for (BuildingBaseData data : list) {
            result.add(MapperConfig.map(data, BuildingBaseDataDto.class));
        }
        return result;
    }

    @Override
    public PageVo<BuildingBaseDataDto> findByPaging(int start, int length, int draw, String filter, int companyId) {
        BuildingBaseDataCond cond = new BuildingBaseDataCond();
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
        PageVo<BuildingBaseDataDto> pageVo = new PageVo<BuildingBaseDataDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<BuildingBaseData> buildingBaseDatas = mapper.selectByExample(cond);
        List<BuildingBaseDataDto> result = new ArrayList<BuildingBaseDataDto>();
        for (BuildingBaseData data : buildingBaseDatas) {
            result.add(MapperConfig.map(data, BuildingBaseDataDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    //批量插入楼幢基础数据
    public UpLoadFileResultDto batchInsertBuildingBase(String filename, String configNodeName) throws CustomException {
        List<Object> errorList = new ArrayList<Object>();
        List<BuildingBaseDataDto> list = commonService.readExcelToList(filename,BuildingBaseDataDto.class, configNodeName, SourceTableEmum.BuildingBaseData, errorList);
        Integer companyId = UserInfoUtil.getCurrentUserCompanyId();
        String currentUser = UserInfoUtil.getCurrentUser().getLoginName();
        int updateCount = 0;
        int noExistsCount = 0;
        for (BuildingBaseDataDto dto: list ) {
            //判断小区是否存在
            boolean communityIsExists = commonService.communityIsExists(dto.getRegion(), dto.getCityName(), dto.getCommunity());
            if (!communityIsExists) {
                errorList.add(dto);
                noExistsCount++;
                continue;
            }
            //判断数据是否存在、更新/新增
            BuildingBaseDataCond buildingBaseDataCond = new BuildingBaseDataCond();
            buildingBaseDataCond.createCriteria().andCompanyIdEqualTo(companyId).andCommunityEqualTo(dto.getCommunity()).andCityNameEqualTo(dto.getCityName()).andRegionEqualTo(dto.getRegion()).andBuildingNameEqualTo(dto.getBuildingName());
            List<BuildingBaseDataDto> dbDtos = selectByCond(buildingBaseDataCond);
            Date now = new Date();
            dto.setCompanyId(companyId);
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            if (dbDtos != null && dbDtos.size() > 0) {
                BuildingBaseDataDto updateDto = dbDtos.get(0);//数据库中的记录
                BuildingBaseDataHis hisDto = MapperConfig.copy(updateDto,BuildingBaseDataDto.class, BuildingBaseDataHis.class);
                hisDto.setBuildingid(updateDto.getId());
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

    public Boolean update(BuildingBaseDataDto dto, Integer CompanyId, String userName) throws CustomException {
        BuildingBaseData entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        BuildingBaseDataHis his=MapperConfig.copy(entity,BuildingBaseData.class,BuildingBaseDataHis.class);
        his.setBuildingid(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, BuildingBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        BuildingBaseData entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            BuildingBaseData entity = mapper.selectByPrimaryKey(id);
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
