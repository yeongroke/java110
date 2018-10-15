package ex03;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ex03.Member;

public class MemberDao {

    // Mybatis 객체를 사용하기 위해 주입받는다.
    SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Member member) {
        // Mybatis는 autoCommit 기본 값이  false이다.
        // 즉 commit을 해주어야함.
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            int count = sqlSession.insert("memberdao.insert",member);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }

    public int delete(int no) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        try {
            int count = sqlSession.insert("memberdao.delete",no);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }

    public List<Member> findAll() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            return sqlSession.selectList("memberdao.findAll");
        } finally {
            sqlSession.close();
        }
    }
    
    public Member findByNo(int no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            return sqlSession.selectOne("memberdao.findByNo",no);
        } finally {
            sqlSession.close();
        }
    }
}




