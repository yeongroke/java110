package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    List<Manager> list = new ArrayList<>();
    
    int insert(Manager manager) throws MandatoryValueDaoException, DuplicationDaoException;
                                //여러개 에러를 선언가능하다
    List<Manager> findAll();
    Manager findByEmail(String email);
    int delete(String email);
}
