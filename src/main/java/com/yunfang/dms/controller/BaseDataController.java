package com.yunfang.dms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/3/1.
 */
@Controller
@RequestMapping("/baseData")
public class BaseDataController extends  BaseController {

    @RequestMapping("/baseDataUpdate")
    public ModelAndView BaseDataUpData()
    {
        ModelAndView mv=new ModelAndView("upload/baseDataUpdate");
        return mv;
    }
}
