package mytest01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test02 {
    public static void main(String[] args) {
        
        
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext("mytest01/app-context2.xml");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 갯수: %d\n",count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
        System.out.printf("이름 : %s , %s\n",name,iocContainer.getType(name));
        }
        
        Store s1 = (Store)iocContainer.getBean("s1");
        System.out.println(s1);
        System.out.println("-------------");
    }
}
