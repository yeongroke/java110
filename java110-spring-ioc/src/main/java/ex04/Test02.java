// 생성자 호출 : <constructor-arg> 사용법
//
// XML 문법  : 두가지 방법이 있다
//       1) <constructor-arg value="부가티"/>
//          <constructor-arg value="4000"/>
//
//       2) <constructor-arg><value>부가티</value></constructor-arg>
//          <constructor-arg><value>4000</value></constructor-arg>
//          
package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex04/app-context-2.xml");
        
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
    }
}
