package bitcamp.java110.cms.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;

@Controller
public class TeacherController {
    
    @Autowired
    TeacherService teacherService;
    
    @Autowired
    ServletContext sc;
    
    @RequestMapping("/teacher/list")
    public String list(Map<String, Object> map,
            @RequestParam(value="pageNo",defaultValue="1") int pageNo,
            @RequestParam(value="pageSize",defaultValue="3") int pageSize) 
            throws Exception {

            if (pageNo < 1)
                pageNo = 1;
            if (pageSize < 3 || pageSize > 10)
                pageSize = 3;
        
        List<Teacher> list = teacherService.list(pageNo, pageSize);
        map.put("list", list);
        
        return "/teacher/list.jsp";
    }
    
    @RequestMapping("/teacher/detail")
    public String detail(Map<String, Object> map,
            int no) 
                    throws ServletException, IOException {
        
        Teacher t = teacherService.get(no);
        map.put("teacher", t);
        
        return "/teacher/detail.jsp";
    }

    @RequestMapping("/teacher/add")
    public String add(Teacher teacher,
            HttpServletRequest request) throws Exception {
        
        if(request.getMethod().equals("GET")) {
        return "/teacher/form.jsp";
        }
        
            // 사진 데이터 처리
            Part part = request.getPart("file1");
            if (part.getSize() > 0) {
                String filename = UUID.randomUUID().toString();
                part.write(sc.getRealPath("/upload/" + filename));
                teacher.setPhoto(filename);
            }
            teacherService.add(teacher);
            return "redirect:list";
    }
    
    
    @RequestMapping("/teacher/delete")
    public String delete(int no) 
                    throws ServletException, IOException {

        teacherService.delete(no);
        return "redirect:list";

    }
}
