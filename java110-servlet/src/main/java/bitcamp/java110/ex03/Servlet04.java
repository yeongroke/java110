package bitcamp.java110.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * javax.servlet.Genericservlet
 * Binary 출력하기
 */

//@WebServlet("/ex03/servlet04")
public class Servlet04 extends GenericServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 웹 애플리케이션 정보를 다루는 객체를 얻는다.
        ServletContext ctx = this.getServletContext();

        // ServletContext 객체를 통해 현재 웹 애플리케이션의 실제 경로를 알아낸다.
        String filepath = ctx.getRealPath("/WEB-INF/pic1.jpeg");

        //FileInputStream in = new FileInputStream(filepath);

        // img파일은 text/html;charset=UTF-8 대신에 image/jpeg 를 써야된다
        res.setContentType("image/jpeg");
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(filepath));
                BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());
                ) {
            int b;
            //현업에서는 ture을 안쓰고 저렇게 쓴다 
            while((b = in.read()) != -1) {
                out.write(b);
            }
            out.flush();
        }
    }
}