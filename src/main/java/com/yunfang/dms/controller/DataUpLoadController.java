package com.yunfang.dms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/2/13.
 */
@Controller
@RequestMapping("/upload")
public class DataUpLoadController {

    @RequestMapping("/index")
    public ModelAndView Index()
    {
        ModelAndView mv = new ModelAndView("upload/ownDataUpdate");
        return mv;
    }
}
