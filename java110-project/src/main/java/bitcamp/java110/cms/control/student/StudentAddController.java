package bitcamp.java110.cms.control.student;

import java.util.List;
import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.App;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    private List<Student> students;
    
    public void setStudentList(List<Student> students) {
        this.students =students;
        init();
    }
    
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while (true) {
            Student m = new Student();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력? ");
            m.setSchool(keyIn.nextLine());
            
            System.out.print("재직여부?(true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            App.students.add(m);
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    public void init() { // 인스턴스 블록
        Student s = new Student();
        s.setName("a");
        students.add(s);
        
        s = new Student();
        s.setName("b");
        students.add(s);
        
        s = new Student();
        s.setName("c");
        students.add(s);
        
        s = new Student();
        s.setName("d");
        students.add(s);
        
        s = new Student();
        s.setName("e");
        students.add(s);
    }
}
