package yangguohao.web;

import yangguohao.pojo.Book;
import yangguohao.pojo.Page;
import yangguohao.service.BookService;
import yangguohao.service.impl.BookServiceImpl;
import yangguohao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Yang
 * @date 2020/03/05
 **/
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(request.getParameterMap(),new Book());
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        bookService.deleteBookById(id);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(request.getParameterMap(),new Book());
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page");
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Book book = bookService.querBookByid(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }


    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();

        request.setAttribute("books",books);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
