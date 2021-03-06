package com.yunfang.dms.controller;

import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.OfferCaseCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.service.inter.IOfferCaseHisService;
import com.yunfang.dms.service.inter.IOfferCaseService;
import com.yunfang.dms.utils.ExcelUtil;
import com.yunfang.dms.utils.JsonUtil;
import com.yunfang.dms.utils.UserInfoUtil;
import com.yunfang.dms.utils.XmlUtil;
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
@RequestMapping("/offerCase")
public class OfferCaseController {
    @Autowired
    private IOfferCaseService offerCaseService;
    @Autowired
    private IOfferCaseHisService offerCaseHisService;
    @Autowired
    private IExtendConfigService extendConfigService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/offerCase/index");
        return mv;
    }

    @RequestMapping(value = "/getPaging", method = RequestMethod.GET)
    public void getPaging(@RequestParam int start, @RequestParam int length, @RequestParam int draw, @RequestParam String filter, HttpServletResponse response)
            throws ServletException, IOException {
        UserInfoApiDto user= UserInfoUtil.getCurrentUser();
        PageVo<OfferCaseDto> pageVo =  offerCaseService.findByPaging(start,length,draw,filter,user.getCompanyId());
        String str= JsonUtil.getExtendJsonString(pageVo);
        response.getWriter().print(str);
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("/offerCase/add");
        List<String> columns=new ArrayList<String>();
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput("baopananli","entityCol");
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
    public Boolean update(OfferCaseDto dto) throws CustomException {
        UserInfoApiDto user=UserInfoUtil.getCurrentUser();
        dto.setCompanyId(user.getCompanyId());
        return offerCaseService.update(dto,user.getCompanyId(),user.getLoginName());
    }

    @ResponseBody
    @RequestMapping(value="delete",method = RequestMethod.POST)
    public Boolean delete(@RequestParam Long id) throws CustomException{
        return offerCaseService.delete(id,UserInfoUtil.getCurrentUser().getCompanyId());
    }

    @ResponseBody
    @RequestMapping(value="batchDelete",method = RequestMethod.POST)
    public Boolean batchDelete(@RequestParam Long[] ids) throws CustomException{
        return offerCaseService.batchDelete(java.util.Arrays.asList(ids),UserInfoUtil.getCurrentUser().getCompanyId());
    }

    @ResponseBody
    @RequestMapping(value="get",method = RequestMethod.GET)
    public OfferCaseDto get(@RequestParam Long id){
        return offerCaseService.get(id);
    }

    @RequestMapping(value = "/getHis", method = RequestMethod.GET)
    public void getHis(@RequestParam int start, @RequestParam int length, @RequestParam int draw, @RequestParam Long id, HttpServletResponse response)
            throws ServletException, IOException {
        PageVo<OfferCaseHisDto> list =  offerCaseHisService.findByPaging(start,length,draw,id);
        String str= JsonUtil.getExtendJsonString(list);
        response.getWriter().print(str);
    }

    @RequestMapping(value="batchDownload")
    public void batchDownload(@RequestParam Long[] ids, HttpServletResponse response){
        OfferCaseCond cond=new OfferCaseCond();
        OfferCaseCond.Criteria criteria=cond.createCriteria();
        criteria.andIdIn(java.util.Arrays.asList(ids));
        List<OfferCaseDto> list=offerCaseService.selectByCond(cond);
        if(list==null||list.isEmpty()){
            return;
        }
        String jsonStr=JsonUtil.getExtendJsonString(list);
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        List<ExtendConfigDto> configs = extendConfigService.getExtendTitleList(UserInfoUtil.getCurrentUserCompanyId(), SourceTableEmum.OfferCase.ordinal());
        List<String> titles = new ArrayList<String>();
        if (configs != null) {
            for (ExtendConfigDto dto :
                    configs) {
                if (!titles.contains(dto.getColumnName())) {
                    titles.add(dto.getColumnName());
                }
            }
        }
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput("baopananli","entityCol");
        for(Iterator s = titles.iterator(); s.hasNext();)
        {
            String col=s.next().toString();
            TempLateConfigDto dto=new TempLateConfigDto();
            dto.setTemplateCol(col);
            dto.setEntityCol(col);
            configColMap.put(col,dto);
        }
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        ExcelUtil.exportJsonToExcel("报盘案例数据下载-"+dataFormat.format(new Date()),configColMap, jsonArray, response);
    }
}
