package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import annotation.Autowired;
import annotation.Component;

@Component
public class AutowiredAnnotationBeanPostProcessor implements BeanPostProcessor{

    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {
        //objpool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objpool.values();

        //목록에서 객체를 꺼내 @Autowired가 붙은 메서드를 찾는다.
        for(Object obj : objList) {
            Method[] methods = obj.getClass().getDeclaredMethods();

            for(Method m : methods) {
                if(!m.isAnnotationPresent(Autowired.class)) continue;
                //m에 annotation이 없다면 게속 진행하라

                //setter 메서드의 파라미터 타입을 알아낸다.
                Class<?> paramType = m.getParameterTypes()[0]; //배열을 리턴한다

                //그 파라미터 타입과 일치하는 객체가 objpool에서 꺼낸다.
                Object dependency = beanContainer.getBean(paramType);

                if(dependency == null) continue;

                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() 호출됨 !\n",m.getName());
                }catch(Exception e) { }
            }
        }
    }
}
