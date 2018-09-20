package bitcamp.java110.ex02;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * 서블릿 만들기 2
 * javax.servlet.Genericservlet
 */

//@WebServlet("/ex02/servlet02")
public class Servlet02 extends GenericServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service02().service() 호출됨.");
    }
}