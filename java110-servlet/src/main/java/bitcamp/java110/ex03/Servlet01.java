package bitcamp.java110.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * javax.servlet.Genericservlet
 * 클라이언트로 출력하기
 */

//@WebServlet("/ex03/servlet01")
public class Servlet01 extends GenericServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("hello");
        out.println("안녕하세요");
        out.println("こんにちは");
        out.println("boujour");
        // 문제점?
        // - 영어를 제외한 다른 언어의 문자가 ?으로 출력된다.
        //
        // 이유?
        // - getwriter()가 리턴한 출력스트림은 기본적으로
        //   자바 유니코드를 ISO-8859-1 문자표에 따라 인코딩하여 출력하기 때문이다.
        // - 따라서 ISO-8859-1에 정의되지 않는 유니코드는 '?'로 대체되어 출력된다.
    }
}