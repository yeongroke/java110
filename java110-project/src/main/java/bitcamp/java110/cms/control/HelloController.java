package bitcamp.java110.cms.control;

import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;

//일반 주석! !
@Component
public class HelloController {

    //public String name = "4";  // 위에 애노테이션 주석을 달아서 앲애주어도 된다.
    
    @RequestMapping("hello")
    public void hello(Scanner keyIn) {
        System.out.println("안녕하세요!!!");
        
    }

}
