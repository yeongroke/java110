package bitcamp.java110.ex05;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class MyHttpServlet extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 여기에서 ServletRequest와 ServletResponse를
        // HttpServletRequest와 HttpServletResponse로 타입 캐스팅 한다.
        HttpServletRequest httpReq = (HttpServletRequest)req;
        HttpServletResponse httpRes = (HttpServletResponse)res;
        
        this.service(httpReq, httpRes);
        // 이걸 호출하는게 가능한 이유는 이게 지금 호출 할 때쯤이면 이 메서드가 이미 구현되어있고
        // 아래 추상 service를 호출하는게 아니고 다른 걸 상속받은걸 호출 하는것임
    }
    public abstract void service(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException;
    
}
