package bitcamp.java110.cms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import annotation.Component;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentFileDao implements StudentDao {
    private List<Student> list = new ArrayList<>();

    public StudentFileDao() {
        File dataFile = new File("data/student.dat");
        try (BufferedReader in  = new BufferedReader(new FileReader(dataFile));) {
            // try ( ) 가로 안에 선언할 수 있는 것들은 close을 쓸수있는것만 가능하다
            // 안에 써주면 finally에서 close을 해줄필요도 없이 자동으로 close가 된다.

            while (true) {
                String line = in.readLine();
                if(line == null)
                    break;
                String[] values = line.split(",");

                Student s = new Student();
                s.setEmail(values[0]);
                s.setName(values[1]);
                s.setPassword(values[2]);
                s.setSchool(values[3]);
                s.setTel(values[4]);
                s.setWorking(Boolean.parseBoolean(values[5]));
                
                list.add(s);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void save() {
        File dataFile = new File("data/student.dat");
        try (BufferedWriter out  = new BufferedWriter(new FileWriter(dataFile));) {
            // try ( ) 가로 안에 선언할 수 있는 것들은 close을 쓸수있는것만 가능하다
            // 안에 써주면 finally에서 close을 해줄필요도 없이 자동으로 close가 된다.
            
            for(Student s : list) {
                out.write(String.format("%s,%s,%s,%s,%s,%b\n", 
                        s.getEmail(),s.getName(),s.getPassword()
                        ,s.getSchool(),s.getTel(),s.isWorking()));
            }
            out.flush(); //buffer에 있는 정보를 하나씩 출력하는거(밀어내는 것)
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Student student) {
        for(Student item : list) {
            if(item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        save();
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
                save();
                return 1;
            }
        }
        return 0;
    }
}
