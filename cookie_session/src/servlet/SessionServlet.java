package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/08
 **/
public class SessionServlet extends BaseServlet {
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("获取key1的值="+req.getSession().getAttribute("key1"));
    }

    protected void getTimeOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("默认超时时长="+req.getSession().getMaxInactiveInterval()+"秒");
    }

    protected void createOrGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    boolean isNew = session.isNew();

    String id = session.getId();
    resp.getWriter().write("id="+id+"；是否为新："+isNew);
}
}
