// 객체 생성하기 : factory method 패턴 적용
package ex01;

public class Test03 {
    
    public static void main(String[] args) {
        CarFactory2 f = new CarFactory2(); 
        Car c1 = f.create("부가티");
        
        System.out.println(c1);
    }
}
