// 인스턴스 비교 I : equals()와 HashCode 자동생성하기
package ex05;

import java.util.HashSet;

public class Test02_p4 {
    
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Member other = (Member) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
    }
    
    public static void main(String[] args) {
        
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
