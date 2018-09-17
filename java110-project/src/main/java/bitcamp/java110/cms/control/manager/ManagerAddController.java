package bitcamp.java110.cms.control.manager;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class ManagerAddController { 

    ManagerDao managerDao;
  
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/add")
    public void add(Request request , Response response) {
        while (true) {
            Manager m = new Manager();
            
            m.setName(request.getParameter("name"));
            m.setEmail(request.getParameter("email"));
            m.setPassword(request.getParameter("password"));
            m.setPosition(request.getParameter("position"));
            m.setTel(request.getParameter("tel"));
            
            managerDao.insert(m);
            
            PrintWriter out = response.getWriter();
            out.println("등록하였습니다");
        }
    }
    
}
