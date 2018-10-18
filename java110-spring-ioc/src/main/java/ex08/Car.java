package ex08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    private Engine engine;

    public Car() {
        System.out.println("Car() 호출됨!");
    }
    
    public Car(String model, int cc) {
        this.model=model;
        this.cc=cc;
        System.out.println("Car(string, int) 호출됨!");
    }
    
    public Car(String model, int cc, Engine engine) {
        this.model=model;
        this.cc=cc;
        this.engine=engine;
        System.out.println("Car(string, int,Engine) 호출됨!");
    }
    
    public Car(int cc , String model) {
        this.model=model;
        this.cc=cc;
        System.out.println("Car(int, string) 호출됨!");
    }
    
    public Car(String maker, String model, Engine engine) {
        this.maker=maker;
        this.model=model;
        this.engine=engine;
        System.out.println("Car(string, int,Engine) 호출됨!");
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
    
    // 해당 의존 객체가 없으면 스프링 IoC 컨테이너는 예외를 발생시킨다. 의존객체는 여기서 app-context에서 값넣은걸 말함
    @Autowired(required=false)  
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }
}
