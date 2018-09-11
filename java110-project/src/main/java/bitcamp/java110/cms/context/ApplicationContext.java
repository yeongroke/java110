package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import annotation.Component;
public class ApplicationContext {
    HashMap<String, Object> objpool = new HashMap<>();
    List<Class<?>> classes = new ArrayList<>();

    public ApplicationContext(String packageName) throws Exception{
        //패키지 이름을 파일 경로로 바꾼다
        String path=packageName.replace(".", "/");

        //패키지 경로를 가지고 전체 파일 경로를 알아낸다.
        //현재 자바 classpath에서 정보를 찾음
        File file=Resources.getResourceAsFile(path);
        //System.out.println(file.getAbsolutePath());

        //패키지 폴더에 들어 있는 클래스를 찾아 클래스를 로딩한 후 그 목록에 저장한다.
        findClass(file,path);
        //1) 인스턴스 생성
        //로딩된 클래스 목록을 뒤져서 @Component 가  붙은
        //클래스에 대해 인스턴슬르 생성하여 objpool에 보관한다.
        createInstance();

        //injectDependency() 메서드를 외부 클래스로 분리한 다음에
        //그 객체를 실행한다.

        //객체 생성 후에 실행할 작업이 있다면,
        //BeanPostProcessor 구현체를 찾아 실행한다.
        //이름이 달라고 BeanPostProcessor이걸 찾아서 실행한다
        // 이게 인터페이스랑 annotation이 필요한 이유이다.
        callBeanPostProcessor();

        // 객체 생성 후 작업을 수행하는 클래스가 있다면 찾아서 호출한다.
        //callBeanPostProcessor();
    }
    //objpool에서 주어진 객체를 이름으로 찾아서 리턴한다.
    public Object getBean(String name) {
        // objpool에서 주어진 이름의 객체를 찾아 리턴한다.
        return objpool.get(name);
    }

    //객체의 타입으로 objpool에 보관된 객체를 찾아 리턴한다.
    public Object getBean(Class<?> type) {
        Collection<Object> objList = objpool.values();
        for(Object obj : objList) {
            if(type.isInstance(obj))
                return obj;
        }
        return null; //타입을 못찾으면  null을 리턴 
    }

    public String[] getBeanDefinitionNames() {
        Set<String> keySet = objpool.keySet();
        String [] names = new String[keySet.size()];
        keySet.toArray(names);

        return names;
    }

    private void findClass(File path, String packagePath) {
        //System.out.println(packagePath); //디렉토리 출력
        File[] files = path.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                findClass(file,packagePath + "/" + file.getName()); //파일이름만 출력
            }else {
                String className =(packagePath + "/" + file.getName())
                        .replace("/", ".")
                        .replace(".class", "");
                try {
                    //1) 클래스 이름을 가지고 .calss 파일을 찾아 메모리에 로딩한다.
                    Class<?> clazz = Class.forName(className); 

                    classes.add(clazz);//로딩한 클래스 정보를 목록에 보관한다.
                }catch(Exception e) { }
            }
        }
    }
    private void createInstance() {
        for(Class<?> clazz : classes) {
            //=> 인터페이스인 경우 무시한다.
            if(clazz.isInterface()) continue;
            // className을 못찾으면 에러가 뜨기때문에 위에 throws exception을 선언한다
            // 여기서 ?는 아무거나? 괜찮다 이런 뜼이다.
            //클래스에서 component 애노테이션을 추출한다.
            Component anno = clazz.getAnnotation(Component.class);

            if(anno ==null) continue;
            //=> @Component애노테이션이 붙지 않는 클래스는 객체를 생성하지 않는다.
            try {

                //2) 로딩된 클래스 정보를 가지고 인스턴스를 생성한다.
                // =>먼저 해당 클래스의 생성자 정보를 얻는다.
                Constructor<?> constructor=clazz.getConstructor();
                //getconstructors 는 모든 클라스를 가져오기때문에 s가 안들어간거를 써주어야한다.
                //=> 생성자를 가지고 인스턴스를 생성한다.
                Object instance =constructor.newInstance();

                //class는 확장자가 아니고 변수명이다 ,class정보를 가지고 있는 객체를 가르킨다. 이변수명의 타입도 Class이다
                //System.out.println(instance.getClass());
                //clazz.newInstance();// 이거는 버전 8까지만 사용가능하다

                //=> 이름으로 인스턴스의 필드를 찾는다
                //Field field = clazz.getField("name");
                //=> "name" 필드의 값을 꺼낸다.
                //Object name = field.get(instance);

                //System.out.println(clazz.getName() + "==>" + name);
                //=> "name" 필드의 값으로 인스턴스를 objpool에 저장한다.
                //=> component 애노테이션이 value 값이 있으면 그 값으로 객체를 저장
                //   없으면, 클래스 이름으로 객체를 저장한다.
                if(anno.value().length()>0) {
                    // component 애노테이션 value값으로 인스턴스를 objpool에 저장
                    objpool.put(anno.value(), instance);
                } else {
                    objpool.put(clazz.getName(), instance);
                }
                //String인데 오류가 넣어서 string을 넣어서 강제 형변환을해줌 하지만 name이 String이 아니면 강제 형변환 하면안됨
            }catch(Exception e) {
                System.out.printf("%s 클래스는 기본 생성자가 없습니다.",clazz.getName());
            }
        }
    }
    private void callBeanPostProcessor() {
        Collection<Object> objList = objpool.values();

        //=> objpool에 보관된 객체 중에서 BeanPostProcessor 규칙을
        //   준수하는 객체를 찾는다.
        for(Object obj : objList) {
            if(!BeanPostProcessor.class.isInstance(obj)) continue;

            BeanPostProcessor processor = (BeanPostProcessor)obj;
            processor.postProcess(this);//이렇게 여러군데에서 참조를 하면 위험하다.

        }
    }
    /*private void postProcessPorObject(BeanPostProcessor processor) {

        Set<String> keySet = objpool.keySet();
        for(String key : keySet) {
            processor.postProcess((objpool.get(key)), key);
        }
    }*/
}
