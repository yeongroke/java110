package bitcamp.java110.test;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test/Servlet01")
public class Servlet01 implements Servlet{

    ServletConfig config;
    
    public Servlet01() {
        System.out.println("servlet01 호출 완료!");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        
    }
    
    
}
