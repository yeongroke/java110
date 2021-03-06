// setter 호출 : Set 프로퍼티 값 설정
//
// XML 문법
// 방법1)
//      <property name="프로퍼티명">
//          <list>...</list>
//      </property>
// 방법2)
//      <property name="프로퍼티명" value="">
//          <array>...</array>
//      </property>
package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex05/app-context-3.xml");
        
        System.out.println("0o0o0o0o0o0o00o0o0oo0o0o0o0o0o0");
        
        // 컨테이너에 들어 있는 객체의 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n",count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.printf("=> %s : %s\n"
                    ,name,iocContainer.getType(name).getName());
        }
        System.out.println("0o0o0o0o0o0o00o0o0oo0o0o0o0o0o0");
        
        CD cd1 = (CD)iocContainer.getBean("cd1");
        System.out.println(cd1);
        
        CD cd2 = (CD)iocContainer.getBean("cd2");
        System.out.println(cd2);
    }
}
