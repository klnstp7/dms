package com.yunfang.dms.controller;

import com.yunfang.dms.dto.BuildingBaseDataDto;
import com.yunfang.dms.service.inter.IBuildingBaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/7.
 */
@Controller
@RequestMapping("/BaseData")
public class BuildingBaseDataController {
    @Autowired
    private IBuildingBaseDataService buildingService;

    @RequestMapping("/Building")
    public String getBuildingData(){
        buildingService.get(new Long(1));
        return "test";
    }

    @RequestMapping("/Add")
    public String addBuildingData(String city){
        BuildingBaseDataDto dto = new BuildingBaseDataDto();
        dto.setAddress("北京市西城区车公庄大街10号");
        dto.setBuildingAlias("北京市西城区车公庄大街10号");
        dto.setBuildingName("1号楼");
        dto.setBuildYear("2015");
        dto.setCityName("北京");
        dto.setCommunity("五栋大楼");
        dto.setCompanyId(1);
        dto.setCreateDatetime(new Date());
        dto.setLastUpdateTime(new Date());
        dto.setRegion("西城区");
        dto.setDistrict("西城区");
        dto.setExtendCol("户号:123,绿化率:100%");
        buildingService.insert(dto);
        return "test";
    }
}
