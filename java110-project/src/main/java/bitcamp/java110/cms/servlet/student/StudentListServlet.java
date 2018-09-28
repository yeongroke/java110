package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");

        List<Student> list = studentDao.findAll();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>매니저 관리</title>");
        out.println("<style>");
        out.println("table , th , td{");
        out.println("border: 1px solid gray;");
        out.println("text-align : center;");
        out.println("}");
        out.println("a:hover{");
        out.println("background-Color : yellow;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 목록</h1>");

        out.println("<p><a href = 'form1.html'>추가</a></p>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>번호</th><th>이름</th><th>이메일</th><th>학교</th><th>일하는중 ?</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for (Student s : list) {
            out.println("<tr>");
            out.printf("<td><strong>%d</strong></td>\n",s.getNo());
            out.printf("<td><a href='detail?no=%d'>%s</a></td>\n",
                    s.getNo(),
                    s.getName());
            out.printf("<td>%s</td>\n",s.getEmail());
            out.printf("<td>%s</td>\n",s.getSchool());
            out.printf("<td>%s</td>\n",s.isWorking());
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
