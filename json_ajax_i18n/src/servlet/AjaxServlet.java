package servlet;

import com.google.gson.Gson;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/10
 **/
public class AjaxServlet extends BaseServlet {
    protected void JSAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到ajax请求");

        Person person = new Person(1,"杨国豪");

        Gson gson = new Gson();
        String toJson = gson.toJson(person);
        resp.getWriter().write(toJson);
    }

    protected void JQAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到jQuery   ajax请求");

        Person person = new Person(1,"杨国豪");

        Gson gson = new Gson();
        String toJson = gson.toJson(person);
        resp.getWriter().write(toJson);
    }

    protected void JQGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到JQGet   ajax请求");

        Person person = new Person(1,"杨国豪");

        Gson gson = new Gson();
        String toJson = gson.toJson(person);
        resp.getWriter().write(toJson);
    }

    protected void JQPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到JQPost   ajax请求");

        Person person = new Person(1,"杨国豪");

        Gson gson = new Gson();
        String toJson = gson.toJson(person);
        resp.getWriter().write(toJson);
    }

    protected void JQJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到JQJSON   ajax请求");

        Person person = new Person(1,"杨国豪");

        Gson gson = new Gson();
        String toJson = gson.toJson(person);
        resp.getWriter().write(toJson);
    }

    protected void JQSerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到JQSerialize   ajax请求");
        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));
        Person person = new Person(1,"杨国豪");

        Gson gson = new Gson();
        String toJson = gson.toJson(person);
        resp.getWriter().write(toJson);
    }
}
