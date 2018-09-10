package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

import annotation.Component;
public class ApplicationContext {
    HashMap<String, Object> objpool = new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception{
        //패키지 이름을 파일 경로로 바꾼다
        String path=packageName.replace(".", "/");
        
        //패키지 경로를 가지고 전체 파일 경로를 알아낸다.
        //현재 자바 classpath에서 정보를 찾음
        File file=Resources.getResourceAsFile(path);
        //System.out.println(file.getAbsolutePath());
        
        //패키지 폴더에 들어 있는 파일 목록을 알아낸다.
        findClass(file,path);
        //1) 인스턴스 생성
        //해당 패키지에 있는 클래스를 찾아서 인스턴스를 생성한 후에 objpool에 보관한다.
    }
    //objpool에서 주어진 객체를 이름으로 찾아서 리턴한다.
    public Object getBean(String name) {
        // objpool에서 주어진 이름의 객체를 찾아 리턴한다.
        return objpool.get(name);
    }
    private void findClass(File path, String packagePath) throws Exception{
        //System.out.println(packagePath); //디렉토리 출력
        File[] files = path.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                findClass(file,packagePath + "/" + file.getName()); //파일이름만 출력
            }else {
            String className =(packagePath + "/" + file.getName())
                    .replace("/", ".")
                    .replace(".class", "");
            //1) 클래스 이름을 가지고 .calss 파일을 찾아 메모리에 로딩한다.
            Class<?> clazz = Class.forName(className); 
            //=> 인터페이스인 경우 무시한다.
            if(clazz.isInterface()) continue;
            // className을 못찾으면 에러가 뜨기때문에 위에 throws exception을 선언한다
            // 여기서 ?는 아무거나? 괜찮다 이런 뜼이다.
            try {
            //2) 로딩된 클래스 정보를 가지고 인스턴스를 생성한다.
            // =>먼저 해당 클래스의 생성자 정보를 얻는다.
            Constructor<?> constructor=clazz.getConstructor();
            //getconstructors 는 모든 클라스를 가져오기때문에 s가 안들어간거를 써주어야한다.
            //=> 생성자를 가지고 인스턴스를 생성한다.
            Object instance =constructor.newInstance();
            
            //클래스에서 component 애노테이션을 추출한다.
            Component anno = clazz.getAnnotation(Component.class);
            //class는 확장자가 아니고 변수명이다 ,class정보를 가지고 있는 객체를 가르킨다. 이변수명의 타입도 Class이다
            //System.out.println(instance.getClass());
            //clazz.newInstance();// 이거는 버전 8까지만 사용가능하다
            
            //=> 이름으로 인스턴스의 필드를 찾는다
            //Field field = clazz.getField("name");
            //=> "name" 필드의 값을 꺼낸다.
            //Object name = field.get(instance);
            
            //System.out.println(clazz.getName() + "==>" + name);
            //=> "name" 필드의 값으로 인스턴스를 objpool에 저장한다.
            
            // component 애노테이션 value값으로 인스턴스를 objpool에 저장
            objpool.put(anno.value(), instance); 
            //String인데 오류가 넣어서 string을 넣어서 강제 형변환을해줌 하지만 name이 String이 아니면 강제 형변환 하면안됨
            }catch(Exception e) {
                System.out.printf("%s 클래스는 기본 생성자가 없습니다.",clazz.getName());
            }
            }
        }
    }
    /*public static void main(String[] args) {
        int sum = sigma(3);
        System.out.println(sum);
    }
    public static int sigma(int a) { 
        //코드는 간단하지만 메소드를 계속 호출 하기때문에 속도가 느리다 
        //코드나 메소드가 깊어지면(너무많이 호출을 하면) 스택 오버플로우오류가 뜬다.
        //스택 메모리는 정해져있기 때문에 그걸 넘어가면 오류가 뜨는거다
        if(a==0)
            return 0;
        return a + sigma(a - 1); 
        //a가 0이 아닐대 계속 리턴값에서 sigma를 호출한다.
        //계속 호출을 하면서 새로운 프레임들이 만들어진다.
        //호출을하고 stack메모리가 생성이되지만 리턴을 하면서 다시사라진다
    }*/
}
