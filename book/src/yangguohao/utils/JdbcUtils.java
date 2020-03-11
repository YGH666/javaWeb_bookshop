package yangguohao.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mr.Yang
 * @date 2020/03/01
 **/
public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池的连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = conns.get();

        if (conn == null){
            try {
                conn = dataSource.getConnection();

                conns.set(conn);

                conn.setAutoCommit(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }


    public static void commitAndClose(){
        Connection connection = conns.get();

        if (connection != null){

            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        conns.remove();
    }

    public static void rollbackAndClose(){
        Connection connection = conns.get();

        if (connection != null){

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        conns.remove();
    }


    /**
     * 关闭连接
     * @param conn
     */
//    public static void close(Connection conn){
//        if (conn != null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
