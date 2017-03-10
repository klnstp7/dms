package com.yunfang.dms.service.impl;

import com.yunfang.dms.dao.mapper.ExtendConfigMapper;
import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.dto.TempLateConfigDto;
import com.yunfang.dms.entity.ExtendConfig;
import com.yunfang.dms.entity.ExtendConfigCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.init.MapperConfig;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.utils.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lthui on 2017/2/13.
 */
@Service
public class ExtendConfigService implements IExtendConfigService {
    @Autowired
    private ExtendConfigMapper buildingMapper;

    public Boolean insert(ExtendConfigDto dto) throws CustomException{
//        ExtendConfig entity = MapperConfig.map(dto, ExtendConfig.class);
        ExtendConfigCond cond=new ExtendConfigCond();
        cond.createCriteria().andCompanyIdEqualTo(dto.getCompanyId()).andSourceTableEqualTo(dto.getSourceTable().ordinal()).andColumnNameEqualTo(dto.getColumnName());
        List<ExtendConfig> list = buildingMapper.selectByExample(cond);
        if(!list.isEmpty()){
            throw new CustomException("当前公司已存在该字段");
        }
        String dataType="xunjiaanli";
        if (dto.getSourceTable()==SourceTableEmum.InquiryData){
            dataType="xunjiaanli";
        }
        else if(dto.getSourceTable()==SourceTableEmum.OfferCase){
            dataType="baopananli";
        }
        else if(dto.getSourceTable()==SourceTableEmum.TransactionCase){
            dataType="chengjiaoanli";
        }
        else if(dto.getSourceTable()==SourceTableEmum.ReportCase){
            dataType="baogaoanli";
        }
        else if(dto.getSourceTable()==SourceTableEmum.CommunityBaseData){
            dataType="communitybase";
        }
        else if(dto.getSourceTable()==SourceTableEmum.BuildingBaseData){
            dataType="buildingbase";
        }
        else if(dto.getSourceTable()==SourceTableEmum.UnitBaseData){
            dataType="unitbase";
        }
        else if(dto.getSourceTable()==SourceTableEmum.HouseBaseData){
            dataType="housebase";
        }
        Map<String, TempLateConfigDto> configDto = XmlUtil.getConfigForInput(dataType, "entityCol");
        if(configDto.containsValue(dto.getColumnName())){
            throw new CustomException("当前业务已存在该字段");
        }
        if(configDto.containsKey(dto.getColumnName())){
            throw new CustomException("当前业务已存在该字段："+configDto.get(dto.getColumnName()).getTemplateCol());
        }
        ExtendConfig entity =new ExtendConfig();
        entity.setSourceTable(dto.getSourceTable().ordinal());
        entity.setColumnName(dto.getColumnName());
        entity.setCompanyId(dto.getCompanyId());
        entity.setCreateDateTime(dto.getCreateDateTime());
        entity.setOperator(dto.getOperator());
        return buildingMapper.insert(entity) > 0 ? true : false;
    }

    public Boolean delete(Long id,Integer companyId) throws CustomException {
        ExtendConfig config=buildingMapper.selectByPrimaryKey(id);
        if(config.getCompanyId()!=companyId){
            throw new CustomException("你无权删除该配置");
        }
        return buildingMapper.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    public ExtendConfigDto get(Long id) {
        ExtendConfig entity = buildingMapper.selectByPrimaryKey(id);
        return MapperConfig.map(entity, ExtendConfigDto.class);
    }

    public List<ExtendConfigDto> selectByCond(ExtendConfigCond cond) {
        List<ExtendConfig> list = buildingMapper.selectByExample(cond);
        List<ExtendConfigDto> result = new ArrayList<ExtendConfigDto>();
        for(ExtendConfig data:list){
            result.add(MapperConfig.map(data, ExtendConfigDto.class));
        }
        return result;
    }

//    public String getExtendTitleString(Integer companyId, SourceTableEmum sourceTableEmum){
//        ExtendConfigCond cond=new ExtendConfigCond();
//        cond.createCriteria().andCompanyIdEqualTo(companyId).andSourceTableEqualTo(sourceTableEmum);
//        List<ExtendConfig> configs = buildingMapper.selectByExample(cond);
//        ArrayList<String> extendTitles=new ArrayList<String>();
//        StringBuffer titleString=new StringBuffer();
//        for (ExtendConfig config:
//                configs) {
//            if(!extendTitles.contains(config.getColumnName())){
//                extendTitles.add(config.getColumnName());
//                titleString.append(", {data: \""+config.getColumnName()+"\",title:\""+config.getColumnName()+"\"}");
//            }
//        }
//        return titleString!=null?titleString.toString():"";
//    }

    public List<ExtendConfigDto> getExtendTitleList(Integer companyId, Integer sourceTableEmumValue){
        ExtendConfigCond cond=new ExtendConfigCond();
        cond.createCriteria().andCompanyIdEqualTo(companyId).andSourceTableEqualTo(sourceTableEmumValue);
        List<ExtendConfig> list = buildingMapper.selectByExample(cond);
        List<ExtendConfigDto> result = new ArrayList<ExtendConfigDto>();
        for(ExtendConfig data:list){
            result.add(MapperConfig.map(data, ExtendConfigDto.class));
        }
        return result;
    }

    public List<ExtendConfigDto> getExtendTitleList(Integer companyId, Integer sourceTableEmumValue, CityInfoDto cityInfoDto){
        ExtendConfigCond cond=new ExtendConfigCond();
        cond.createCriteria().andCompanyIdEqualTo(companyId).andSourceTableEqualTo(sourceTableEmumValue);
        List<ExtendConfig> list = buildingMapper.selectByExample(cond);
        List<ExtendConfigDto> result = new ArrayList<ExtendConfigDto>();
        for(ExtendConfig data:list){
            result.add(MapperConfig.map(data, ExtendConfigDto.class));
        }
        return result;
    }

    public List<String> getExtendList(Integer companyId, Integer sourceTableEmumValue){
        ExtendConfigCond cond=new ExtendConfigCond();
        cond.createCriteria().andSourceTableEqualTo(sourceTableEmumValue);
        List<ExtendConfig> configs = buildingMapper.selectByExample(cond);
        List<String> extendTitles=new ArrayList<String>();
        for (ExtendConfig config:
                configs) {
            if(!extendTitles.contains(config.getColumnName())){
                extendTitles.add(config.getColumnName());
            }
        }
        return extendTitles;
    }
}
