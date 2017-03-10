package com.yunfang.dms.apiController;

import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.InquiryDataCond;
import com.yunfang.dms.entity.OfferCaseCond;
import com.yunfang.dms.entity.ReportCaseCond;
import com.yunfang.dms.entity.TransactionCaseCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.service.inter.*;
import com.yunfang.dms.utils.StringUtil;
import com.yunfang.dms.utils.UserInfoUtil;
import com.yunfang.dms.utils.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lthui on 2017/2/15.
 */

@SuppressWarnings("serial")
@Controller
@RequestMapping("/api/pep")
public class PepApiController implements Serializable {
    @Autowired
    private IExtendConfigService extendConfigService;
    @Autowired
    private IOfferCaseService offerCaseService;
    @Autowired
    private ITransactionCaseService transactionCaseService;
    @Autowired
    private IReportCaseService reportCaseService;
    @Autowired
    private IInquiryDataService inquiryDataService;

    /**
     * 获取拓展标题接口
     *
     * @param CompanyId,SourceTable
     * @return
     */
    @RequestMapping(value = "/getExtendTitle", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo<List<String>> getExtendTitle(@RequestParam String CityName,@RequestParam Integer CompanyId,@RequestParam Integer SourceTable){
        ResultInfo<List<String>> result= new ResultInfo<List<String>>();
        try {
            if(CompanyId<=0||SourceTable<0){
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            CityInfoDto cityInfoDto=new CityInfoDto();
            cityInfoDto.setCityName(CityName);
            cityInfoDto.setUseCity(true);
            List<ExtendConfigDto> configs=extendConfigService.getExtendTitleList(CompanyId, SourceTable,cityInfoDto);
            List<String> extendTitles=new ArrayList<String>();
            for (ExtendConfigDto config:
                    configs ) {
                if(!extendTitles.contains(config.getColumnName())){
                    extendTitles.add(config.getColumnName());
                }
            }
            result.setData(extendTitles);
            result.setSuccess(true);
            result.setMsg("操作成功!");
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setMsg("执行异常，请求格式不正确");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取全部标题
     *
     * @param CompanyId,SourceTable
     * @return
     */
    @RequestMapping(value = "/getAllTitles", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo<Map<String, String>> getAllTitles(@RequestParam String CityName, @RequestParam Integer CompanyId, @RequestParam Integer SourceTable){
        ResultInfo<Map<String, String>> result= new ResultInfo<Map<String, String>>();
        try {
            if(CompanyId<=0||SourceTable<0){
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            String dataType="xunjiaanli";
            if (SourceTable== SourceTableEmum.InquiryData.ordinal()){
                dataType="xunjiaanli";
            }
            else if(SourceTable==SourceTableEmum.OfferCase.ordinal()){
                dataType="baopananli";
            }
            else if(SourceTable==SourceTableEmum.TransactionCase.ordinal()){
                dataType="chengjiaoanli";
            }
            else if(SourceTable==SourceTableEmum.ReportCase.ordinal()){
                dataType="baogaoanli";
            }
            else if(SourceTable==SourceTableEmum.CommunityBaseData.ordinal()){
                dataType="communitybase";
            }
            else if(SourceTable==SourceTableEmum.BuildingBaseData.ordinal()){
                dataType="buildingbase";
            }
            else if(SourceTable==SourceTableEmum.UnitBaseData.ordinal()){
                dataType="unitbase";
            }
            else if(SourceTable==SourceTableEmum.HouseBaseData.ordinal()){
                dataType="housebase";
            }
            Map<String, TempLateConfigDto> configDto = XmlUtil.getConfigForInput(dataType, "entityCol");
            Map<String, String> returnMap = new LinkedHashMap<String, String>();
            if(configDto!=null){
                for (Map.Entry<String, TempLateConfigDto> entry : configDto.entrySet()) {
                    returnMap.put(entry.getKey(),entry.getValue().getTemplateCol());
                }
            }
            CityInfoDto cityInfoDto=new CityInfoDto();
            cityInfoDto.setCityName(CityName);
            cityInfoDto.setUseCity(true);
            List<ExtendConfigDto> configs=extendConfigService.getExtendTitleList(CompanyId, SourceTable,cityInfoDto);
            if(configs!=null){
                for (ExtendConfigDto config:configs){
                    returnMap.put(config.getColumnName(),config.getColumnName());
                }
            }
            result.setData(returnMap);
            result.setSuccess(true);
            result.setMsg("操作成功!");
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setMsg("执行异常，请求格式不正确");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取询价数据
     *
     * @param CompanyId,Community，BeginArea，EndArea，PageSize
     * @return
     */
    @RequestMapping(value = "/getInquiryData", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo<List<InquiryDataDto>> getInquiryData(@RequestParam String CityName,@RequestParam Integer CompanyId,@RequestParam String Community,
                                                           @RequestParam(required = false) BigDecimal BeginArea,
                                                           @RequestParam(required = false) BigDecimal EndArea,@RequestParam Integer PageSize){
        ResultInfo<List<InquiryDataDto>> result= new ResultInfo<List<InquiryDataDto>>();
        try {
            if(CompanyId<=0|| StringUtil.isNullOrEmpty(Community)||PageSize<0) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            if((BeginArea!=null&&BeginArea.compareTo(new BigDecimal(0))==-1)
                    ||(EndArea!=null&&EndArea.compareTo(new BigDecimal(0))==-1)
                    ||(BeginArea!=null&&EndArea!=null&&(BeginArea.compareTo(EndArea)==1))) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            InquiryDataCond cond=new InquiryDataCond();
            InquiryDataCond.Criteria criteria = cond.createCriteria();
            criteria.andCompanyIdEqualTo(CompanyId);
            criteria.andCommunityEqualTo(URLDecoder.decode(Community,"utf-8"));
            if(BeginArea!=null){
                criteria.andAreaGreaterThanOrEqualTo(BeginArea);
            }
            if(EndArea!=null){
                criteria.andAreaLessThanOrEqualTo(EndArea);
            }
            cond.setStart(0);
            if(PageSize>0){
                cond.setLimit(PageSize);
            }
            cond.setOrderByClause("ID DESC");
            CityInfoDto cityInfoDto=new CityInfoDto();
            cityInfoDto.setCityName(CityName);
            cityInfoDto.setUseCity(true);
            result.setData(inquiryDataService.selectByCond(cond,cityInfoDto));
            result.setSuccess(true);
            result.setMsg("操作成功!");
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setMsg("执行异常，请求格式不正确");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取报盘案例
     *
     * @param CompanyId,Community，BeginArea，EndArea，PageSize
     * @return
     */
    @RequestMapping(value = "/getOfferCase", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo<List<OfferCaseDto>> getOfferCase(@RequestParam String CityName,@RequestParam Integer CompanyId,@RequestParam String Community,
                                                       @RequestParam(required = false) BigDecimal BeginArea,
                                                       @RequestParam(required = false) BigDecimal EndArea,@RequestParam Integer PageSize){
        ResultInfo<List<OfferCaseDto>> result= new ResultInfo<List<OfferCaseDto>>();
        try {
            if(CompanyId<=0|| StringUtil.isNullOrEmpty(Community)||PageSize<0) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            if((BeginArea!=null&&BeginArea.compareTo(new BigDecimal(0))==-1)
                    ||(EndArea!=null&&EndArea.compareTo(new BigDecimal(0))==-1)
                    ||(BeginArea!=null&&EndArea!=null&&(BeginArea.compareTo(EndArea)==1))) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            OfferCaseCond cond=new OfferCaseCond();
            OfferCaseCond.Criteria criteria = cond.createCriteria();
            criteria.andCompanyIdEqualTo(CompanyId);
            criteria.andCommunityEqualTo(URLDecoder.decode(Community,"utf-8"));
            if(BeginArea!=null){
                criteria.andAreaGreaterThanOrEqualTo(BeginArea);
            }
            if(EndArea!=null){
                criteria.andAreaLessThanOrEqualTo(EndArea);
            }
            cond.setStart(0);
            if(PageSize>0){
                cond.setLimit(PageSize);
            }
            cond.setOrderByClause("ID DESC");
            CityInfoDto cityInfoDto=new CityInfoDto();
            cityInfoDto.setCityName(CityName);
            cityInfoDto.setUseCity(true);
            result.setData(offerCaseService.selectByCond(cond,cityInfoDto));
            result.setSuccess(true);
            result.setMsg("操作成功!");
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setMsg("执行异常，请求格式不正确");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取成交案例
     *
     * @param CompanyId,Community，BeginArea，EndArea，PageSize
     * @return
     */
    @RequestMapping(value = "/getTransactionCase", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo<List<TransactionCaseDto>> getTransactionCase(@RequestParam String CityName,@RequestParam Integer CompanyId,@RequestParam String Community,
                                                                   @RequestParam(required = false) BigDecimal BeginArea,
                                                                   @RequestParam(required = false) BigDecimal EndArea,@RequestParam Integer PageSize){
        ResultInfo<List<TransactionCaseDto>> result= new ResultInfo<List<TransactionCaseDto>>();
        try {
            if(CompanyId<=0|| StringUtil.isNullOrEmpty(Community)||PageSize<0) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            if((BeginArea!=null&&BeginArea.compareTo(new BigDecimal(0))==-1)
                    ||(EndArea!=null&&EndArea.compareTo(new BigDecimal(0))==-1)
                    ||(BeginArea!=null&&EndArea!=null&&(BeginArea.compareTo(EndArea)==1))) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            TransactionCaseCond cond=new TransactionCaseCond();
            TransactionCaseCond.Criteria criteria = cond.createCriteria();
            criteria.andCompanyIdEqualTo(CompanyId);
            criteria.andCommunityEqualTo(URLDecoder.decode(Community,"utf-8"));
            if(BeginArea!=null){
                criteria.andAreaGreaterThanOrEqualTo(BeginArea);
            }
            if(EndArea!=null){
                criteria.andAreaLessThanOrEqualTo(EndArea);
            }
            cond.setStart(0);
            if(PageSize>0){
                cond.setLimit(PageSize);
            }
            cond.setOrderByClause("ID DESC");
            CityInfoDto cityInfoDto=new CityInfoDto();
            cityInfoDto.setCityName(CityName);
            cityInfoDto.setUseCity(true);
            result.setData(transactionCaseService.selectByCond(cond,cityInfoDto));
            result.setSuccess(true);
            result.setMsg("操作成功!");
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setMsg("执行异常，请求格式不正确");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取询价数据
     *
     * @param CompanyId,Community，BeginArea，EndArea，PageSize
     * @return
     */
    @RequestMapping(value = "/getReportCase", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo<List<ReportCaseDto>> getReportCase(@RequestParam String CityName,@RequestParam Integer CompanyId,@RequestParam String Community,
                                                         @RequestParam(required = false) BigDecimal BeginArea,
                                                         @RequestParam(required = false) BigDecimal EndArea,@RequestParam Integer PageSize){
        ResultInfo<List<ReportCaseDto>> result= new ResultInfo<List<ReportCaseDto>>();
        try {
            if(CompanyId<=0|| StringUtil.isNullOrEmpty(Community)||PageSize<0) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            if((BeginArea!=null&&BeginArea.compareTo(new BigDecimal(0))==-1)
                    ||(EndArea!=null&&EndArea.compareTo(new BigDecimal(0))==-1)
                    ||(BeginArea!=null&&EndArea!=null&&(BeginArea.compareTo(EndArea)==1))) {
                result.setSuccess(false);
                result.setMsg("参数格式不正确");
                return result;
            }
            ReportCaseCond cond=new ReportCaseCond();
            ReportCaseCond.Criteria criteria = cond.createCriteria();
            criteria.andCompanyIdEqualTo(CompanyId);
            criteria.andCommunityEqualTo(URLDecoder.decode(Community,"utf-8"));
            if(BeginArea!=null){
                criteria.andAreaGreaterThanOrEqualTo(BeginArea);
            }
            if(EndArea!=null){
                criteria.andAreaLessThanOrEqualTo(EndArea);
            }
            cond.setStart(0);
            if(PageSize>0){
                cond.setLimit(PageSize);
            }
            cond.setOrderByClause("ID DESC");
            CityInfoDto cityInfoDto=new CityInfoDto();
            cityInfoDto.setCityName(CityName);
            cityInfoDto.setUseCity(true);
            result.setData(reportCaseService.selectByCond(cond,cityInfoDto));
            result.setSuccess(true);
            result.setMsg("操作成功!");
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setMsg("执行异常，请求格式不正确");
            e.printStackTrace();
        }
        return result;
    }
}
