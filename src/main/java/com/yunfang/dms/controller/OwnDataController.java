package com.yunfang.dms.controller;

import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.ReportCaseCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.service.inter.IReportCaseService;
import com.yunfang.dms.utils.UserInfoUtil;
import com.yunfang.dms.utils.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2017/2/13.
 */
@Controller
@RequestMapping("/owndata")
public class OwnDataController {

    @Autowired
    private IExtendConfigService extendConfigService;
    @Autowired
    private IReportCaseService reportCaseService;

    @RequestMapping("/ownDataUpdate")
    public ModelAndView Index() {
        ModelAndView mv = new ModelAndView("upload/ownDataUpdate");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/getExtendCol")
    public List<String> getExtendCol(String dataType) {
        int ordinal = 0;
        if (dataType.equals("xunjia")) {
            ordinal = SourceTableEmum.InquiryData.ordinal();
        }
        if (dataType.equals("chengjiao")) {
            ordinal = SourceTableEmum.TransactionCase.ordinal();
        }
        if (dataType.equals("baopan")) {
            ordinal = SourceTableEmum.OfferCase.ordinal();
        }
        if (dataType.equals("baogao")) {
            ordinal = SourceTableEmum.ReportCase.ordinal();
        }
        if (dataType.equals("community")) {
            ordinal = SourceTableEmum.CommunityBaseData.ordinal();
        }
        if (dataType.equals("building")) {
            ordinal = SourceTableEmum.BuildingBaseData.ordinal();
        }
        if (dataType.equals("unit")) {
            ordinal = SourceTableEmum.UnitBaseData.ordinal();
        }
        if (dataType.equals("house")) {
            ordinal = SourceTableEmum.HouseBaseData.ordinal();
        }
        List<ExtendConfigDto> configs = extendConfigService.getExtendTitleList(UserInfoUtil.getCurrentUserCompanyId(), ordinal);
        List<String> titles = new ArrayList<String>();
        if (configs != null) {
            for (ExtendConfigDto dto :
                    configs) {
                if (!titles.contains(dto.getColumnName())) {
                    titles.add(dto.getColumnName());
                }
            }
        }
        return titles;
    }

    @ResponseBody
    @RequestMapping("/getGridCols")
    public Map<String, String> getGridCols(String dataType,String belongModel) {
        String tempLateExtenstion="anli";
        if(belongModel.equals("baseData"))
        {
            tempLateExtenstion="base";
        }
        Map<String, TempLateConfigDto> configDto = XmlUtil.getConfigForInput(dataType +tempLateExtenstion, "tempLate");
        Map<String, String> returnMap = new LinkedHashMap<String, String>();
        if(configDto!=null){
            for (Map.Entry<String, TempLateConfigDto> entry : configDto.entrySet()) {
                returnMap.put(entry.getKey(), entry.getValue().getEntityCol());
            }
        }
        return returnMap;
    }

    @ResponseBody
    @RequestMapping("/getAllTitles")
    public Map<String, String> getAllTitles(Integer sourceTable, @RequestParam(required = false) Boolean isHis) {
        String dataType="xunjiaanli";
        if (sourceTable==SourceTableEmum.InquiryData.ordinal()){
            dataType="xunjiaanli";
        }
        else if(sourceTable==SourceTableEmum.OfferCase.ordinal()){
            dataType="baopananli";
        }
        else if(sourceTable==SourceTableEmum.TransactionCase.ordinal()){
            dataType="chengjiaoanli";
        }
        else if(sourceTable==SourceTableEmum.ReportCase.ordinal()){
            dataType="baogaoanli";
        }
        else if(sourceTable==SourceTableEmum.CommunityBaseData.ordinal()){
            dataType="communitybase";
        }
        else if(sourceTable==SourceTableEmum.BuildingBaseData.ordinal()){
            dataType="buildingbase";
        }
        else if(sourceTable==SourceTableEmum.UnitBaseData.ordinal()){
            dataType="unitbase";
        }
        else if(sourceTable==SourceTableEmum.HouseBaseData.ordinal()){
            dataType="housebase";
        }
        Map<String, TempLateConfigDto> configDto = XmlUtil.getConfigForInput(dataType, "entityCol");
        Map<String, String> returnMap = new LinkedHashMap<String, String>();
        if(configDto!=null){
            for (Map.Entry<String, TempLateConfigDto> entry : configDto.entrySet()) {
                returnMap.put(entry.getKey(),entry.getValue().getTemplateCol());
            }
        }
        List<ExtendConfigDto> configs=extendConfigService.getExtendTitleList(UserInfoUtil.getCurrentUser().getCompanyId(), sourceTable);
        if(configs!=null){
            for (ExtendConfigDto config:configs){
                returnMap.put(config.getColumnName(),config.getColumnName());
            }
        }
        if(isHis!=null&&isHis){
            returnMap.put("operator","操作人");
        }
        return returnMap;
    }
    @RequestMapping("/checkReportDoc")
    @ResponseBody
    public ResultInfo<String> checkReportDocIsVaild(String reportNo)
    {
        ResultInfo<String> resultInfo=new ResultInfo<String>();
        resultInfo.setSuccess(true);
        resultInfo.setMsg("报告存在");
        ReportCaseCond cond=new ReportCaseCond();
        cond.createCriteria().andReportNoEqualTo(reportNo).andCompanyIdEqualTo(UserInfoUtil.getCurrentUserCompanyId());
        List<ReportCaseDto> dtos=reportCaseService.selectByCond(cond);
        if(dtos==null || dtos.size()<1)
        {
            resultInfo.setSuccess(false);
            resultInfo.setMsg("报告不存在");
        }
        return resultInfo;
    }
}
