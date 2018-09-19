package bitcamp.java110.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter({"/ex01/*","/ex02/*"})
public class Filter02  implements Filter{

    public Filter02() {
        System.out.println("Filter02() 호출됨.");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filter02.doFilter() --- before");
        chain.doFilter(request, response);
        System.out.println("Filter02.doFilter() --- after");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("Filter02.init() 호출됨");
    }
    @Override
    public void destroy() {
        System.out.println("Filter02.destroy() 호출됨");
    }
}
