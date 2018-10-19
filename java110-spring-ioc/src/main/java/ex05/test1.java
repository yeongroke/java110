package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
    public static void main(String[] args) {
        
        ApplicationContext iocContatiner = new ClassPathXmlApplicationContext("ex05/app-context-1.xml");
        
        Car c1 = (Car)iocContatiner.getBean("c1");
        System.out.println(c1);
    }
}
