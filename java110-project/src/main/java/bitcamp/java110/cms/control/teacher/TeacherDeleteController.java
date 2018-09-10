package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.App;

@Component
public class TeacherDeleteController {
    
    @RequestMapping("teacher/delete")
    private void delete(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        App.teachers.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
}
