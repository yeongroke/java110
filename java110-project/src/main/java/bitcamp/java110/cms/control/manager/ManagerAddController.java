package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

//@RequestMapping
@Component
public class ManagerAddController {  // --> ManagerDao를 의존한다
   
    //@RequestMapping //filed에서는 타겟설정안해서 못쓴다
    ManagerDao managerDao; 
    //@Component component에서 타겟을 설정해서 여기다 못씀
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao=managerDao;
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
            
            int rtval = 0;
            if((rtval = managerDao.insert(m))>0) {
                System.out.println("저장하였습니다");
            } else if(rtval == -1){
                System.out.println("필수 입력 항목이 비었습니다.");
            } else if(rtval == -2) {
                System.out.println("같은 이메일이 존재합니다.");
            }
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
