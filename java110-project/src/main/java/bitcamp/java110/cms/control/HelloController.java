package bitcamp.java110.cms.control;

import java.util.Scanner;

import annotation.Component;

//일반 주석! !
@Component("4")
public class HelloController  implements Controller{

    //public String name = "4";  // 위에 애노테이션 주석을 달아서 앲애주어도 된다.
    
    @Override
    public void service(Scanner keyIn) {
        System.out.println("안녕하세요!!!");
        
    }

}
