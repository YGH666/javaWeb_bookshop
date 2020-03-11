package yangguohao.test;

import org.junit.Test;
import yangguohao.utils.JdbcUtils;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 15; i++) {
            System.out.println(JdbcUtils.getConnection());
        }
    }
}
