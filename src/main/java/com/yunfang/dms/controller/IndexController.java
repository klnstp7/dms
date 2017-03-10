package com.yunfang.dms.controller;

import com.yunfang.dms.utils.CookiesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/9.
 */
@Controller
@RequestMapping("/home")
public class IndexController extends BaseController {
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("/baseData")
    public ModelAndView baseData() {
        ModelAndView mv = new ModelAndView("baseData");
        return mv;
    }
    @RequestMapping("/ownData")
    public ModelAndView ownData() {
        ModelAndView mv = new ModelAndView("ownData");
        return mv;
    }

    @RequestMapping("/ownDataInquiry")
    public ModelAndView ownDataInquiry() {
        ModelAndView mv = new ModelAndView("ownDataInquiry");
        return mv;
    }


    @RequestMapping("/ownDataTransaction")
    public ModelAndView ownDataTransaction() {
        ModelAndView mv = new ModelAndView("ownDataTransaction");
        return mv;
    }
    @RequestMapping("/ownDataOffer")
    public ModelAndView ownDataOffer() {
        ModelAndView mv = new ModelAndView("ownDataOffer");
        return mv;
    }
    @RequestMapping("/price")
    public ModelAndView Price() {
        ModelAndView mv = new ModelAndView("price");
        return mv;
    }
    @RequestMapping("/ownDataReport")
    public ModelAndView ownDataReport() {
        ModelAndView mv = new ModelAndView("ownDataReport");
        return mv;
    }
    @RequestMapping("/ownDataUpdate")
    public ModelAndView ownDataUpdate() {
        ModelAndView mv = new ModelAndView("ownDataUpdate");
        return mv;
    }
    @RequestMapping("/AddInquiryCase")
    public ModelAndView AddInquiryCase() {
        ModelAndView mv = new ModelAndView("AddInquiryCase");
        return mv;
    }
    @RequestMapping("/AddTransactionCase")
    public ModelAndView AddTransactionCase() {
        ModelAndView mv = new ModelAndView("AddTransactionCase");
        return mv;
    }
    @RequestMapping("/AddOfferCase")
    public ModelAndView AddOfferCase() {
        ModelAndView mv = new ModelAndView("AddOfferCase");
        return mv;
    }
    @RequestMapping("/AddReportCase")
    public ModelAndView AddReportCase() {
        ModelAndView mv = new ModelAndView("AddReportCase");
        return mv;
    }
    @RequestMapping("/baseDataResidentialArea")
    public ModelAndView baseDataResidentialArea() {
        ModelAndView mv = new ModelAndView("baseDataResidentialArea");
        return mv;
    }
    @RequestMapping("/baseDataBuilding")
    public ModelAndView baseDataBuilding() {
        ModelAndView mv = new ModelAndView("baseDataBuilding");
        return mv;
    }
    @RequestMapping("/baseDataUnit")
    public ModelAndView baseDataUnit() {
        ModelAndView mv = new ModelAndView("baseDataUnit");
        return mv;
    }
    @RequestMapping("/baseDataRoom")
    public ModelAndView baseDataRoom() {
        ModelAndView mv = new ModelAndView("baseDataRoom");
        return mv;
    }

    @RequestMapping("/AddResidentialAreaInfo")
    public ModelAndView AddResidentialAreaInfo() {
        ModelAndView mv = new ModelAndView("AddResidentialAreaInfo");
        return mv;
    }
    @RequestMapping("/AddBuildingInfo")
    public ModelAndView AddBuildingInfo() {
        ModelAndView mv = new ModelAndView("AddBuildingInfo");
        return mv;
    }
    @RequestMapping("/AddUnitInfo")
    public ModelAndView AddUnitInfo() {
        ModelAndView mv = new ModelAndView("AddUnitInfo");
        return mv;
    }
    @RequestMapping("/AddRoomInfo")
    public ModelAndView AddRoomInfo() {
        ModelAndView mv = new ModelAndView("AddRoomInfo");
        return mv;
    }
    @RequestMapping("/AddPrice")
    public ModelAndView AddPrice() {
        ModelAndView mv = new ModelAndView("AddPrice");
        return mv;
    }
    @RequestMapping("/config")
    public ModelAndView config() {
        ModelAndView mv = new ModelAndView("config");
        return mv;
    }

    @ResponseBody
    @RequestMapping("changeCity")
    public Boolean changeCity(String cityName, HttpServletResponse response){
        try {
            CookiesUtil.addCookie(response,"CityName",cityName, Integer.MAX_VALUE);
        }
        catch (IOException e){
            return false;
        }
        return true;
    }
}

