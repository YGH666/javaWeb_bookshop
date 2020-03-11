package yangguohao.service;

import yangguohao.pojo.Cart;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
