package bitcamp.java110.cms.domain;

//@SuppressWarnings("unchecked")
public class Manager extends Member { //상위클래스에서 serializable을 인터페이스상솏 받으면 여기서 안써도됨

    private static final long serialVersionUID = 1L;
    //상위클래스에서 serializable을 받으면 부모클래서에서 시리얼버전uid를 써주어야됨.
    protected String position;
    protected String tel;

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}

