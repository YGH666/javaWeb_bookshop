package yangguohao.test;

import org.junit.Test;
import yangguohao.pojo.Cart;
import yangguohao.pojo.CartItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/08
 **/
public class CartTest {
    private Cart cart = new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Unix",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Unix",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Unix",1,new BigDecimal(100),new BigDecimal(100)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java六六六",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Unix",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateCount(2,2);
        System.out.println(cart);
    }
}