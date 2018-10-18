// 객체 생성 : 생존 전략
// 1) singleton (기본)
//      => IoC 컨테이너가 생성된 후 즉시 설정 파일에 등록된 객체를 생성한다.
//      => 한 개만 생성
// 2) prototype
//      => IoC 컨테이너가 생성된 후 자동으로 생성되지 않는다.
//      => getBean()을 호출할 때 마다 생성된다.
//      => 매번 다른 인스턴스를 생성할 필요가 있을 때 이 옵션을 사용하라!
//
package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex03/app-context-4.xml");
        
        System.out.println("0o0o0o0o0o0o0o0o0o0o0o0o0o0o0");
        
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
            System.out.println("0o0o0o0o0o0o0o0o0o0o0o0o0o0o0");
            
            // scope을 생략하면 기본이 singleton 이다.
            // 즉 객체를 한 개만 생성한다.
            Car c1 = (Car)iocContainer.getBean("n1");
            System.out.println(c1);
            
            Car c2 = (Car)iocContainer.getBean("n1");
            System.out.println(c2);
            
            if(c1 == c2) System.out.println("c1 == c2");
            
            System.out.println("0o0o0o0o0o0o0o0o0o0o0o0o0o0o0");
            
            Car c3 = (Car)iocContainer.getBean("n2");
            System.out.println(c3);
            
            Car c4 = (Car)iocContainer.getBean("n2");
            System.out.println(c4);
            
            if(c3 == c4) System.out.println("c3 == c4");
            
            System.out.println("0o0o0o0o0o0o0o0o0o0o0o0o0o0o0");
            
            // scope이 prototype이라면, 객체를 꺼낼 때 마다 즉시 생성하여 리턴한다.
            Car c5 = (Car)iocContainer.getBean("n3");
            System.out.println(c5);
            
            Car c6 = (Car)iocContainer.getBean("n3");
            System.out.println(c6);
            
            if(c5 == c6) System.out.println("c5 == c6");
            else System.out.println("c5 != c6");
            System.out.println("0o0o0o0o0o0o0o0o0o0o0o0o0o0o0");
    }
}
