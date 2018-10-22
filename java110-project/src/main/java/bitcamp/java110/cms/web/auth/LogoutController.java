package bitcamp.java110.cms.web.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.mvc.RequestMapping;

@Component
public class LogoutController {

    
    
    @RequestMapping("/auth/logout")
    public String logout(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // 현재 세션 객체를 무효화시킨다.
        session.invalidate();
        
        return"redirect:login";
    }
}














