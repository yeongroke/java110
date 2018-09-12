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
    public void add(Scanner keyIn) { //중간에 끼는 곳?은 예외 처리 안해주어도된다.
                                    //throw exception써주거나 try catch를 써주어야하는데
                                    //여기서 안써준이유는 runtimeexcetion을쓰면 중간에 안써줘도되는데 
                                    //하지만 어디선가는 써주어야됨
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

            managerDao.insert(m); 
           
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;

        }
    }
}
