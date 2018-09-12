package bitcamp.java110.cms.dao.impi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import annotation.Component;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFileDao implements TeacherDao{
    private List<Teacher> list = new ArrayList<>();
    
    public TeacherFileDao() {
        File dataFile = new File("data/teacher.dat");
        
        try (BufferedReader in = new BufferedReader(new FileReader(dataFile))){
            
            while(true) {
                String line = in.readLine();
                if(line == null) 
                    break;
                String[] values = line.split(",");
                
                Teacher t = new Teacher();
                t.setName(values[0]);
                t.setEmail(values[1]);
                t.setPassword(values[2]);
                t.setTel(values[3]);
                t.setPay(Integer.parseInt(values[4]));
                t.setSubjects(values[5]);
                
                list.add(t);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void save() {
        File dataFile = new File("data/teacher.dat");
        try (BufferedWriter out  = new BufferedWriter(new FileWriter(dataFile));) {
            // try ( ) 가로 안에 선언할 수 있는 것들은 close을 쓸수있는것만 가능하다
            // 안에 써주면 finally에서 close을 해줄필요도 없이 자동으로 close가 된다.
            
            for(Teacher t : list) {
                out.write(String.format("%s,%s,%s,%s,%s,%b\n", 
                       t.getName(),t.getEmail(),t.getPassword()
                       ,t.getTel(),t.getPay(),t.getSubjects()));
            }
            out.flush(); //buffer에 있는 정보를 하나씩 출력하는거(밀어내는 것)
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Teacher teacher) {
        for(Teacher item : list) {
            if(item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
        save();
        return 1; 
    }
    public List<Teacher> findAll() {
        return list;
    }
    public Teacher findByEmail(String email) {
        for(Teacher item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    public int delete(String email) {
        for(Teacher item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
