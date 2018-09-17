package bitcamp.java110.cms.control.teacher;

import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class TeacherAddController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/add")
    public void add(Request request , Response response) {
        while (true) {
            Teacher m = new Teacher();
             
            m.setName(request.getParameter("name"));
            m.setEmail(request.getParameter("email"));
            m.setPassword(request.getParameter("password"));
            m.setTel(request.getParameter("tel"));
            m.setPay(Integer.parseInt(request.getParameter("pay")));
            m.setSubjects(request.getParameter("subjects"));
            
            teacherDao.insert(m);
            
            PrintWriter out = response.getWriter();
            out.println("등록하였습니다");
        }
    }
}
