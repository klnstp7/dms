package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.HouseBaseDataHisMapper;
import com.yunfang.dms.dao.mapper.HouseBaseDataMapper;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.*;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IHouseBaseDataService;
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
public class HouseBaseDataService implements IHouseBaseDataService {
    @Autowired
    private HouseBaseDataMapper mapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private HouseBaseDataHisMapper hisMapper;

    @Override
    public PageVo<HouseBaseDataDto> findByPaging(int start, int length, int draw, String filter, int companyId) {
        HouseBaseDataCond cond = new HouseBaseDataCond();
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
        PageVo<HouseBaseDataDto> pageVo = new PageVo<HouseBaseDataDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<HouseBaseData> houseBaseDatas = mapper.selectByExample(cond);
        List<HouseBaseDataDto> result = new ArrayList<HouseBaseDataDto>();
        for (HouseBaseData data : houseBaseDatas) {
            result.add(MapperConfig.map(data, HouseBaseDataDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @Override
    public Boolean insert(HouseBaseDataDto dto) {
        HouseBaseData entiry = MapperConfig.map(dto, HouseBaseData.class);
        return mapper.insert(entiry) > 0;
    }

    @Override
    public Boolean update(HouseBaseDataDto dto) {
        HouseBaseData entity = MapperConfig.map(dto, HouseBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    @Override
    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public HouseBaseDataDto get(Long id) {

        HouseBaseData entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, HouseBaseDataDto.class);
    }


    @Override
    public List<HouseBaseDataDto> selectByCond(HouseBaseDataCond cond) {
        List<HouseBaseData> list = mapper.selectByExample(cond);
        List<HouseBaseDataDto> result = new ArrayList<HouseBaseDataDto>();
        for (HouseBaseData data : list) {
            result.add(MapperConfig.map(data, HouseBaseDataDto.class));
        }
        return result;
    }

    public Boolean update(HouseBaseDataDto dto, Integer CompanyId, String userName) throws CustomException {
        HouseBaseData entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        HouseBaseDataHis his=MapperConfig.copy(entity,HouseBaseData.class,HouseBaseDataHis.class);
        his.setHouseId(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, HouseBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        HouseBaseData entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            HouseBaseData entity = mapper.selectByPrimaryKey(id);
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

    //批量插入楼幢基础数据
    public UpLoadFileResultDto batchInsertHouseBase(String filename, String configNodeName) throws CustomException {
        List<Object> errorList = new ArrayList<Object>();
        //List<?> list = commonService.readExcelToList(filename, configNodeName, SourceTableEmum.HouseBaseData, errorList);
        List<HouseBaseDataDto> list = commonService.readExcelToList(filename, HouseBaseDataDto.class, configNodeName, SourceTableEmum.HouseBaseData, errorList);
        Integer companyId = UserInfoUtil.getCurrentUserCompanyId();
        String currentUser = UserInfoUtil.getCurrentUser().getLoginName();
        int updateCount = 0;
        int noExistsCount = 0;
        for (HouseBaseDataDto dto : list) {
            //判断单元是否存在
            boolean unitIsExists = commonService.unitIsExists(dto.getRegion(), dto.getCityName(), dto.getCommunity(), dto.getBuildingName(), dto.getUnitName());
            if (!unitIsExists) {
                errorList.add(dto);
                noExistsCount++;
                continue;
            }
            //判断数据是否存在、更新/新增
            HouseBaseDataCond houseBaseDataCond = new HouseBaseDataCond();
            houseBaseDataCond.createCriteria().andCompanyIdEqualTo(companyId).andCommunityEqualTo(dto.getCommunity()).
                    andCityNameEqualTo(dto.getCityName()).andRegionEqualTo(dto.getRegion()).
                    andBuildingNameEqualTo(dto.getBuildingName()).andUnitNameEqualTo(dto.getUnitName()).andHouseNameEqualTo(dto.getHouseName());
            List<HouseBaseDataDto> dbDtos = selectByCond(houseBaseDataCond);
            Date now = new Date();
            dto.setCompanyId(companyId);
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            if (dbDtos != null && dbDtos.size() > 0) {
                HouseBaseDataDto updateDto = dbDtos.get(0);//数据库中的记录
                HouseBaseDataHis hisDto =MapperConfig.copy(updateDto,HouseBaseDataDto.class,HouseBaseDataHis.class);;
                hisDto.setHouseId(updateDto.getId());
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
}
