// 인스턴스 비교 I : equals() overriding 전
package ex05;

import java.util.HashSet;

public class Test02_p3 {
    
    static class Member {
        String name;
        int age;
        
        public Member(String name,int age) {
            this.name=name;
            this.age=age;
        }
        
        @Override
        public String toString() {
            return "Member [name=" + name + ", age=" + age + "]";
        }

        @Override
        public boolean equals(Object obj) {
            // 인스턴스 필드의 값이 같을 때 true를 리턴하도록 재정의 한다.
            // if (obj.instanceof == Member) 이것보다 아래처럼 쓰는게 안전함
            if (!(obj.getClass() == Member.class))
                return false;
            
            Member other = (Member) obj;
            
            if(this == other)
                return true;
            
            if(!this.name.equals(other.name) || this.age != other.age)
                return false;
            
            return true;
        }
        
        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }
    }
    
    public static void main(String[] args) {
        
        String s1 = new String("홍길동");
        String s2 = new String("홍길동");
        
        if(s1 == s2) System.out.println("s1 == s2");
        else System.out.println("s1 != s2");
        
        if(s1.equals(s2)) System.out.println("s1 == s2");
        else System.out.println("s1 != s2");
        
        // Set은 같은 값을 중복해서 저장하지 않는다.
        // => 즉 인스턴스가 같은지를 비교하는 것이 아니라 값이 같은지를 비교한다.
        // => 또한 HashSet은 이름 그대로 인스턴스의 hash 값이 같은지를 비교한다.
        //    주의!
        //    Object에서 상속 받은 hashCode()는 각 인스턴스 마다
        //    고유의 hash 값을 리턴한다.
        //    equals()의 리턴 값이 true라도 hash 값이 다르다는 것이다.
        //
        // 해결책
        // => 인스턴스의 값이 같으면 같은 hash 값을 리턴하도록 오버라이딩 하라!
        // => String 클래스는 equals()와 hashCode() 모두 오버라이딩 하였다.
        //    String 클래스 외에 Wrapper 클래스도 마찬가지이다.
        HashSet<String> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        
        System.out.println("-------------");
        for(String s : set) {
            System.out.println(s);
        }
        System.out.println("-------------");
        
        Member obj1 = new Member("홍길동",20);
        Member obj2 = new Member("홍길동",20);
        
        if(obj1 == obj2) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");
        
        // 2) equals() 메서드를 오버라이딩 하여 두 인스턴스의 값을 비교했기 때문에
        //    인스턴스가 다르더라도 필드의 값이 같다면 true를 리턴할 것이다.
        if(obj1.equals(obj2)) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");
        
        HashSet<Member> set2 = new HashSet<>();
        set2.add(obj1);
        set2.add(obj2);
        
        System.out.println("-------------");
        for(Member m : set2) {
            System.out.println(m);
        }
        System.out.println("-------------");
    }
}
