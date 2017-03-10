package com.yunfang.dms.interceptor;

import com.yunfang.dms.dao.datasource.DataSourceTypeManager;
import com.yunfang.dms.dto.CityInfoDto;
import com.yunfang.dms.enums.DataSource;
import com.yunfang.dms.utils.CookiesUtil;
import com.yunfang.dms.utils.LogUtil;
import com.yunfang.dms.utils.StringUtil;
import org.apache.commons.collections4.Put;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/**
 * 数据源拦截器
 * Created by Administrator on 2017/3/1.
 */
@Aspect
@Component
public class DataSourceInterceptor {
    private HashMap<String, String> cityMap = new HashMap<String, String>() {
        {
            put("北京", "BEIJING");
            put("上海", "SHANGHAI");
            put("广州", "GUANGZHOU");
        }
    };

    //定义Service切入点
    @Pointcut("execution(* com.yunfang.dms.service..*.*(..))")
    public void runService() {
    }

    //在执行Service层方法前先根据城市选择数据源
    @Before("runService()")
    public void setDataSoruce(JoinPoint jointPoint) throws UnsupportedEncodingException {
        DataSource soruce = null;
        String city = null;
        Object[] parms = jointPoint.getArgs();
        for (Object parm : parms) {
            if (parm.getClass().equals(CityInfoDto.class)) {
                CityInfoDto cityInfoDto = (CityInfoDto) parm;
                //使用参数的城市名称
                if (cityInfoDto.getUseCity()) {
                    city = cityInfoDto.getCityName();
                    break;
                }
            }
        }
        if (city == null) {
            //使用COOKIE里的城市名称
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            city = URLDecoder.decode(CookiesUtil.getCookieByName(request, "CityName").getValue(), "utf-8");
        }
        if (!StringUtil.isNullOrEmpty(city)) {
            if (StringUtil.isChinese(city)) {
                if (city.contains("市")) {
                    soruce = DataSource.valueOf(cityMap.get(StringUtil.subStrStart(city, city.indexOf("市"))));
                } else {
                    soruce = DataSource.valueOf(cityMap.get(StringUtil.subStrStart(city, 2)));
                }
            } else {
                soruce = DataSource.valueOf(city.toUpperCase());
            }
            DataSourceTypeManager.set(soruce);
        }
    }
}
