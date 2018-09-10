package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.App;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 이메일? ");
        String email = keyIn.nextLine();
        Teacher teacher = App.teacherDao.findByEmail(email);
        
        if (email ==null) {
            System.out.println("무효한 이메일입니다.");
            return;
        }
        
        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("전화: %s\n", teacher.getTel());
        System.out.printf("시급: %d\n", teacher.getPay());
        System.out.printf("강의과목: %s\n", teacher.getSubjects());
    }
}
