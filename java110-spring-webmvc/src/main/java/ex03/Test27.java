// 세션 다루기 - @SessionAttributes 애노테이션 
package ex03;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/ex03/test27")
// reqeust handler가 Model 이나 Map 객체에 저장하는 값 중에서
// 세션에도 저장할 값을 지정할 때 다음 애노테이션을 사용한다.
@SessionAttributes(value = {"name","gender"})
public class Test27 {
    
    // 테스트:
    //      http://localhost:8888/app/ex03/test27/m1
    //
    @GetMapping(value = "m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(Model model) throws Exception {
        model.addAttribute("name","홍길동");
        model.addAttribute("tel","1111-2222");
        model.addAttribute("gender","남자");
        
        return "ex03.Test27.m1()";
    }
    
    @GetMapping(value = "m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) throws Exception {
        
        String name = (String) session.getAttribute("name");
        String tel = (String) session.getAttribute("tel");
        String gender = (String) session.getAttribute("gender");
        
        return String.format("%s,%s,%s\n", name,tel,gender);
        
    }
    
    @GetMapping(value = "logout1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String logout1(HttpSession session) throws Exception {
        
        session.invalidate();
        
        return String.format("세션이 다 주거버려따!!\n");
    }
    
    @GetMapping(value = "logout2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String logout2(SessionStatus status) throws Exception {

        // @SessionAttributes 에 저장된 session값을 가르킨다.
        
        // 현재 이 request handler가 소속되어 있는 페이지 컨트롤러에서
        // @SessionAttributes에 지정된 값만 HttpSession에서 제거한다.
        // => 즉 name,gender 만 제거된다.
        // => Test28 페이지 컨트롤러에서 관리되는 name2,gender2는 아니다
        // => 기존의 HttpSession 객체는 계속 유효하다.
        // => HttpSession 객체에 직접 저아한 값도 계속 유효하다.
        status.setComplete(); // 세션이 만료되었다는 뜻 안에 정보들이 다 날라간다.
        
        return String.format("@SessionAttributes 관리대상을 다 주겨버려따~!");
    }
}








