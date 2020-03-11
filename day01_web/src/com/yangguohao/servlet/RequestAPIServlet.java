package com.yangguohao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的相对路径
        System.out.println("URI   =>>>"+req.getRequestURI());
        //获取请求的绝对路径
        System.out.println("URL   =>>>"+req.getRequestURL());
        //获取客户端IP地址
        System.out.println("Client IP=>>"+req.getRemoteHost());
        //获取请求头
        System.out.println("请求头User-Agent =>>"+req.getHeader("User-Agent"));
        System.out.println("请求头Accept-Language =>>"+req.getHeader("Accept-Language"));
        //请求方式
        System.out.println("请求方式  =>>"+req.getMethod());
    }
}
