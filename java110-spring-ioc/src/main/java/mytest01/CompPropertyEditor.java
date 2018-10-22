package mytest01;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class CompPropertyEditor extends PropertyEditorSupport {
    
    public CompPropertyEditor() {
        System.out.println("Editor 사용");
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        
        Date date = Date.valueOf(text);
        
        this.setValue(date);
    }
    
    @Override
    public Object getValue() {
        
        return super.getValue();
    }
}
