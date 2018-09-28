package bitcamp.java110.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 리프래시
 * => 리프래시 란? 
 *    서버가 보낸 콘텐트를 클라이언트가 출력한 후에
 *    지정한 URL로 자동으로 요청하게 만드는 기술
 */

@WebServlet("/ex08/servlet01")
public class Servlet01 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 방법1)
        // => 응답 헤더에 리프래시 명령을 추가하기
        // => 다음은 응답 내용을 출력한 후, 2초 후에 http://daum.net을 요청하라는 명령
        //res.setHeader("Refresh", "2;url=http://daum.net"); //2초뒤에 http://daum.net로 가라는거임
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        
        // 방법2)
        // => HTML의 <meta> 태그에 리프래시 명령을 설정할 수 있다.
        //    head태그 안에 넣어주어야 한다 body에 넣으면 안됨.
        out.println("<meta http-equiv='refresh' content='5;url=http://naver.com'>");
        
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex08</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>servlet01 실행</h1>");
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
