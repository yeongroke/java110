package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;

@Component
public class StudentDeleteController {

    StudentDao studentDao;
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 학생의 이메일 ? ");
        String email = keyIn.nextLine();

        if(studentDao.delete(email)>0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("이메일에 해당하는 학생이 없습니다.");
        }
    }
}
