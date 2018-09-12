package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    List<Manager> list = new ArrayList<>();
    
    int insert(Manager manager);
    List<Manager> findAll();
    Manager findByEmail(String email);
    int delete(String email);
}
