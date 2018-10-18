// 커스텀 프로퍼티 에디터를 정의하고 설정하는 방법
// => 스프링 IoC 컨테이너는 객체를 만들기 위해 생성자를 호출할 때
//    또는 프로퍼티 값을 설정하기 위해 setter를 호출할 때
//    XML 설정 파일에 지정된 문자열을 생성자의 파라미터 타입에 맞게
//    자동으로 형변환하여 전달한다.
//    단 primitive 타입으로만 자동 형변환 한다.
//    예) String ==> byte/short/int/long/float/double/boolean/char
//
// => 그 외 타입에 대해 형변환 하려면 별도의 변환기를 장착해야 한다.
//    그 별도의 값 변환기를 "커스텀 프로퍼티 에디터(custom property editor)"라 부른다.
//
// 커스텀 프포퍼티 에디터 만들기
// => java.beans.PropertyEditor 인터페이스를 구현한다.
//    - 구현할 메서드가 너무 많기 때문에 보통 이 인터페이스를 직접 구현하기 보다는
//      이 인터페이스를 미리 구현한 클래스(PropertyEditorSupport)를 상속 받아 만든다.
// => java.beans.PropertyEditorSupport 클래스를 상속 받는다.
//    - 이 클래스를 상속 받아서 setAsText(String) 메서드를 오버라이딩 한다.
//    - setAsText() 메서드는 파라미터 값으로 String을 받아서
//      변환하고자 하는 타입의 객체를 만드는 일을 한다.
//
// 커스텀 에디터를 스프링 IoC컨테이너 언제 사용해야 하는지 설정한다.
//
package ex07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new ClassPathXmlApplicationContext("ex07/app-context-1.xml");
        
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
        
        /*Car c1 = (Car)iocContainer.getBean("c1");
        System.out.println(c1);*/
        
        Car c2 = (Car)iocContainer.getBean("c2");
        System.out.println(c2);
    }
}
