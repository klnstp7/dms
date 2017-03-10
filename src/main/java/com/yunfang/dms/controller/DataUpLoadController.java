package com.yunfang.dms.controller;

import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/2/13.
 */
@Controller
@RequestMapping("/upload")
public class DataUpLoadController {

    @Autowired
    private IExtendConfigService extendConfigService;
    @RequestMapping("/index")
    public ModelAndView Index()
    {
        ModelAndView mv = new ModelAndView("upload/ownDataUpdate");
        mv.addObject("titleString",extendConfigService.getExtendTitleList(UserInfoUtil.getCurrentUserCompanyId(), SourceTableEmum.InquiryData.ordinal()));
        return mv;
    }
}

