package bitcamp.java110.cms.dao.impi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerJdbcDao implements ManagerDao{
    private List<Manager> list = new ArrayList<>();

    public int insert(Manager manager) {
        return 0;
    }
    public List<Manager> findAll() {
        
        ArrayList<Manager> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //=>java.sql.Driver 구현체를 로딩한다.
            //=>해당 클래스의 객체를 만들어 DriverManager에 등록한다.
            Class.forName("org.mariadb.jdbc.Driver");
            //=>DriverManager에게 java.sql.Connection 객체를 요구한다.
            //=>DriverManager는 등록된 Driver들 중에서 요구 사항에 맞는
            //  드라이버를 찾아 connect()를 호출한다.
            //  그리고 connect() 메서드의 리턴 값을 그대로 리턴해주 준다.
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
            
            //DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            //class에서 등록이 되었기때문에 그냥 class.forname만 쳐도된다.
            
            //=>질의 문을 작성할 객체를 준비한다.
            stmt = con.createStatement();
            //=>select 질의를 한다.
            /*select m.name,m.email,mr.posi
            from p1_mgr mr inner join p1_memb m 
            on mr.mrno = m.mno*/ //right outer join 은 현재 쿼리문에서는 memb에서 더확장해서 출력되는것
            rs = stmt.executeQuery("select m.name,m.email,mr.posi\r\n" + 
                    " from p1_mgr mr inner join p1_memb m \r\n" + 
                    " on mr.mrno = m.mno");
            // resultset의 역할 : 서버에 생성된 질의 결과를 한개씩 가져온다
            while(rs.next()) {
                Manager mgr = new Manager();
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));
                
                list.add(mgr);
            }
        }catch(Exception e) {
            throw new DaoException();
        }finally {
            try { rs.close();} catch (Exception e) {}
            try { stmt.close();} catch (Exception e) {}
            try { con.close();} catch (Exception e) {}
        }
        return list;
    }
    public Manager findByEmail(String email) {
        return null;
    }
    public int delete(String email) {
        return 0;
    }

}
