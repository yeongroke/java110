// setter 호출 :
//
// XML 문법
//      <bean id="객체명" class="fully qualified name(클래스명)">
//          <property name="프로퍼티명" value=""/>
//      </bean>
package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex05/app-context-1.xml");
        
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
        
        Car c1 = (Car)iocContainer.getBean("c1");
        System.out.println(c1);
        Car c2 = (Car)iocContainer.getBean("c2");
        System.out.println(c2);
        Car c3 = (Car)iocContainer.getBean("c3");
        System.out.println(c3);
        Car c4 = (Car)iocContainer.getBean("c4");
        System.out.println(c4);
        Car c5 = (Car)iocContainer.getBean("c5");
        System.out.println(c5);
    }
}
