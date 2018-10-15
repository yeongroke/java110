// fk 컬럼으로 지정된 값 가져오기 - join을 실행하여 가져오기
package ex06;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

    public static void main(String[] args) throws Exception{
        String resource = "ex06/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("rowNo", 0);
        params.put("pageSize", 5);
        
        List<Board> boards = boardDao.findAll(params);
        for(Board b : boards) {
            // p1_board 테이블과 p1_memb 테이블을 조인했기 때문에
            // 작성자 정보를 가져오기 위해 추가적인 select가 필요하다.
            // 주목!
            // => 조인하여 추가된 컬럼 값을 받기 위해
            //    Board 클래스에 필드를 추가하였다.
            System.out.printf("%d, %s, %d, %s, %s \n",
                    b.getNo()
                    , b.getTitle()
                    , b.getViewCount()
                    , b.getWriter()
                    , b.getCreateDate());
        }
        
        // 게시물 상세조회 같이 한 개의 데이터를 가져올 때는
        // 다음과 같이 작성자의 정보를 가져오기 위해
        // 별도로 select를 실행해도 된다.
        // 그러나 게시물 목록조회에서 작성자의 이름을 출력하기 위해
        // 이와 같이 각 게시물에 대해 매번 select를 실행한다면
        // 그것은 DBMS에 오버헤드가 발생시켜 성능을 저하시키는 원인이 된다.
        // 해결책? 
        // => join을 이용하라 !
    }
}
