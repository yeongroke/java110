package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.App;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentDetailController {
  
    @RequestMapping("student/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Student student = App.students.get(no);
        
        System.out.printf("이름: %s\n", student.getName());
        System.out.printf("이메일: %s\n", student.getEmail());
        System.out.printf("암호: %s\n", student.getPassword());
        System.out.printf("최종학력: %s\n", student.getSchool());
        System.out.printf("전화: %s\n", student.getTel());
        System.out.printf("재직여부: %b\n", student.isWorking());
    }
}
