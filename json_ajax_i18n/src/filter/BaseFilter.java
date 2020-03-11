package filter;

import javax.servlet.*;
import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;

/**
 * @author Mr.Yang
 * @date 2020/03/10
 **/
public class BaseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
