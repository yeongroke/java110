package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {
    
    ManagerDao managerDao; 
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao=managerDao;
    }
    
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        String email = keyIn.nextLine();
        Manager manager = managerDao.findByEmail(email);

        if (email ==null) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        
        System.out.printf("이름: %s\n", manager.getName());
        System.out.printf("이메일: %s\n", manager.getEmail());
        System.out.printf("암호: %s\n", manager.getPassword());
        System.out.printf("직위: %s\n", manager.getPosition());
        System.out.printf("전화: %s\n", manager.getTel());
    }
}
