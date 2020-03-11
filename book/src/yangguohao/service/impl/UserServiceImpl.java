package yangguohao.service.impl;

import yangguohao.dao.UserDao;
import yangguohao.dao.impl.UserDaoImpl;
import yangguohao.pojo.User;
import yangguohao.service.UserService;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao= new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            return false;
        }

        return true;
    }
}
