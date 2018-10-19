package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

// 
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired 
    SqlSessionFactory sqlSessionFactory;
    
    @Override
    public Member getMember(
            String email, String password, String memberType) {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("email", email);
            params.put("password", password);

            if (memberType.equals("manager")) {
                ManagerDao managerDao = session.getMapper(ManagerDao.class);
                // session.getMapper(ManagerDao.class)
                // - 동적으로 실행하는 시점에 자동으로 클래스를 만들어준다 - 프록시
                //   같은 이름의 mapper을 찾는다.
                        return managerDao.findByEmailPassword(params);

            } else if (memberType.equals("student")) {
                StudentDao studentDao = session.getMapper(StudentDao.class);
                return studentDao.findByEmailPassword(params);

            } else if (memberType.equals("teacher")) {
                TeacherDao teacherDao = session.getMapper(TeacherDao.class);
                return teacherDao.findByEmailPassword(params);

            } else {
                return null;
            }
        }
    }
}










