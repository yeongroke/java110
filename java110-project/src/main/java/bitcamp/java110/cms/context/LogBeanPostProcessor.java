package bitcamp.java110.cms.context;

import java.util.Collection;
import annotation.Component;

@Component
public class LogBeanPostProcessor implements BeanPostProcessor{

    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {
        //objpool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objpool.values();

        //목록에서 객체를 꺼내 @Autowired가 붙은 메서드를 찾는다.
        System.out.println("-----------------------");
        for(Object obj : objList) {
            System.out.println(obj.getClass().getName());
        }
        System.out.println("-----------------------");
    }
}
