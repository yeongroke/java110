package bitcamp.java110.cms;
import java.lang.reflect.Method;
import java.util.Scanner;

import annotation.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        ApplicationContext iocContainer = new ApplicationContext("bitcamp.java110.cms");

        //=> 저장소에 보관된 객체 중에서 

        //bitcamp.java110.cms.control여기있는 클래스만 찾아서 만들어 달라는 선언
        //그러면 알아서 저 control에 있는 클라스,패키지를 찾아서 간다

        RequestMappingHandlerMapping requestHandlerMap = new RequestMappingHandlerMapping();

        //=> IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            //=> 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);

            //=> 객체에서 @RequestMapping이 붙은 메서드를 찾아 저장하라고 명령
            requestHandlerMap.addMapping(obj);
        }
        while (true) {
            String menu = prompt();

            if (menu.equals("exit")){
                System.out.println("안녕히 가세요!");
                break;
            }
            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            if(mapping ==null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            /*Method method = mapping.getMethod();

            method.invoke(mapping.getInstance(), keyIn);*/
            try {
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
            //이렇게 쓰는게 더 효율적
            }catch(Exception e) {
                System.out.println("실행 오류");
                System.out.println(e.getCause());
                //e.getCause은 이유를 발생한이유 출력,file2dao참고
            }
        }

        keyIn.close();
    }

    private static Method findRequestMapping(Class<?> clazz) {

        //=> 클래스의 메 서드 목록을 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods();

        for(Method m : methods) {
            //=> 메서드에서 @RequestMapping 정보를 추출한다.
            RequestMapping anno = m.getAnnotation(RequestMapping.class);

            if(anno != null) //찾았다면 이 메서드를 리턴한다.
                return m;
        }

        return null;
    }

    private static String prompt() {
        System.out.print("메뉴 > ");
        return keyIn.nextLine();


        /*while (true) {
            System.out.print("메뉴 번호> ");

            String menu = keyIn.nextLine();

            switch (menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("메뉴 번호가 유효하지 않습니다.");
            }
        }*/
    }
}