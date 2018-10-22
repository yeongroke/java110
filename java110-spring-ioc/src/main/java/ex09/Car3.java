package ex09;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 자바 리소스임 
// @Resource = @Autowired + Qualifier 사용법
// 이거의 문제점은 안에 값이 없어도 에러가 안뜬다는것이다.
@Component
public class Car3 {
    
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    
    //@Resource(name="e2") // == @Autowired Qualifier("e2")
    private Engine engine;
    
    // 스프링 IoC 컨테이너는
    // 생성자가 한 개일 때 파라미터에 해당하는 타입의 객체를 자동 주입한다.
    // => 파라미터에 @Autowired를 붙여도 되고, 생략해도 된다.
    public Car3(/*@Autowired*/ Engine engine) {
        System.out.println("Car(engine) 호출됨!");
        this.engine=engine;
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }


    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        System.out.println("Car.setCreatedDate() 호출됨!");
        this.createdDate = createdDate;
    }

    public Engine getEngine() {
        return engine;
    }
    
    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }
}
