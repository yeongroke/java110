// 의존 객체 자동 주입 : @Autowired의 위치
// => setter나 field에 붙이면 된다.
// => field에 붙일 대는 setter가 없어도 된다.
// => private 필드에 대해서도 값을 주입할 수 있다.
//    - private 은 외부의 접근을 막는 기능을 하고 있는데,
//      스프링 IoC 컨테이너에서 private 접근을 막는 것을 우회하여
//      값을 넣기 때문에 객체지향이 깨뜨린다는 논란이 있다.
package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex08/app-context-3.xml");
        
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
        
        Car2 c1 = (Car2)iocContainer.getBean("c1");
        System.out.println(c1);
        
    }
}
