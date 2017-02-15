package com.yunfang.dms.controller;

import com.google.gson.Gson;
import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.dto.InquiryDataDto;
import com.yunfang.dms.dto.PageVo;
import com.yunfang.dms.entity.ExtendConfigCond;
import com.yunfang.dms.entity.InquiryDataCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.service.inter.IInquiryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */
@Controller
@RequestMapping("/inquiry")
public class InquiryController {
    @Autowired
    private IInquiryDataService inquiryDataService;
    @Autowired
    private IExtendConfigService extendConfigService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ExtendConfigCond cond=new ExtendConfigCond();
        cond.createCriteria().andSourceTableEqualTo(SourceTableEmum.InquiryData);
        List<ExtendConfigDto> configs=extendConfigService.selectByCond(cond);
        ArrayList<String> extendTitles=new ArrayList<String>();
        StringBuffer titleString=new StringBuffer();
        for (ExtendConfigDto dto:
                configs) {
            if(!extendTitles.contains(dto.getColumnName())){
                extendTitles.add(dto.getColumnName());
                titleString.append(", {data: \""+dto.getColumnName()+"\"}");
            }
        }
        ModelAndView mv = new ModelAndView("/inquiry/index");
        mv.addObject("titleString",titleString!=null?titleString.toString():"");
        return mv;
    }

    @RequestMapping(value = "/GetPaging", method = RequestMethod.GET)
    @ResponseBody
    public PageVo<InquiryDataDto> GetPaging(@RequestParam int start, @RequestParam int length, @RequestParam int draw, HttpServletRequest request){
        InquiryDataDto cond  = new InquiryDataDto();
        PageVo<InquiryDataDto> pageVo =  inquiryDataService.FindByPagging(cond,start,length);
        pageVo.setDraw(draw);
        return pageVo;
    }

    @RequestMapping(value = "/GetPagingTest", method = RequestMethod.GET)
    public String GetPagingTest(@RequestParam int start, @RequestParam int length, @RequestParam int draw, HttpServletRequest request){
        InquiryDataDto cond  = new InquiryDataDto();
        PageVo<InquiryDataDto> pageVo =  inquiryDataService.FindByPagging(cond,start,length);
        pageVo.setDraw(draw);
        Gson gson=new Gson();
        String str=gson.toJson(pageVo);
        str=str.replace("\"extendCol\":\"{\\\"","\"").replace("\\\"","\"").replace("}\"}","}");
        return str;
    }
}
