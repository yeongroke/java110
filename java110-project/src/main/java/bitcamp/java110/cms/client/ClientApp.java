package bitcamp.java110.cms.client;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        try (
                //여기 가로안에는 인터페이스 만 들어올수 있다.
                //서버에 연결하기
                Socket socket = new Socket("localhost",8888);

                //서버에 데이터를 보내고 읽을 도구를 준비하기
                //OutputStream out = socket.getOutputStream();
                //BufferedOutputStream out1 = new BufferedOutputStream(out);
                //버퍼를 중간에 안끼면 print가 없으므로 출력이 안됨
                PrintStream out =new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

                //InputStream in = socket.getInputStream();
                //InputStreamReader in1 = new InputStreamReader(in);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //이렇게만 있으면 내용이 버퍼에만 쌓인다 그걸 출력을 해주어야 한다.
                ){
            out.println("HELLO");//출력
            out.flush();
            //서버에서 읽어야지 다음라인으로 이동한다 즉 , 서버에서 끝나야 반응한다,읽어야됨
            //client에서 server로 보내면 반응 해줘야됨 즉 서로 println을 해주면 안됨.
            System.out.println(in.readLine());

            while (true) {
                String requestLine = prompt();
                out.println(requestLine); out.flush();
                while(true) {
                    String responLine = in.readLine(); 
                    System.out.println(responLine);
                    if(responLine.length() == 0)
                        break;
                }
                if (requestLine.toUpperCase().equals("EXIT"))
                    break;
            }
        }
        keyIn.close();
    }
private static String prompt() {
        System.out.print("입력> ");
        return keyIn.nextLine();
    }
}
