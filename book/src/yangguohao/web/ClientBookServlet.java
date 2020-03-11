package yangguohao.web;

import yangguohao.pojo.Book;
import yangguohao.pojo.Page;
import yangguohao.service.BookService;
import yangguohao.service.impl.BookServiceImpl;
import yangguohao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/06
 **/
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("转发成功！");

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("几个区间转发成功！");

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        String url = "client/bookServlet?action=pageByPrice";
        if (request.getParameter("min")!=null){
            url += "&min=" + request.getParameter("min");
        }
        if (request.getParameter("max")!=null){
            url += "&max=" + request.getParameter("max");
        }
        int min = WebUtils.parseInt(request.getParameter("min"),0);
        int max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

        page.setUrl(url);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
