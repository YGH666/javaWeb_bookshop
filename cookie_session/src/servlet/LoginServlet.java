package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/08
 **/
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String password = request.getParameter("password");
        System.out.println("password = " + password);
        if ("yangguohao".equals(username) && "123456".equals(password)){
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            System.out.println("登陆成功！");
        }else {
            System.out.println("登陆失败！");
        }
    }
}
