// 메서드  호출 앞 또는 뒤에  코드 붙이기 : 직접 코드 삽입이 가능한 경우
package ex11.step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer 
            = new AnnotationConfigApplicationContext(AppConfig.class);
        
        AppConfig.printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        proxy.add(); // proxy.add() --> MethodFilter.invoke() --> original.xxx()
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();

    }
}
