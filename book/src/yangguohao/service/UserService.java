package yangguohao.service;

import yangguohao.pojo.User;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登陆失败
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existUsername(String username);
}
