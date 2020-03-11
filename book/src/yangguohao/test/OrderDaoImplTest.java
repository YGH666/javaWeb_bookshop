package yangguohao.test;

import org.junit.Test;
import yangguohao.dao.OrderDao;
import yangguohao.dao.impl.OrderDaoImpl;
import yangguohao.pojo.Order;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567891",new Date(),new BigDecimal(100),0,111));
    }
}