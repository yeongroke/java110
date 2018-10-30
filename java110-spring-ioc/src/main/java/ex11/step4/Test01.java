// AOP : 메서드  호출 앞/뒤에 필터 끼우는 기술
package ex11.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    // AOP 용어
    // AOP(Aspect-Oriented Programming)?
    // - 기존의 코드를 손대지 않고 특정 기능을 삽입하는 기술
    // - 메서드 호출 앞/뒤/값리턴뒤 에 코드를 삽입할 수 있다.
    // - 일종의 필터를 추가하는 기술이다.
    //
    // AOP 적용 방법
    // - AOP 관련 라이브러리를 추가한다.
    //   - "aspectj weaver" 로 검색한다.
    // - 필터 역할을 할 클래스를 정의한다.
    // - XML 또는 Java Config로 필터를 설정한다.
    //
    // AOP 용어
    // - Advice     : 필터링 대상이 되는 메서드(join point)의 호출 앞/뒤에 삽입하는 필터 객체이다.
    //      - ex) MyAdvice
    // - Join point : Advice가 삽입될 메서드이다.
    //      - ex) insert()/update()/delete() 등의 메서드
    // - PointCut   : Advice를 삽입해야 하는 메서드에 대한 위치 정보이다.
    //      - ex) execute("* ex11.step4.Service.*(..)")
    // - Target Object : Advice를 삽입해야 하는 메서드를 갖고 있는 클래스이다.
    //      - ex) ServiceImpl, ManagerDao 등
    // - Aspect     : 어느 pointcut에 어떤 advice를 삽입할 것인지를 가리키는 정보이다.
    //      - ex) 설정 정보
    
    public static void main(String[] args) {

        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step4/app-context-1.xml");

        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        proxy.add(); // proxy.add() --> MethodFilter.invoke() --> original.xxx()
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();

    }
    public static void printObjectList(ApplicationContext iocContainer) {

        System.out.println("------------------------------------------");

        // 컨테이너에 들어 있는 객체의 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n",count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.printf("=> %s : %s\n"
                    ,name,iocContainer.getType(name).getName());
        }
        System.out.println("------------------------------------------");
    }
}
