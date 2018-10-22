package bitcamp.java110.cms.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.service.StudentService;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        
        int no = Integer.parseInt(request.getParameter("no"));
        
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext()
                                        .getAttribute("iocContainer");
        StudentService studentService = 
                iocContainer.getBean(StudentService.class);
        
        try {
            studentService.delete(no);
            request.setAttribute("viewUrl", "redirect:list");
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "학생 삭제 오류!");
            request.setAttribute("refresh", "3;url=list");
            request.setAttribute("viewUrl", "/error.jsp");
        }
        
    }

}
