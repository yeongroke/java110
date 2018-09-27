package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * javax.servlet.Genericservlet
 * 서블릿 배치 정보 - 컨텍스트 초기화 파라미터
 * => 컨텍스트 초기화 파라미터는 모든 서블릿이 참좔 수 있다.
 *    즉 모든 서블릿이 공유해야 하는 정보를 컨텍스트 초기화 파라미터로 선언하라!
 * => 활용
 *    DB 연결정보 , 파일 업로드 설정 정보 등
 */
//loadOnStartUp 은 순서를 신경 안쓰고 서블릿이 생성되는게 중요함 ,이걸써야 자동으로 생성됨
/*@WebServlet(value = "/ex06/servlet04", loadOnStartup=1,
    initParams= {
        @WebInitParam(name="aaa",value="hello1"),
        @WebInitParam(name="bbb",value="hello2"),
        @WebInitParam(name="ccc",value="hello3"),
})*/
public class Servlet05 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("/ex06/servlet04 실행");
        // 배치 정보에서 초기화 파라미터 값을 꺼내기
        out.printf("서블릿 초기화 파라미터 aaa =%s\n",this.getInitParameter("aaa"));
        
        // 배치 정보에서 컨텍스트 초기화 파라미터 값을 꺼내기
        // => 먼저 서블릿 환경 정보를 다루는 ServletContext 객체를 얻는다.
        ServletContext sc = this.getServletContext();
        
        // => ServletContext 객체를 통해 컨텍스트 초기화 파라미터 값을 꺼낸다.
        out.printf("컨텍스트 초기화 파라미터 aaa=%s\n", sc.getInitParameter("aaa"));
    }
}
