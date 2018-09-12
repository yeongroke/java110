package bitcamp.java110.cms.dao;

public class MandatoryValueDaoException extends RuntimeException{
//이렇게 서브클래스로 입섹션을 만들어준이유는 입섹션을 알아서 분류하려고
    private static final long serialVersionUID = 1L;
    //이렇게 serial아이디를 써주는 이유는 상속을 받으면 그위에 있는 클래스를 다 선언해주는데 
    //그위 serial도잇어서 써주어야됨
    public MandatoryValueDaoException() {
        super();
    }

    public MandatoryValueDaoException(String message, Throwable cause) {
        super(message, cause);// 이걸안써주면 일반 super() 이 자동으로 실행된다.
    }

    public MandatoryValueDaoException(String message) {
        super(message);
    }
    
}
