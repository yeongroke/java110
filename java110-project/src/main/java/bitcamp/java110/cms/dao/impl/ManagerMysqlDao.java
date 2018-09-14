package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

@Component
public class ManagerMysqlDao implements ManagerDao {

    DataSource dataSource;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Manager manager) {
        Statement stmt = null;

        Connection con = null;
        try {
            con = dataSource.getConnection();

            // 매니저 정보를 입력할 때 p1_memb 테이블과 p1_mgr 테이블에 
            // 매니저 정보를 분산 입력 해야 한다.
            // 두 테이블에 모두 입력 성공할 때 입력을 완료하도록 
            // 두 insert를 한 작업(transaction)으로 묶는다.
            // => SQL을 서버에 보낸 후 클라이언트가 최종 완료 신호를 
            //    보내기 전까지는 처리를 보류하도록 설정한다. 
            con.setAutoCommit(false);

            stmt = con.createStatement();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + manager.getName()
                    + "','" + manager.getEmail()
                    + "',password('" + manager.getPassword()
                    + "'),'" + manager.getTel()
                    + "',now())";

            // p1_memb 테이블에 회원 기본 정보를 입력 한 후 
            // 자동으로 생성된 회원 번호를 리턴 받는다.
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            // insert 를 실행한 후 리턴 받은 자동증가 PK 값을 꺼내기
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();

            // 회원 번호로 매니저 테이블에 직위 정보를 입력한다.
            String sql2 = "insert into p1_mgr(mrno,posi)"
                    + " values(" + memberNo
                    + ",'" + manager.getPosition()
                    + "')";
            stmt.executeUpdate(sql2);

            // 두 insert가 모두 성공했을 때만 서버에 완료 신호를 보낸다.
            con.commit();
            return 1;
        } catch (Exception e) {
            try{ con.rollback();} catch(Exception e2) {}
            //rollback을 써주는 이유는 에러가 떠도 자동으로 finally에서 
            //close을 해서 db랑 접속을 끊으면 정보가 다날라가기때문에 rollback을 써준느것이다.
            //rollback은 데이터 정보를 변경할 때만 쓴다. ex )update,delete,insert 등등
            throw new DaoException(e);

        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }

    public List<Manager> findAll() {

        ArrayList<Manager> list = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection con = dataSource.getConnection();
            //=> java.sql.Driver 구현체를 로딩한다.
            //=> 해당 클래스의 객체를 만들어 DriverManager에 등록한다.

            //=> DriverManager에게 java.sql.Connection 객체를 요구한다.
            //=> DriverManager는 등록된 Driver 들 중에서 요구 사항에 맞는
            //   드라이버를 찾아 connect()를 호출한다.
            //   그리고 connect() 메서드의 리턴 값을 그대로 리턴해 준다.

            //=> 질의문을 작성할 객체를 준비한다.
            stmt = con.createStatement();

            //=> select 질의를 한다.
            /*
             select
                 m.name,
                 m.email,
                 mr.posi
             from p1_mgr mr 
                 inner join p1_memb m on mr.mrno = m.mno  
             */
            rs = stmt.executeQuery(
                    "select" + 
                            " m.mno," +
                            " m.name," + 
                            " m.email," + 
                            " mr.posi" + 
                            " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno");

            // 서버에 생성된 질의 결과를 한 개씩 가져온다.
            while (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));

                list.add(mgr);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
        return list;
    }

    public Manager findByEmail(String email) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection con = dataSource.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                            " m.mno," +
                            " m.name," + 
                            " m.email," + 
                            " m.tel," + 
                            " mr.posi" + 
                            " from p1_mgr mr" + 
                            " inner join p1_memb m on mr.mrno = m.mno" +
                            " where m.email='" + email + "'");

            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));

                return mgr;
            }
            return null;

        } catch (Exception e) {
            throw new DaoException(e);

        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }

    public Manager findByNo(int no) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection con = dataSource.getConnection();

            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                            " m.mno," +
                            " m.name," + 
                            " m.email," + 
                            " m.tel," + 
                            " mr.posi" + 
                            " from p1_mgr mr" + 
                            " inner join p1_memb m on mr.mrno = m.mno" +
                            " where m.mno=" + no);

            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));

                return mgr;
            }
            return null;

        } catch (Exception e) {
            throw new DaoException(e);

        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }

    public int delete(int no) {
        Connection con = null;
        Statement stmt = null;

        try {
            con = dataSource.getConnection();

            con.setAutoCommit(false);
            stmt = con.createStatement();

            String sql = "delete from p1_mgr where mrno=" + no ;
            int count = stmt.executeUpdate(sql);

            if (count == 0)
                return 0;

            String sql2 = "delete from p1_memb where mno=" + no;
            stmt.executeUpdate(sql2);
            con.commit();

            return 1;

        } catch (Exception e) {
            try{ con.rollback();} catch(Exception e2) {}
            throw new DaoException(e);

        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }
}
