package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import annotation.Component;
import annotation.RequestMapping;
import bitcamp.java110.cms.App;

@Component
public class TeacherDeleteController {
    
    @RequestMapping("teacher/delete")
    private void delete(Scanner keyIn) {
        System.out.print("삭제할 이메일? ");
        String email = keyIn.nextLine();
        
        if (App.teacherDao.delete(email)>0) {
            System.out.println("삭제완료.");
            return;
        }else {
            System.out.println("해당 이메일 없음");
        }
    }
}
