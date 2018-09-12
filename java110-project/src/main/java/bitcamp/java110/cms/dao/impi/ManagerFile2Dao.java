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
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao {
    static String defaultFilename = "data/manager2.dat";
    String filename; //아래 생성자속에 생성자에서 filename을 선언해주엇기 때문에 이렇게 써주어도 아래에서 적용됨.
    
    //파일 위치 헷갈리까봐 이렇게 선언을 해주는것임
    private List<Manager> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) { //생성자를 만들지 않으면 컴파일러가 자동으로 default생성자를 만든다.
        this.filename=filename;
        File dataFile = new File(filename);
        try (
                FileInputStream in0= new FileInputStream(dataFile);
                BufferedInputStream in1  = new BufferedInputStream(in0);
                //버퍼아웃풋스트림은 출력이 목적이 아니고 주로 저장하는 공간이고 파일아웃풋스트립이 그 저장된걸 출력한다.
                ObjectInputStream in2 = new ObjectInputStream(in1);
                ){
            
            list = (List<Manager>)in2.readObject();
            /*while (true) {
                try {
                    Manager m = (Manager)in.readObject();
                    list.add(m);
                }catch(Exception e) {
                    //e.printStackTrace();
                    break;
                }
            }*/
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ManagerFile2Dao() {
        this(defaultFilename); // 이렇게 생성자는 반드시 첫줄에서 선언을 해주어야 한다.
        //위에서 static을 선언해주어서 에러 안뜸
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

    public int insert(Manager manager) throws MandatoryValueDaoException, DuplicationDaoException { 
        //이렇게 예외를 throw한다고하면 dao에서도 선언해주어야함
                                                          //실무에서는 Throwable보다는 exception을 써주어야한다.
        //필수 입력 항목이 비었을 때,
        if(manager.getName().length() == 0 ||
           manager.getEmail().length() == 0 ||
           manager.getPassword().length() == 0) {
            
            // 예외처리 문법이 없던 시절에는 리턴 값으로 예외 상황을 호출자에게 알렸다.
            //return -1;
            // 호출자에게 예외 정보를 만들어 던진다.
            throw new MandatoryValueDaoException("필수 입력 항목이 비었음");
        }
        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                //같은 이메일의 매니저가 있을 경우,
                //=>예외처리 문법이 없던 시절에는 리턴 값으로 예외 상황을 호출자에게 알렸다.
                //return -2;
                
                // 호출자에게 예외 정보를 만들어 던진다.
                throw new DuplicationDaoException("같은 이메일이 이미 등록됫엄");
            }
        }
        list.add(manager);
        save();
        return 1; 
    }
    public List<Manager> findAll() {
        return list;
    }
    public Manager findByEmail(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    public int delete(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }

}
