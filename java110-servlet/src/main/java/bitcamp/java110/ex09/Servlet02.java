package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 포워드(forward)
 * => 다른 서블릿으로  작업을 위임하는 기술
 *    이전 서블릿에서 출력한 내용이 있다면 포워드 전에 버린다.
 *    그래서 작업을 위임 받은 서블릿에서 새로 출력한다.
 */

@WebServlet("/ex09/servlet02")
public class Servlet02 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // ServletRequsst 보관소에 저장된 값을 꺼낸다.
        // => forward, include 서블릿끼리는
        //    ServletRequest 보관소를 통해 값을 공유할 수 있다.
        //
        String op = (String)req.getParameter("op");
        int a = (int)req.getAttribute("a");
        int b = (int)req.getAttribute("b");
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex09</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>빼기 계산 결과</h1>");
        if(!op.equals("-")) {
            // 연산자가 '빼기'가 아니라면 servlet03에게 작업을 위임한다.
            RequestDispatcher 요청배달자 = req.getRequestDispatcher("servlet03");
            요청배달자.forward(req, res);
            return;
        }
        out.printf("<p>%d - %d = %d</p>\n",a,b,(a-b));
        out.println("</body>");
        out.println("</html>");
    }
}

// 리프래시 응답 프로토콜
/*
HTTP/1.1 200   <=== 웅답 상태 코드는 일반적인 요청처리와 같다.
Content-Type: text/html;charset=UTF-8
Content-Length: 202
Date: Fri, 28 Sep 2018 05:33:23 GMT
*/

/*
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='refresh' content='5;url=http://naver.com'>
<meta charset='UTF-8'>
<title>ex08</title>
</head>
<body>
<h1>servlet01 실행</h1>
</body>
</html>

*/
