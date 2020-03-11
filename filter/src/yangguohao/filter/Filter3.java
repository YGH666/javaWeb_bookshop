package yangguohao.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/09
 **/
public class Filter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter3前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter3后置代码");

    }

    @Override
    public void destroy() {

    }
}
