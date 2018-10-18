// 객체 생성하기 : new 명령 사용
package ex01;

public class Test01 {
    public static void main(String[] args) {
        Car c1 = new Car();
        
        c1.setModel("부가티");
        c1.setCc(6000);
        
        System.out.println(c1);
    }
}
