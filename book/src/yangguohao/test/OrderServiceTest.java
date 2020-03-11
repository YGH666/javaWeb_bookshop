package yangguohao.test;

import org.junit.Test;
import yangguohao.pojo.Cart;
import yangguohao.pojo.CartItem;
import yangguohao.service.OrderService;
import yangguohao.service.impl.OrderServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Unix",1,new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService =new OrderServiceImpl();
        System.out.println("订单号是："+orderService.createOrder(cart,1));
    }
}