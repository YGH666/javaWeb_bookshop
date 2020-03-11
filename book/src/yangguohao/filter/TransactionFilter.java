package yangguohao.filter;

import yangguohao.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class TransactionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();

        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
