package com.jxd.eas.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EncodeFilter
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/8/25 15:03
 * @Version 1.0
 */
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //设置编码字符集
        if ("post".equalsIgnoreCase(request.getMethod())) {
            request.setCharacterEncoding("utf-8");
        }

        //将请求继续往下推送，去执行servlet的功能
        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
