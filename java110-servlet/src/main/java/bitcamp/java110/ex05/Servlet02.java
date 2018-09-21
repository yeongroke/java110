package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GenericServlet을 직접 상속 받는 것보다
// MyHttpServlet 클래스를 상속 받으면
// HttpServletRequest, HttpServletResponse를 파라미터로 받는
// service()를 오버라이딩 할 수 있다. 그래서 프로그래밍 하기 편한다!
@WebServlet("/ex05/servlet02")
public class Servlet02 extends MyHttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 테스트:
        // => http://localhost:8888/ex05/test.html

        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();

        // GET/POST/HEAD 등을 구분하는 것은 HTTP 프로토콜의 기능이다.
        // ServletRequest에는 HTTP를 다루는 메서드가 없다.
        // 따라서 원래의 타입인 HttpServletRequest로 변환해야만 가능하다.

        String method = req.getMethod();

        if(method.equals("GET")){
            out.println("GET 요청입니다.");
        }else if(method.equals("POST")) {
            out.println("POST 요청입니다.");
        }else {
            out.println("기타 요청입니다.");
        }
    }
}
