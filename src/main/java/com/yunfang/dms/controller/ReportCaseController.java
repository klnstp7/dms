package com.yunfang.dms.controller;

import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.ReportCaseCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.service.inter.IReportCaseHisService;
import com.yunfang.dms.service.inter.IReportCaseService;
import com.yunfang.dms.service.inter.IReportDocumentService;
import com.yunfang.dms.utils.*;
import com.yunfang.resourcepool.sdk.ResourcesPoolUtils;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lthui on 2017/2/27.
 */
@Controller
@RequestMapping("/reportCase")
public class ReportCaseController {
    @Autowired
    private IReportCaseService reportCaseService;
    @Autowired
    private IReportCaseHisService reportCaseHisService;
    @Autowired
    private IExtendConfigService extendConfigService;
    @Autowired
    private IReportDocumentService reportDocumentService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/reportCase/index");
        return mv;
    }

    @RequestMapping(value = "/getPaging", method = RequestMethod.GET)
    public void getPaging(@RequestParam int start, @RequestParam int length, @RequestParam int draw, @RequestParam String filter, HttpServletResponse response)
            throws ServletException, IOException {
        UserInfoApiDto user= UserInfoUtil.getCurrentUser();
        PageVo<ReportCaseDto> pageVo =  reportCaseService.findByPaging(start,length,draw,filter,user.getCompanyId());
        String str= JsonUtil.getExtendJsonString(pageVo);
        response.getWriter().print(str);
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("/reportCase/add");
        List<String> columns=new ArrayList<String>();
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput("baogaoanli","entityCol");
        if(configColMap!=null){
            for (Map.Entry<String, TempLateConfigDto> key : configColMap.entrySet()) {
                columns.add(key.getKey());
            }
        }
        columns.add("id");
        columns.add("extendCol");
        mv.addObject("columns",columns);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Boolean update(ReportCaseDto dto) throws CustomException {
        UserInfoApiDto user=UserInfoUtil.getCurrentUser();
        dto.setCompanyId(user.getCompanyId());
        return reportCaseService.update(dto,user.getCompanyId(),user.getLoginName());
    }

    @ResponseBody
    @RequestMapping(value="delete",method = RequestMethod.POST)
    public Boolean delete(@RequestParam Long id) throws CustomException{
        return reportCaseService.delete(id,UserInfoUtil.getCurrentUser().getCompanyId());
    }

    @ResponseBody
    @RequestMapping(value="batchDelete",method = RequestMethod.POST)
    public Boolean batchDelete(@RequestParam Long[] ids) throws CustomException{
        return reportCaseService.batchDelete(java.util.Arrays.asList(ids),UserInfoUtil.getCurrentUser().getCompanyId());
    }

    @ResponseBody
    @RequestMapping(value="get",method = RequestMethod.GET)
    public ReportCaseDto get(@RequestParam Long id){
        return reportCaseService.get(id);
    }

    @RequestMapping(value = "/getHis", method = RequestMethod.GET)
    public void getHis(@RequestParam int start, @RequestParam int length, @RequestParam int draw, @RequestParam Long id, HttpServletResponse response)
            throws ServletException, IOException {
        PageVo<ReportCaseHisDto> list =  reportCaseHisService.findByPaging(start,length,draw,id);
        String str= JsonUtil.getExtendJsonString(list);
        response.getWriter().print(str);
    }

    @RequestMapping(value="batchDownload")
    public void batchDownload(@RequestParam Long[] ids, HttpServletResponse response){
        ReportCaseCond cond=new ReportCaseCond();
        ReportCaseCond.Criteria criteria=cond.createCriteria();
        criteria.andIdIn(java.util.Arrays.asList(ids));
        List<ReportCaseDto> list=reportCaseService.selectByCond(cond);
        if(list==null||list.isEmpty()){
            return;
        }
        String jsonStr=JsonUtil.getExtendJsonString(list);
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        List<ExtendConfigDto> configs = extendConfigService.getExtendTitleList(UserInfoUtil.getCurrentUserCompanyId(), SourceTableEmum.ReportCase.ordinal());
        List<String> titles = new ArrayList<String>();
        if (configs != null) {
            for (ExtendConfigDto dto :
                    configs) {
                if (!titles.contains(dto.getColumnName())) {
                    titles.add(dto.getColumnName());
                }
            }
        }
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput("baogaoanli","entityCol");
        for(Iterator s = titles.iterator(); s.hasNext();)
        {
            String col=s.next().toString();
            TempLateConfigDto dto=new TempLateConfigDto();
            dto.setTemplateCol(col);
            dto.setEntityCol(col);
            configColMap.put(col,dto);
        }
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        ExcelUtil.exportJsonToExcel("报告案例数据下载-"+dataFormat.format(new Date()),configColMap, jsonArray, response);
    }

    @ResponseBody
    @RequestMapping(value="getReports",method = RequestMethod.GET)
    public PageVo<ReportDocumentDto> getReports(@RequestParam int start, @RequestParam int length, @RequestParam int draw,@RequestParam long id){
        return reportDocumentService.getReports(start,length,draw,id);
    }

    @RequestMapping(value="downloadReport")
    public void downloadReport(@RequestParam Long id, HttpServletResponse response){
        ReportDocumentDto dto=reportDocumentService.get(id);
        if(dto!=null){
            com.yunfang.resourcepool.model.ResultInfo<String> resultInfo= ResourcesPoolUtils.getFileURL(dto.getResourceId().toString());
            if(resultInfo.getSuccess()){
                FileUtil.DownloadFileFromNet(resultInfo.getData(),dto.getName(),response);
            }
        }
    }
}
