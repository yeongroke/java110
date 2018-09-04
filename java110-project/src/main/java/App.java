import java.util.Scanner;

public class App {
    //여러  속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용했다.
    static class Member {
        protected String name;
        protected String email;
        protected String password;
        
        // 인스턴스의 메모리를 다루는 operator=setter/getter/accessor=property=message
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        
    }
    
    static Member[] members=new Member[100];
    
    static int index=0;
    // 1) 키보드 입력을 처리 할 객체 준비
    static Scanner keyIn=new Scanner(System.in);
    
    static void printMembers() {
        for(int i=0; i<index; i++)
        {
        System.out.printf("%s, %s ,%s \n",members[i].getName(),members[i].getEmail()
                            ,members[i].getPassword());
        }
    }
    static void inputMembers() {
// 2) 사용자로부터 회원 정보 입력 받기
        
        while(true)
        {
        Member m=new Member();
        
        System.out.print("이름 : ");
        m.setName(keyIn.nextLine());
        
        System.out.print("이메일 : ");
        m.setEmail(keyIn.nextLine());
        
        System.out.print("암호 : ");
        m.setPassword(keyIn.nextLine());
        
        System.out.print("계속 할거임 ? (Y/n)");
        String yn=keyIn.nextLine();
        
        members[index++]=m; //안에 ++을안써주면 index ++을 밖에 써주어야됨
        
        
        if(yn.toLowerCase().equals("n"))
            break;
        }
    }
    
public static void main(String[] args) {
        
        inputMembers();
        
        printMembers();
        
        keyIn.close();
    }
     
}
