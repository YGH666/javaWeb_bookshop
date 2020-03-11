package servlet;

import util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/06
 **/
public class CookieServlet extends BaseServlet {
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1", "value1");
        resp.addCookie(cookie);
        resp.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            resp.getWriter().write(cookie.getName()+"="+cookie.getValue()+"<br>");
        }
        Cookie IwantCookie = CookieUtils.findCookie("key1",cookies);
        System.out.println(IwantCookie.getName()+"="+IwantCookie.getValue());
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1", "你好");
        //-1 默认值，浏览器关闭就会删除
//        cookie.setMaxAge(-1);
        //0 马上删除
//        cookie.setMaxAge(0);
        //other 秒数
        cookie.setMaxAge(60*60*24*7);
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie修改成功");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了path为"+req.getContextPath() + "/abc");
    }
}
