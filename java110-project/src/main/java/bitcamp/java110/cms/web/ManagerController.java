package bitcamp.java110.cms.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController { 

    ManagerService managerService;
    ServletContext sc;

    // 위에 autowired 을 안쓰고 두 객체의 생성자를 만들면 가능하다
    // 이유는 의존객체가 생기기때문에
    // 하지만 이거말고 다른 생성자를 쓸 경우 에러발생
    // autowired가 더 편하긴 하지만 생성자때문에 작동하는걸 보여주려면 하는게 좋음
    public ManagerController(ManagerService managerService, ServletContext sc) {
        this.managerService = managerService;
        this.sc = sc;
    }

    @GetMapping("list")
    public void list( // list.jsp가 있는 경우 리턴 값이 없어도됨 즉 void
            // 값을 두개 주는 경우에는 이름 생략 안됨
            // value 을 안해주면 int pageNO 이름 그대로 사용함.
            @RequestParam(defaultValue="1") int pageNo,
            @RequestParam(defaultValue="3") int pageSize,
            Model model) { 

        if (pageNo < 1)
            pageNo = 1;

        if (pageSize < 3 || pageSize > 10)
            pageSize = 3;

        List<Manager> list = managerService.list(pageNo, pageSize);
        model.addAttribute("list", list);
    }

    @GetMapping("detail")
    public void detail(Model model
            ,int no) 
            throws ServletException, IOException {

        Manager m = managerService.get(no);

        // JSP 페이지에서 사용할 수 있도록 ServletRequest 보관소에 저장한다.
        model.addAttribute("manager", m);
    }

    @GetMapping("form")
    public void form() {
        
    }
    
    @PostMapping("add")
    public String add(MultipartFile file1,
            Manager manager) throws Exception {

        if (file1.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            manager.setPhoto(filename);
        }
        managerService.add(manager);
        // 오류 없이 등록에 성공했으면, 
        // 목록 페이지를 다시 요청하라고 redirect 명령을 보낸다.
        // redirect:list이므로 이거는 void 쓰면안됨
        return "redirect:list";
    }

    @GetMapping("delete")
    public String delete(
            int no) throws Exception {

        managerService.delete(no);
        return "redirect:list";
    }
}
