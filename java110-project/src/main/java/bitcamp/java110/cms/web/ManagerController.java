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
import org.springframework.stereotype.Component;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.mvc.RequestParam;
import bitcamp.java110.cms.service.ManagerService;

@Component
public class ManagerController { 

    @Autowired
    ManagerService managerService;

    @Autowired
    ServletContext sc;

    @RequestMapping("/manager/list")
    public String list(
            // 값을 두개 주는 경우에는 이름 생략 안됨
            @RequestParam(value="pageNo",defaultValue="1") int pageNo,
            @RequestParam(value="pageSize",defaultValue="3") int pageSize,
            Map<String, Object> map) { 

        if (pageNo < 1)
            pageNo = 1;

        if (pageSize < 3 || pageSize > 10)
            pageSize = 3;

        List<Manager> list = managerService.list(pageNo, pageSize);
        map.put("list", list);

        return "/manager/list.jsp";
    }

    @RequestMapping("/manager/detail")
    public String detail(Map<String, Object> map
            ,@RequestParam(value="no") int no) 
            throws ServletException, IOException {

        Manager m = managerService.get(no);

        // JSP 페이지에서 사용할 수 있도록 ServletRequest 보관소에 저장한다.
        map.put("manager", m);
        return "/manager/detail.jsp";
    }

    @RequestMapping("/manager/add")
    public String add(HttpServletRequest request,
            Manager manager) throws Exception {

        if(request.getMethod().equals("GET")) {
            return "/manager/form.jsp";
        }

        // 사진 데이터 처리
        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(sc.getRealPath("/upload/" + filename));
            manager.setPhoto(filename);
        }
        managerService.add(manager);
        // 오류 없이 등록에 성공했으면, 
        // 목록 페이지를 다시 요청하라고 redirect 명령을 보낸다.
        return "redirect:list";
    }

    @RequestMapping("/manager/delete")
    public String delete(HttpServletRequest request
            ,@RequestParam(value="no") int no) throws Exception {

        managerService.delete(no);
        return "redirect:list";
    }
}
