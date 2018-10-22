package mytest01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    public static void main(String[] args) {
        
        
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext("mytest01/app-context.xml");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 갯수: %d\n",count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
        System.out.printf("이름 : %s , %s\n",name,iocContainer.getType(name));
        }
        
        Store s1 = (Store)iocContainer.getBean("s1");
        System.out.println(s1);
        System.out.println("-------------");
        /*Comp c1 = (Comp)iocContainer.getBean("c1");
        System.out.println(c1);*/
        
        Store s2 = (Store)iocContainer.getBean("s2");
        System.out.println(s2);
        System.out.println("-------------");
        
        Store s3 = (Store)iocContainer.getBean("s3");
        System.out.println(s3);
        System.out.println("-------------");
        
        Store s4 = (Store)iocContainer.getBean("s4");
        System.out.println(s4);
        System.out.println("-------------");
        
        Store s5 = (Store)iocContainer.getBean("s5");
        System.out.println(s5);
        System.out.println("-------------");
        
        Comp c2 = (Comp)iocContainer.getBean("c2");
        System.out.println(c2);
        System.out.println("-------------");
    }
}
