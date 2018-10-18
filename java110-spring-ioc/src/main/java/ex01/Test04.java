// 객체 생성하기 : factory method 패턴 적용
package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
    
    public static void main(String[] args) {
        
        // 객체의 생성, 소멸과 의존객체 주입을 관리하는 
        // bean container(=IoC 컨테이너) 생성하기
        ClassPathXmlApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex01/app-context.xml");
        
        // ioc 컨테이너에서 객체 꺼내기
        Car c1 = (Car)iocContainer.getBean("c1");
        
        System.out.println(c1);
        
        iocContainer.close();
    }
}
