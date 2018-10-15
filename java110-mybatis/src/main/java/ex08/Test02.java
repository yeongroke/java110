// fk 컬럼으로 지정된 값 가져오기 - 첨부 파일 가져오기 I
package ex08;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

    public static void main(String[] args) throws Exception{
        String resource = "ex08/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        Board board = boardDao.findByNo(1);
        System.out.printf("번호 : %d \n",board.getNo());
        System.out.printf("제목 : %s \n",board.getTitle());
        System.out.printf("내용 : %s \n",board.getContent());
        System.out.printf("조회수 : %d \n",board.getViewCount());
        System.out.printf("등록일 : %s \n",board.getCreateDate());
        
        // 게시물 상세조회할 때 작성자의 정보처럼
        // 조인한 테이블의 다 수 데이터를 가져와야 할 경우,
        // Board 객체에 담지 말고 별도로 Member 객체를 만들어 담는 것이
        // 유지보수에 좋다.
        // => 물론 개발자가 Member 객체를 만드는 것이 아니라,
        //    Mybatis가 Member 객체를 만들어 작성자 정보를 저장해 줄 것 이다.
        // => 방법은?
        //    BoardDao-01.xml 파일을 보라!
        
        Member m = board.getMember();
        System.out.printf("작성자 이름: %s \n",m.getName());
        System.out.printf("작성자 이메일: %s \n",m.getEmail());
        System.out.printf("작성자 전화: %s \n",m.getTel());
        
        // 첨부 파일을 가져올 때 Mybatis는 첨부파일 목록까지 준비해둔다.
        // 단지 꺼내 쓰기만 하면 된다.
        // 즉 게시물을 select할 때 첨부파일 데이터까지 묶어서 처리하낟.
        List<AttachFile> files = board.getAttachFiles();
        System.out.println("첨부파일 : ");
        for(AttachFile f : files) {
            System.out.printf("- %s(%d)\n",f.getFilename(),f.getNo());
        }
    }
}
