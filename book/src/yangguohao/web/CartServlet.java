package yangguohao.web;

import com.google.gson.Gson;
import yangguohao.dao.BookDao;
import yangguohao.dao.impl.BookDaoImpl;
import yangguohao.pojo.Book;
import yangguohao.pojo.Cart;
import yangguohao.pojo.CartItem;
import yangguohao.service.BookService;
import yangguohao.service.impl.BookServiceImpl;
import yangguohao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Yang
 * @date 2020/03/08
 **/
public class CartServlet extends BaseServlet {
    private BookService bookService= new BookServiceImpl();
    private BookDao bookDao =new BookDaoImpl();
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        int count = WebUtils.parseInt(request.getParameter("count"),1);

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null){
            cart.updateCount(id,count);
        }

        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null){
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null){
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("加入购物车成功！编号"+request.getParameter("id"));
        int id = WebUtils.parseInt(request.getParameter("id"),0);

        Book book = bookService.querBookByid(id);

        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());
        System.out.println(cart);
//        System.out.println("referer="+request.getHeader("Referer"));
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("加入购物车成功！编号"+request.getParameter("id"));
        int id = WebUtils.parseInt(request.getParameter("id"),0);

        Book book = bookService.querBookByid(id);

        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());
        System.out.println(cart);

        Map<String,Object> map = new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String toJson = gson.toJson(map);

        response.getWriter().write(toJson);
    }

}
