package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Student m = new Student();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setSchool(request.getParameter("school"));
        m.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        
        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");
        
        try{ 
            studentDao.insert(m);
            response.sendRedirect("list");
        } catch(Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "학생 추가 오류");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
 
}
