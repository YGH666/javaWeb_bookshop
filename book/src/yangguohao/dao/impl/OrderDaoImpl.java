package yangguohao.dao.impl;

import yangguohao.dao.OrderDao;
import yangguohao.pojo.Order;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {

        System.out.println("OrderDaoImpl在线程["+Thread.currentThread().getName()+"]");


        String sql = "insert into t_order(order_id, create_time, price, status, user_id)values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
