package ex07;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

// String ==> java.sql.Date 프로퍼티 값 변환기
//
public class DatePropertyEditor2 extends PropertyEditorSupport{
    
    public DatePropertyEditor2() {
        System.out.println("DatePropertyEditor() 호출됨!");
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("DatePropertyEditor.setAsText(String)");
        
        Engine e = new Engine();
        
        String[] values = text.split(",");
        e.setMaker(values[0]);
        e.setValve(Integer.parseInt(values[1]));
        e.setDiesel(Boolean.parseBoolean(values[2]));
        
        this.setValue(e);
        
    }
    @Override
    public Object getValue() {
        // 이 메서드는 오버라이딩 할 필요가 없다.
        // 
        System.out.println("DatePropertyEditor.getValue()");
        return super.getValue();
    }
}
