package com.yunfang.dms.init;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

/**CAS过滤器
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
        if(assertion != null){
            String userName =assertion.getPrincipal().getName();
            //登录名放到SESSION中
            //todo:根据登录名称获取用户信息及用户所在公司信息
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            session.setAttribute("userName", userName);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
