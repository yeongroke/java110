package ex02;

import java.beans.PropertyEditorSupport;

// String ==> java.sql.Date 프로퍼티 값 변환기
//
public class CarPropertyEditor extends PropertyEditorSupport{
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            String[] values = text.split(",");
            Car car=new Car();
            car.setModel(values[0]);
            car.setMaker(values[0]);
            car.setAuto(Boolean.parseBoolean(values[0]));
            
            this.setValue(car);
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
