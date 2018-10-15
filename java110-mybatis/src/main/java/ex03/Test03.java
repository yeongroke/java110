// 주제 : factory method 및 builder 디자인 패턴 적용
package ex03;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {

    // 객체를 생성해주는 메서드
    // "=> Factory Method" 설계 패턴이다.
    // => 객체 생성 과정이 복잡하거나 번거로울 경우 주로 사용한다.
    //
    public static void main(String[] args) throws Exception{
        // 1) mybatis 설정 파일 경로
        String resource = "ex03/mybatis-config.xml";
        // 2) 설정 파일을 읽을 inputstream 준비
        //    => 자바 classpath에서 설정 파일을 찾는다.
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        // 3) SqlSession 객체를 생성해 줄 팩토리 객체를 준비
        //    => mybatis 설정 파일에 정의된 대로 객체를 준비한다.
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        MemberDao memberDao = new MemberDao();
        // 4) mybatis 객체를 MemberDao에게 넘겨준다.
        memberDao.setSqlSessionFactory(sqlSessionFactory);

        Scanner sc = new Scanner(System.in);
        
        System.out.println("머지울거?");
        int no=sc.nextInt();
        memberDao.delete(no);
    }
}
