package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Exception e = (Exception) request.getAttribute("error");
        String message = (String) request.getAttribute("message");
        String refresh = (String) request.getAttribute("refresh");
        if(request.getAttribute("error") != null) {
            response.setHeader("Refresh", refresh);
        }
        response.setHeader("Refresh", "3;url=list");

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>\n",message);
        out.printf("<p>%s<p>\n",e.getMessage());
        out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
