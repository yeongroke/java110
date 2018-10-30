// AOP : Java config로 AOP 설정하기
package ex11.step8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {

    public static void main(String[] args) {

        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        int r = proxy.addPhoto("ok.jpeg");
        System.out.println("리턴 값: "+ r);
        
        System.out.println("------------------------------------------");
        r = proxy.addPhoto(null);
        System.out.println("리턴 값: "+ r);

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
