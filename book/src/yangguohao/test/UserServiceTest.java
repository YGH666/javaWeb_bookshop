package yangguohao.test;

import org.junit.Test;
import yangguohao.pojo.User;
import yangguohao.service.UserService;
import yangguohao.service.impl.UserServiceImpl;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"asdasd","555555","asdasd@qq.com"));
        userService.registUser(new User(null,"vvvvvv","666666","vvvvvv@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"ygh","123456",null)));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("ygh1")){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}