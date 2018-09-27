package bitcamp.java110.ex07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * HttpSession 보관소의 값 꺼내기
 */

@WebServlet("/ex07/servlet04")
public class Servlet04 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex07/servlet04 실행");
        
        // ServletContext 보관소에 저장된 값 꺼내기
        // => 먼저 ServletContext 객체를 알아낸다.
        ServletContext sc = this.getServletContext();
        out.printf("ServletContext: aaa=%s\n",sc.getAttribute("aaa"));
        
        // => HttpSession의 값 꺼내기
        // 번호에 맞는 세션의 값을 리턴해주는 것
        HttpSession session = req.getSession();
        out.printf("ServletContext: ccc=%s\n",session.getAttribute("ccc"));
    }
}