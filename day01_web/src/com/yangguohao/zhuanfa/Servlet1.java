package com.yangguohao.zhuanfa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        request.setAttribute("key","柜台1的章");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/form.html");

        requestDispatcher.forward(request,response);
    }
}
