package yangguohao.web;

import yangguohao.pojo.Cart;
import yangguohao.pojo.User;
import yangguohao.service.OrderService;
import yangguohao.service.impl.OrderServiceImpl;
import yangguohao.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        Integer userId = user.getId();

        String orderId = orderService.createOrder(cart, userId);

//        request.setAttribute("orderId",orderId);
        request.getSession().setAttribute("orderId",orderId);
//        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
