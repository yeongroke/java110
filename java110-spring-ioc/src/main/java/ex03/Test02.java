// 객체 생성 : 객체의 아이디어와 별명
// 1) 객체의 아이디 지정하기
//    - 오직 한 개의 아이디만 지정할 수 있다.
//    - 문법
//      <bean id="객체명" class="fully qualified name(클래스명)"/>
//
// 2) 객체의 별명 지정하기
//    - 한 개 이상의 이름을 지정할 수 있다.
//    - id를 지정하지 않으면 첫 번째 별명이 id로 사용된다.
//    - 콤마(,)/세미클론(;)/공백( ) 으로 별명을 구분한다.
//    - 문법
//          <bean name="별명1 별명2 별명3" class="fully qualified name(클래스명)"/>
//          <bean name="별명1,별명2,별명3" class="fully qualified name(클래스명)"/>
//          <bean name="별명1;별명2;별명3" class="fully qualified name(클래스명)"/>
//
// 3) 객체의 아이디나 별명을 지정하지 않기
//    - 클래스의 이름(패키지명 포함)이 객체의 이름으로 사용된다.
//          ex) ex03.Car#0
//    - 만약 그 타입의 첫 번재 익명 객체라면 클래스 이름(패키지명 포함) 이 별명으로 설정된다.
//          ex) ex03.Car
//    - 그 타입의  두 번재 익명 객체일 경우 별명이 붙지 않는다.
package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex03/app-context-2.xml");
        
        System.out.println("0o0o0o0o0o0o00o0o0oo0o0o0o0o0o0");
        
        // 컨테이너에 들어 있는 객체의 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n",count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.printf("=> [%s : %s]\n"
                    ,name,iocContainer.getType(name).getName());
            
            String[] aliases = iocContainer.getAliases(name);
            System.out.println("    별명들  :");
            for(String alias : aliases) {
                System.out.println("   =>" + alias);
            }
        }
    }
}
