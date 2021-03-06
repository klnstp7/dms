package com.yunfang.dms.controller;

import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.CommunityBaseDataCond;
import com.yunfang.dms.entity.CommunityBaseDataHisCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.service.inter.ICommunityBaseDataHisService;
import com.yunfang.dms.service.inter.ICommunityBaseDataService;
import com.yunfang.dms.service.inter.IExtendConfigService;
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
@RequestMapping("/communityBaseData")
public class CommunityBaseDataController {
    @Autowired
    private ICommunityBaseDataService communityBaseDataService;
    @Autowired
    private IExtendConfigService extendConfigService;
    @Autowired
    private ICommunityBaseDataHisService communityBaseDataHisService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/communityBaseData/index");
        return mv;
    }

    @RequestMapping(value = "/getPaging", method = RequestMethod.GET)
    public void getPaging(@RequestParam int start, @RequestParam int length, @RequestParam int draw, @RequestParam String filter, HttpServletResponse response)
            throws ServletException, IOException {
        UserInfoApiDto user= UserInfoUtil.getCurrentUser();
        PageVo<CommunityBaseDataDto> pageVo =  communityBaseDataService.findByPaging(start,length,draw,filter,user.getCompanyId());
        String str= JsonUtil.getExtendJsonString(pageVo);
        response.getWriter().print(str);
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("/communityBaseData/add");
        List<String> columns=new ArrayList<String>();
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput("communitybase","entityCol");
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
    public Boolean update(CommunityBaseDataDto dto) throws CustomException{
        UserInfoApiDto user=UserInfoUtil.getCurrentUser();
        dto.setCompanyId(user.getCompanyId());
        return communityBaseDataService.update(dto,user.getCompanyId(),user.getLoginName());
    }

    @ResponseBody
    @RequestMapping(value="delete",method = RequestMethod.POST)
    public Boolean delete(@RequestParam Long id) throws CustomException{
        return communityBaseDataService.delete(id,UserInfoUtil.getCurrentUser().getCompanyId());
    }

    @ResponseBody
    @RequestMapping(value="batchDelete",method = RequestMethod.POST)
    public Boolean batchDelete(@RequestParam Long[] ids) throws CustomException{
        return communityBaseDataService.batchDelete(java.util.Arrays.asList(ids),UserInfoUtil.getCurrentUser().getCompanyId());
    }

    @ResponseBody
    @RequestMapping(value="get",method = RequestMethod.GET)
    public CommunityBaseDataDto get(@RequestParam Long id){
        return communityBaseDataService.get(id);
    }

    @RequestMapping(value = "/getHis", method = RequestMethod.GET)
    public void getHis(@RequestParam int start, @RequestParam int length, @RequestParam int draw, @RequestParam Long id, HttpServletResponse response)
            throws ServletException, IOException {
        PageVo<CommunityBaseDataHisDto> list =  communityBaseDataHisService.findByPaging(start,length,draw,id);
        String str= JsonUtil.getExtendJsonString(list);
        response.getWriter().print(str);
    }

    @RequestMapping(value="batchDownload")
    public void batchDownload(@RequestParam Long[] ids, HttpServletResponse response){
        CommunityBaseDataCond cond=new CommunityBaseDataCond();
        CommunityBaseDataCond.Criteria criteria=cond.createCriteria();
        criteria.andIdIn(java.util.Arrays.asList(ids));
        List<CommunityBaseDataDto> list=communityBaseDataService.selectByCond(cond);
        if(list==null||list.isEmpty()){
            return;
        }
        String jsonStr=JsonUtil.getExtendJsonString(list);
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        List<ExtendConfigDto> configs = extendConfigService.getExtendTitleList(UserInfoUtil.getCurrentUserCompanyId(), SourceTableEmum.CommunityBaseData.ordinal());
        List<String> titles = new ArrayList<String>();
        if (configs != null) {
            for (ExtendConfigDto dto :
                    configs) {
                if (!titles.contains(dto.getColumnName())) {
                    titles.add(dto.getColumnName());
                }
            }
        }
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput("communitybase","entityCol");
        for(Iterator s = titles.iterator(); s.hasNext();)
        {
            String col=s.next().toString();
            TempLateConfigDto dto=new TempLateConfigDto();
            dto.setTemplateCol(col);
            dto.setEntityCol(col);
            configColMap.put(col,dto);
        }
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        ExcelUtil.exportJsonToExcel("小区基础数据下载-"+dataFormat.format(new Date()),configColMap, jsonArray, response);
    }
}
