package ex01;

import java.sql.Date;

public class CarFactory2 {
    
   /* private CarFactory2() {}
*/    
    /*private static CarFactory2 instance;
    // 싱글톰 패턴 값이 없으면 한개만 만드는 
    // static 자체가 값 하나만 만듬
    public static CarFactory2 getInstance() {
        if (instance == null) {
            instance = new CarFactory2();
        }
        return instance;
    }*/
    
    public Car create(String model) {
        Car c = new Car();
        
        switch(model) {
        case "부가티":
            c.setModel("bogati");
            c.setCc(6000);
            c.setMaker("비트캠프");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
        case "소나다":
            c.setModel("sonata");
            c.setCc(1980);
            c.setMaker("현대자동자");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
        case "그랜저":
            c.setModel("grandeur");
            c.setCc(2500);
            c.setMaker("현대자동자");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
        default:
            c.setModel("avente");
            c.setCc(2200);
            c.setMaker("기아");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
        }
        return c;
    }
}
