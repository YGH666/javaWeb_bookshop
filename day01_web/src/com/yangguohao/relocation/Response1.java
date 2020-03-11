package com.yangguohao.relocation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向无法访问WEB-INF下的资源，能访问外部资源
 * 转发能访问到WEB-INF下的资源，无法访问外部资源
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setStatus(302);
//        response.setHeader("location","http://localhost:8080/day01_web/response2");
//        response.setHeader("location","http://www.bilibili.com");

        response.sendRedirect("http://localhost:8080/day01_web/response2");
//        response.sendError(403);

    }
}
