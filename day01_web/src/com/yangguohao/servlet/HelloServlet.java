package com.yangguohao.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/02/29
 **/
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化");
        System.out.println("程序的别名是：" + servletConfig.getServletName());
        System.out.println("初始化参数url的值=" + servletConfig.getInitParameter("url"));
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 处理请求和响应
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service=====servlet被访问了");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)){
            System.out.println("get请求");
        }else if ("POST".equals(method)){
            System.out.println("post请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 销毁方法");
    }
}
