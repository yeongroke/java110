package bitcamp.java110.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * javax.servlet.Genericservlet
 * 클라이언트가 보낸 데이터 읽기 - POST 요청으로 보낸 데이터 
 */

//@WebServlet("/ex04/servlet02")
public class Servlet02 extends GenericServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        // POST 요청으로 값을 서버에 전달하는 방법
        // => HTTP 요청에서 message-body 영역에 데이터를 붙여 전달한다.
        //
        // 테스트 :
        // => HTML의 form 태그를 이용하여 전송한다.
        // => http://localhost:8888/ex04/post.html 페이지에서 값을 입력한 후 보내기버튼 클릭
        //
        // => 그러나 서블릿에서 값을 꺼내는 방법은 GET 요청 때와 같다.
        //
        
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean working = Boolean.parseBoolean(req.getParameter("working"));
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name = %s\n",name);
        out.printf("age = %d\n",age);
        out.printf("working = %b\n",working);
    }
}

// POST 요청
//  Request URL: http://localhost:8888/ex04/servlet02
/*
POST /ex04/servlet02 HTTP/1.1
Host: localhost:8888
Connection: keep-alive
Content-Length: 52
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36
Origin: http://localhost:8888
Content-Type: application/x-www-form-urlencoded
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,;q=0.8
Referer: http://localhost:8888/ex04/form.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cookie: JSESSIONID=3C16BA5E559A11DF60356AF93DF6AAA0 
 */

//POST 요청의 특징
// - message-body 영역에 데이터를 포함시킨다.
//   => URL에 데이터가 포함되어 있지 않다
//   => 즐겨찾기에는 URL만 저장되기 때문에 데이터가 포함되지 않는 URL을 저장해봐야 소용없다.
//   => 데이터 조회 화면을 요청할 때는 post 방식을 사용하지 않는다.
// - 보안
//   => URL에 데이터가 포함되어 있지 않기 때문에
//      데이터가 노출되지 말아야 할 경우(예를 들면 로그인 이나 회원가입 등)
//      POST 방식이 적합하다.
// - 대용량 데이터 
//   => 대부분의 웹 서버는 request-uri 또는 헤더를 포함한 메타 데이터의 크기를
//      8KB 미만으로 설정하고 있다.
//      그러나 message-body 영역은 제한을 두지 않거나 큰 용량을 허락하고 있다.
//   => 그래서 대용량의 데이터를 보낼 때는 POST 방식을 사용한다.
// - 바이너리(Binary)의 데이터 전송
//   => message-body 부분에 첨부하기 때문에 바이너리 데이터를 전송할 수 있다.
//      단, 멀티파트 형식으로 보낸다.
// - 적용 부분
//   => 로그인, 회원가입 처럼 데이터가 캐시에 보관되거나 노출되지 말아야 하는 경우
//   => 게시글 들록/변경 처럼 대용량의 데이터를 전송해야 하는 경우
//   => 파일 업로드 처럼 바이너리 데이터를 전송해야 하는 경우