package yangguohao.dao.impl;

import yangguohao.dao.OrderItemDao;
import yangguohao.pojo.OrderItem;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class OrderItemImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {

        System.out.println("OrderItemImpl在线程["+Thread.currentThread().getName()+"]");



        String sql = "insert into t_order_item(name, count, price, total_price, order_id)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
