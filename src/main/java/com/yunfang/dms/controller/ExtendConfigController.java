package com.yunfang.dms.controller;

import com.yunfang.dms.dto.ExtendConfigDto;
import com.yunfang.dms.dto.ResultInfo;
import com.yunfang.dms.dto.UserInfoApiDto;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by Lthui on 2017/2/17.
 */
@Controller
@RequestMapping("/extendConfig")
public class ExtendConfigController {
    @Autowired
    private IExtendConfigService extendConfigService;

    @RequestMapping("/index")
    public ModelAndView config(Integer sourceTable) {
        ModelAndView mv = new ModelAndView("/extendConfig/index");
        return mv;
    }

    @RequestMapping(value = "/getExtendConfigList", method = RequestMethod.GET)
    @ResponseBody
    public List<ExtendConfigDto> getExtendConfigList(Integer sourceTable){
        UserInfoApiDto user= UserInfoUtil.getCurrentUser();
        return extendConfigService.getExtendTitleList(user.getCompanyId(), sourceTable);
    }

    @RequestMapping(value = "/insertExtendConfig",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo<List<ExtendConfigDto>> insertExtendConfig(Integer sourceTable, String columnName){
        UserInfoApiDto user= UserInfoUtil.getCurrentUser();
        ExtendConfigDto dto=new ExtendConfigDto();
        dto.setSourceTable(sourceTable);
        dto.setColumnName(columnName);
        dto.setOperator("测试");
        dto.setCreateDateTime(new Date());
        dto.setCompanyId(user.getCompanyId());
        ResultInfo<List<ExtendConfigDto>> result=new ResultInfo<List<ExtendConfigDto>>();
        try{
            extendConfigService.insert(dto);
        }
        catch (CustomException ex){
            result.setSuccess(false);
            result.setMsg(ex.getMessage());
        }
        result.setData(extendConfigService.getExtendTitleList(user.getCompanyId(), sourceTable));
        return result;
    }

    @RequestMapping(value = "deleteExtendConfig",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo<List<ExtendConfigDto>> DeleteExtendConfig(Integer sourceTable, Long id) throws CustomException{
        UserInfoApiDto user= UserInfoUtil.getCurrentUser();
        ResultInfo<List<ExtendConfigDto>> result=new ResultInfo<List<ExtendConfigDto>>();
        extendConfigService.delete(id,user.getCompanyId());
        result.setData(extendConfigService.getExtendTitleList(user.getCompanyId(), sourceTable));
        return result;
    }
}
