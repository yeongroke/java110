package bitcamp.java110.cms.service;

import java.util.List;

import bitcamp.java110.cms.domain.Student;

public interface StudentService {
    void add(Student student);
    List<Student> list(int pageNo, int pageSize);
    Student get(int no);
    void delete(int no);
}
