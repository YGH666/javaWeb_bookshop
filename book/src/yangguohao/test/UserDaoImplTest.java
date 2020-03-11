package yangguohao.test;

import org.junit.Test;
import yangguohao.dao.UserDao;
import yangguohao.dao.impl.UserDaoImpl;
import yangguohao.pojo.User;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin11")==null) {
            System.out.println("用户名可用!");
        }else {
            System.out.println("用户名已存在!");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "ygh", "123456", "asd@qq.com")));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin1","admin")==null){
            System.out.println("用户名或密码错误,登陆失败！");
        }else {
            System.out.println("登陆成功！");
        }
    }
}