// 의존 객체 자동 주입 : @Autowired 애노테이션 I
// => 의존 객체를 꼽을 setter에 이 애노테이션을 붙이면
//    스프링 IoC 컨테이너가 해당 객체를 만든 후
//    setter를 호출할 때 해당 객체를 찾아 자동으로 주입한다.
//
// => 단, 스프링 IoC 컨테이너는 기본으로 @Autowired를 처리하지 않는다.
//    @Autowired 애노테이션을 처리하려면
//    도우미 객체를 스프링 IoC 컨테이너에 장착해야 한다.
//    꼭 String을 java.sql.Date으로 바꾸기 위해 커스텀 프로퍼티 에디터를 장착하는 것 처럼!
//
// => @Autowired 애노테이션 처리기를 장착하는 방법
//    AutowiredAnnotationBeanPostProcessor 클래스의 객체를 등록하라!
//    그냥 등록만 하면 된다.
//    그러면 스프링 IoC 컨테이너가 알아서 이 객체를 사용하여 @Autowired를 처리한다.
//
// BeanPostProcessor?
// => 스프링 IoC 컨테이너는 객체를 생성한 후 각 객체에 대해 BeanPostProcessor 를 실행한다.
//    즉 BeanPostProcessor가 있으면 실행하고 없으면 실행하지 않는다.
// => AutowiredAnnotationBeanPostProcessor 클래스는
//    이 BeanPostProcessor를 구현한 클래스이다.
package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex08/app-context-1.xml");
        
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
        
    }
}
