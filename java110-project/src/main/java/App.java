import java.util.Scanner;


public class App {
    static String[] names=new String[100];
    static String[] emails=new String[100];
    static String[] passwords=new String[100];
    
    static int index=0;
    // 1) 키보드 입력을 처리 할 객체 준비
    static Scanner keyIn=new Scanner(System.in);
    
    static void printMembers() {
        for(int i=0; i<index; i++)
        {
        System.out.printf("%s, %s ,%s \n",names[i],emails[i],passwords[i]);
        }
    }
    static void inputMembers() {
// 2) 사용자로부터 회원 정보 입력 받기
        
        while(true)
        {
        System.out.print("이름 : ");
        names[index] = keyIn.nextLine();
        
        System.out.print("이메일 : ");
        emails[index] = keyIn.nextLine();
        
        System.out.print("암호 : ");
        passwords[index] = keyIn.nextLine();
        
        System.out.print("계속 할거임 ? (Y/n)");
        String yn=keyIn.nextLine();
        
        index ++;
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
