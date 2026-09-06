package com.jxd.eas.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginControlFilter
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 15:47
 * @Version 1.0
 */
public class LoginControlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取并判断当前访问路径是否是白名单
        String currPath = request.getServletPath();
        //获取白名单
        String unChkUrl = request.getServletContext().getInitParameter("unChkUrl");
        if (unChkUrl.indexOf(currPath) != -1) {
            //放行
            filterChain.doFilter(request,response);
            return;
        }

        //获取session
        HttpSession session = request.getSession();
        if (session.getAttribute("uname") == null) {
            //未登录，重定向到控制器登录入口
            response.sendRedirect(request.getContextPath() + "/toLogin");
        } else {
            //已登录
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
