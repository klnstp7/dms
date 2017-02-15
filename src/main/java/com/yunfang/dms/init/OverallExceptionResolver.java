package com.yunfang.dms.init;

import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.utils.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**全局异常处理
 * Created by Administrator on 2017/1/24.
 */
//@Controller
public class OverallExceptionResolver implements HandlerExceptionResolver {
    /**
     * 进行全局异常的过滤和处理
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //handler为当前处理器适配器执行的对象
        String message = null;
        //判断是否为系统自定义异常。
        if (ex instanceof CustomException) {
            message = ((CustomException) ex).getMessage();
        } else {
            LogUtil.error(ex);
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/error/index");
        return modelAndView;
    }
}