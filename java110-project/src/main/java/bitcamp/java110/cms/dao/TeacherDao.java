package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public interface TeacherDao {
    int insert(Teacher teacher);
    List<Teacher> findAll();
    Teacher findByEmail(String email);
    Teacher findByNo(int no);
    int delete(int no);
}
