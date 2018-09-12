package bitcamp.java110.cms.domain;

import java.io.Serializable;

public class Member implements Serializable{ //Serializable 이걸써쭈었기때문에 문자가 제대로 출력이된다

    private static final long serialVersionUID = 1L;
    protected String name;
    protected String email;
    //transient 필드 = Serialize(직렬화=바이트 배열화) : 대상에서 제외한다
    protected transient String password;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}