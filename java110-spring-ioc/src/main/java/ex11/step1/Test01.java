// 메서드  호출 앞 또는 뒤에  코드 붙이기 : 직접 코드 삽입
//
package ex11.step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ex11.step1.AppConfig;

public class Test01 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new AnnotationConfigApplicationContext(AppConfig.class);
        
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
        
        // 만약 X 클래스의 m() 메서드 호출 앞/뒤로 뭔가 다른 일을 수행하고 싶다면?
        // => test() 메서드에 해당 코드를 직접 삽입해야 한다.
        
        Service caller = (Service)iocContainer.getBean(Service.class);
        caller.add();

        // => 이렇게 특정 메서드가 호출되기 전에 추가할 일이 있어 직접 코드를 등록하면,
        //    나중에 이 코드가 필요없을 때 다시 제거해야 하는 문제가 있다.
        // => 한 두 개의 클래스라면 직접 추가한 것을 직접 제거하는 것은 문제가 아니다.
        // => 그러나 추가해야할 대상이 많다면 추가하는데도 번거롭고,
        //    제거할 때도 매우 번거롭다.
    }
}
