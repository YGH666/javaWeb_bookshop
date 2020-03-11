package yangguohao.dao;

import yangguohao.pojo.User;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public interface UserDao{
    /**
     *
     * @param username
     * @return 如果返回null，则没有该用户。
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1是操作失败
     */
    public int saveUser(User user);

    /**
     *
     * @param username
     * @param password
     * @return 返回null说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);
}
