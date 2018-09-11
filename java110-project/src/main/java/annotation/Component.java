package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* 애노테이션 유지 정책
 * CLASS : 컴파일 한 후 에도 .class 파일에 남겨둔다. 단, 실행할 때는 참조할 수 없다.
 *         Reflection API로 클래스 파일에서 애노테이션 정보를 추출 할 수 없다.
 *         애노테이션 유지 정책을 지정하지 않으면 class가 기본 값이다.
 * SOURCE : 컴파일 할 때 제거된다. 즉 , class 파일에 남겨 두지 않는다.
 * RUNTIME : 컴파일 한 후 에도 .class 파일에 남겨 둔다. 실할할 때도 참조할 수 있다.
 *           Reflection API로 클래스에서 애노테이션 정보를 추출할 수 있다.
 * */

@Target(ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME) //컴파일 한 후 .class 파일에 남겨 둔다. 위에 설명
           //value=RetentionPolicy.CLASS 이거인경우 value을 생략 가능 하지만 value가 두개거나 value2인 경우는 안됨
public @interface Component{
    String value() default "";
    //String value(); 은 property 이다 , 일반 메서드는 동사이지만 property는 동사가 아님
    
    
}
