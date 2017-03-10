package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.CommunityBaseDataHisMapper;
import com.yunfang.dms.dao.mapper.CommunityBaseDataMapper;
import com.yunfang.dms.dto.CommunityBaseDataDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.dto.UpLoadFileResultDto;
import com.yunfang.dms.entity.CommunityBaseData;
import com.yunfang.dms.entity.CommunityBaseDataCond;
import com.yunfang.dms.entity.CommunityBaseDataHis;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.ICommunityBaseDataService;
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
public class CommunityBaseDataService implements ICommunityBaseDataService {
    @Autowired
    private CommunityBaseDataMapper mapper;
    @Autowired
    private CommonService commonService;

    @Autowired
    private CommunityBaseDataHisMapper hisMapper;

    @Override
    public PageVo<CommunityBaseDataDto> findByPaging(int start, int length, int draw, String filter, int companyId) {
        CommunityBaseDataCond cond = new CommunityBaseDataCond();
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
        PageVo<CommunityBaseDataDto> pageVo = new PageVo<CommunityBaseDataDto>(total);
        cond.setStart(start);
        cond.setLimit(length);

        List<CommunityBaseData> communityBaseDatas = mapper.selectByExample(cond);
        List<CommunityBaseDataDto> result = new ArrayList<CommunityBaseDataDto>();
        for (CommunityBaseData data : communityBaseDatas) {
            result.add(MapperConfig.map(data, CommunityBaseDataDto.class));
        }
        pageVo.setAaData(result);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @Override
    public Boolean insert(CommunityBaseDataDto dto) {
        CommunityBaseData entiry = MapperConfig.map(dto, CommunityBaseData.class);
        return mapper.insert(entiry) > 0;
    }

    @Override
    public Boolean update(CommunityBaseDataDto dto) {
        CommunityBaseData entity = MapperConfig.map(dto, CommunityBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;

    }

    @Override
    public Boolean delete(Long id) {

        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public CommunityBaseDataDto get(Long id) {

        CommunityBaseData entity = mapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, CommunityBaseDataDto.class);
    }


    @Override
    public List<CommunityBaseDataDto> selectByCond(CommunityBaseDataCond cond) {
        List<CommunityBaseData> list = mapper.selectByExample(cond);
        List<CommunityBaseDataDto> result = new ArrayList<CommunityBaseDataDto>();
        for (CommunityBaseData data : list) {
            result.add(MapperConfig.map(data, CommunityBaseDataDto.class));
        }
        return result;
    }

    //批量插入小区基础数据
    public UpLoadFileResultDto batchInsertCommunityBase(String filename, String configNodeName) throws CustomException {
        List<Object> errorList = new ArrayList<Object>();
        List<CommunityBaseDataDto> list = commonService.readExcelToList(filename,CommunityBaseDataDto.class, configNodeName, SourceTableEmum.CommunityBaseData, errorList);
        Integer companyId = UserInfoUtil.getCurrentUserCompanyId();
        String currentUser = UserInfoUtil.getCurrentUser().getLoginName();
        int updateCount = 0;
        for (CommunityBaseDataDto dto:list) {
            CommunityBaseDataCond communityBaseDataCond = new CommunityBaseDataCond();
            communityBaseDataCond.createCriteria().andCompanyIdEqualTo(companyId).andCommunityEqualTo(dto.getCommunity()).andCityNameEqualTo(dto.getCityName()).andRegionEqualTo(dto.getRegion());
            List<CommunityBaseDataDto> dbDtos = selectByCond(communityBaseDataCond);
            Date now = new Date();
            dto.setCompanyId(companyId);
            dto.setCreateDateTime(now);
            dto.setLastUpdateTime(now);
            if (dbDtos != null && dbDtos.size() > 0) {
                CommunityBaseDataDto updateDto = dbDtos.get(0);//数据库中的记录
                CommunityBaseDataHis hisDto = MapperConfig.copy(updateDto,CommunityBaseDataDto.class, CommunityBaseDataHis.class);
                hisDto.setCommunityid(updateDto.getId());
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
        return commonService.getUpLoadFileResultDto(errorList, list, updateCount, 0);
    }

    public Boolean update(CommunityBaseDataDto dto, Integer CompanyId, String userName) throws CustomException {
        CommunityBaseData entity = mapper.selectByPrimaryKey(dto.getId());
        if (entity == null) {
            throw new CustomException("数据不存在");
        }
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行修改");
        }
        dto.setCreateDateTime(entity.getCreateDateTime());
        dto.setLastUpdateTime(new Date());
        CommunityBaseDataHis his=MapperConfig.copy(entity,CommunityBaseData.class,CommunityBaseDataHis.class);
        his.setCommunityid(entity.getId());
        his.setCreateDateTime(new Date());
        his.setOperator(userName);
        hisMapper.insert(his);
        entity = MapperConfig.map(dto, CommunityBaseData.class);
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public Boolean delete(Long id, Integer CompanyId) throws CustomException {
        CommunityBaseData entity = mapper.selectByPrimaryKey(id);
        if (entity.getCompanyId() != CompanyId) {
            throw new CustomException("无权限进行删除");
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public Boolean batchDelete(List<Long> ids, Integer CompanyId) throws CustomException {
        for (Long id :
                ids) {
            CommunityBaseData entity = mapper.selectByPrimaryKey(id);
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
