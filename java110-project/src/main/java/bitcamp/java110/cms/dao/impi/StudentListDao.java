package bitcamp.java110.cms.dao.impi;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

//@Component //주석 하는 순간 객체가 안만들어짐
public class StudentListDao implements StudentDao{
    private List<Student> list = new ArrayList<>();
    
    public int insert(Student student) {
        for(Student item : list) {
            if(item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        return 1; 
    }
    public List<Student> findAll() {
        return list;
    }
    public Student findByEmail(String email) {
        for(Student item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    public int delete(String email) {
        for(Student item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
