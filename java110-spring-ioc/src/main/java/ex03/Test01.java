// 객체 생성 : XML에 객체 생성을 설정하는 방법과 컨테이너에 보관된 객체 확인하기
// XML 문법
//      <bean id="객체명" class="fully qualified name(클래스명)"/>
//    - 객체명 : 컨테이너에 객체를 보관할 때 사용할 이름
//    - 클래스명 : 패키지명을 포함한  클래스이름(fully qualified name; FQName; QName) 이라고 부른다
//    - 
package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex03/app-context-1.xml");
        
        System.out.println("0o0o0o0o0o0o00o0o0oo0o0o0o0o0o0");
        
        // 컨테이너에 들어 있는 객체의 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n",count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.printf("=> %s : %s\n"
                    ,name,iocContainer.getType(name).getName());
        }
    }
}
