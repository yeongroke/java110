package ex02;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// @GlobalController 가 붙은 클래스는
// 프론트 컨트롤러가 request handler를 호출할 때마다
// 매번 조언을 얻기 위해 애노테이션 역할에 따라 메서드를 실행한다.
//
@ControllerAdvice
public class GlobalControllerAdvice {
    
    // @InitBinder 조언
    // => request handler를 호출할 때 그 파라미터 값을 준비해야 하는데,
    //    그 값을 준비하는데 도움이 되는 메서드이니까
    //    먼저 이 메서들를 호출하라는 의미이다.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("GlobalControllerAdvice.initbinder 호출");
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        format.setLenient(false); //24시간 표기 방법을 사용할 것인지 여부 false 사용안하는 것
        
        binder.registerCustomEditor(Date.class , new CustomDateEditor(format, true));
        
        binder.registerCustomEditor(Car.class, new CarPropertyEditor());
    }
}
