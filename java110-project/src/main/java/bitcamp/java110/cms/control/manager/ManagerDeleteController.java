package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.App;

@Component
public class ManagerDeleteController {
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        String email = keyIn.nextLine();

        if(App.managerDao.delete(email)>0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("이메일에 해당하는 매니저가 없습니다.");
        }
    }
}
