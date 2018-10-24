package ex02;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

// String ==> java.sql.Date 프로퍼티 값 변환기
//
public class DatePropertyEditor extends PropertyEditorSupport{
    
    SimpleDateFormat format;
    
    public DatePropertyEditor(SimpleDateFormat format) {
        this.format=format;
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            /*Date date = format.parse(text);
            // 내부 필드에 저장한다
            this.setValue(date);*/
            this.setValue(format.parse(text));
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
        // 스프링 IoC 컨테이너는 이 메서드를 호출한 후,
        // 변환된 값을 꺼내기 위해 getValue()를 호출하여 그 리턴 값을 사용한다.
    }
    @Override
    public Object getValue() {
        // 이 메서드는 오버라이딩 할 필요가 없다.
        // 
        System.out.println("DatePropertyEditor.getValue()");
        return super.getValue();
    }
}
