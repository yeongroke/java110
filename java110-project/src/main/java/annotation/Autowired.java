package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//의존 객체를 주입하기 위해 호출하는 메서드에 대해 이 애노테이션을 붙인다.
//IoC 컨테이너는 이 애노테이션이 붙은 메서드를 호출하여 의존 객체를 주입한다.
//autowired를 넣으면 알아서 메서드를 찾아다님
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME) //Component만든거 참고
public @interface Autowired {
    boolean required() default true;
}
