package bitcamp.java110.cms.dao.impi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import annotation.Component;
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.MandatoryValueDaoException;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentFile2Dao implements StudentDao {
    static String defaultFilename = "data/student2.dat";
    String filename;
    private List<Student> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public StudentFile2Dao(String filename) {
        this.filename=filename;
        File dataFile = new File(filename);
        try (
                FileInputStream in0 = new FileInputStream(dataFile);
                BufferedInputStream in1  = new BufferedInputStream(in0);
                ObjectInputStream in2 =new ObjectInputStream(in1);
                ) {
            // try ( ) 가로 안에 선언할 수 있는 것들은 close을 쓸수있는것만 가능하다
            // 안에 써주면 finally에서 close을 해줄필요도 없이 자동으로 close가 된다.
            list = (List<Student>)in2.readObject();
            /* while (true) {


                //list.add(s);
            }*/
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public StudentFile2Dao() {
        this(defaultFilename);
    }

    private void save() {
        File dataFile = new File(filename);

        try (
                FileOutputStream out0 = new FileOutputStream(dataFile);
                BufferedOutputStream out1 = new BufferedOutputStream(out0);
                ObjectOutputStream out =new ObjectOutputStream(out1);
                ) {
            // try ( ) 가로 안에 선언할 수 있는 것들은 close을 쓸수있는것만 가능하다
            // 안에 써주면 finally에서 close을 해줄필요도 없이 자동으로 close가 된다.
            out.writeObject(list);
            /* for(Manager m : list) {
                out.writeObject(m);
            }*/
            out.flush(); //buffer에 있는 정보를 하나씩 출력하는거(밀어내는 것)
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Student student) throws MandatoryValueDaoException, DuplicationDaoException {
        if(     student.getName().length() == 0 ||
                student.getEmail().length() == 0 ||
                student.getPassword().length() == 0) {

            throw new MandatoryValueDaoException("필수 입력 항목이 비었음");
        }

        for(Student item : list) {
            if(item.getEmail().equals(student.getEmail())) {
                throw new DuplicationDaoException("같은 이메일이 이미 등록됫엄");
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
