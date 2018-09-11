package bitcamp.java110.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerListController {
    
    ManagerDao managerDao; 
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao=managerDao;
    }
    
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        List<Manager> list =managerDao.findAll();
        
        for (Manager m : list) {
            System.out.printf("%s, %s, %s, %s, %s\n",
                    m.getName(), 
                    m.getEmail(), 
                    m.getPassword(), 
                    m.getTel(),
                    m.getPosition());
        }
    }
}
