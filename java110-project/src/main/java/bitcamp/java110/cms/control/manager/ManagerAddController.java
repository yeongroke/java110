package bitcamp.java110.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.App;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {
    private List<Manager> managers;
    
    public void setManagerList(List<Manager> Managers) {
        this.managers =Managers;
    }
    
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while (true) {
            Manager m = new Manager();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("직위? ");
            m.setPosition(keyIn.nextLine());
            
            App.managers.add(m);
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
