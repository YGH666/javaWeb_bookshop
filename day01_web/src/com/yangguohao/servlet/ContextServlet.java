package com.yangguohao.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/02/29
 **/
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext context = getServletConfig().getServletContext();
        ServletContext context = getServletContext();
        String name = context.getInitParameter("name");
        String pass = context.getInitParameter("pass");
        System.out.println("name= " + name + " pass= " + pass);
        System.out.println("当前工作路径："+context.getContextPath());
        System.out.println("工程部署的路径:"+context.getRealPath("/"));
        System.out.println("当前工作绝对路径:"+context.getRealPath("/css"));

        context.setAttribute("key1","value1");
        System.out.println("context中获取域数据key1的值是" + context.getAttribute("key1"));


    }
}
