package ex01;

import java.sql.Date;

public class CarFactory1 {
    public static Car create(String model) {
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
