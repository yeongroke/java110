// 메서드  호출 앞 또는 뒤에  코드 붙이기 : 직접 코드 삽입이 가능한 경우
package ex11.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ex11.step2.AppConfig;

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
        // 1) 기존 클래스는 손대지 말아야 하는 경우,
        //    즉 이미 다른 프로젝트에서 기존 클래스를 사용하고 있을 때!!
        // 2) 기존 클래스의 소스 코드가 없어서 손댈 수 없는 상황이라면?
        //    즉 직접 만든 클래스가 아니라 외부 라이브러리에 들어 있는 클래스를 사용할 때!!
        // => 프록시 패턴을 적용한다.
        // => 즉 기존 클래스와 똑같은 규칙으로 클래스를 만든다.
        //    그리고 그 클래스를 기존 클래스처럼 사용한다.
        //    이 클래스를 "프록시(proxy)"라고 부른다.
        // => 프록시 클래스를 정의했으면 기존 클래스를 사용하는 대신에
        //    프록시 객체를 만들어 사요한다.
        //    다만 프록시를 호출하면 프록시는 기본 클래스의 메서드를 호출하는 방식으로
        //    동작한다.
        
        // IoC 컨테이너가 리턴하는 것은 ServiceProxy 객체이다.
        Service caller = (Service)iocContainer.getBean(Service.class);
        caller.add();

        // 이 방법의 문제점!
        // => 개발자가 직접 Proxy 클래스를 정의해야 한다.
        // => 만약 오버라이딩 할 메서드가 수십 개일 경우 
        //    proxy 클래스를 만들 때 그 메서드를 모두 오버라이딩 해야 하는 부담이 있다.
        // 해결책!
        // => 자바에서 제공하는 proxy 자동 생성기를 이용한다!
        
        // => 이렇게 특정 메서드가 호출되기 전에 추가할 일이 있어 직접 코드를 등록하면,
        //    나중에 이 코드가 필요없을 때 다시 제거해야 하는 문제가 있다.
        // => 한 두 개의 클래스라면 직접 추가한 것을 직접 제거하는 것은 문제가 아니다.
        // => 그러나 추가해야할 대상이 많다면 추가하는데도 번거롭고,
        //    제거할 때도 매우 번거롭다.
    }
}
