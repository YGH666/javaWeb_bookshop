package yangguohao.test;

import org.junit.Test;
import yangguohao.dao.OrderItemDao;
import yangguohao.dao.impl.OrderItemImpl;
import yangguohao.pojo.OrderItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class OrderItemImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java",2,new BigDecimal(25),new BigDecimal(50),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"java2",1,new BigDecimal(25),new BigDecimal(25),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"java3",4,new BigDecimal(25),new BigDecimal(100),"1234567890"));
    }
}