package com.yunfang.dms.init;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yunfang.dms.dto.UserInfoApiDto;
import com.yunfang.dms.enums.DataSource;
import com.yunfang.dms.utils.CookiesUtil;
import com.yunfang.dms.utils.ReadPropertiesData;
import com.yunfang.dms.utils.URLtoJSONandXML;
import com.yunfang.dms.utils.UserInfoUtil;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Properties;

/**
 * CAS过滤器
 * Created by Administrator on 2017/2/13.
 */
public class CasForInvokeContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //从Cas服务器获取登录账户的用户名
        Assertion assertion = AssertionHolder.getAssertion();
        if (assertion != null) {
            String userName = assertion.getPrincipal().getName();
            Cookie accountCook = CookiesUtil.getCookieByName((HttpServletRequest) servletRequest, "DmsUserName");
            if (accountCook == null || !URLDecoder.decode(accountCook.getValue(),"utf-8").equals(userName)) {
                //登录名放到SESSION中
                Gson gson=new Gson();
                UserInfoApiDto dto= UserInfoUtil.getCurrentUser(userName);
                CookiesUtil.addCookie((HttpServletResponse) servletResponse, "DmsUserInfo", gson.toJson(dto), 30 * 60);
                CookiesUtil.addCookie((HttpServletResponse) servletResponse, "DmsUserName", userName, 30 * 60);
            }
            Cookie cityNameCook=CookiesUtil.getCookieByName((HttpServletRequest) servletRequest, "CityName");
            if(cityNameCook==null){
                CookiesUtil.addCookie((HttpServletResponse) servletResponse, "CityName", "北京市", Integer.MAX_VALUE);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
