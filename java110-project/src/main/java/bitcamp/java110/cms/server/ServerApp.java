package bitcamp.java110.cms.server;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerApp {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        //클라이언트 연결을 기다리는 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888); 
        System.out.println("서버 실행 중 . . . . . . . . . . . .");
        //backlog = 대기열 크기  , 대기열 크기를 벗어나면 거절당함
        //queue방식으로 관리함 : 먼저 오는 순서대로 관리하는 것

        while(true) {
            try (
                    Socket socket = serverSocket.accept();

                    PrintStream out =new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    ) {
                System.out.println(in.readLine());
                out.println("ok"); out.flush();
                while(true) {
                    String requestLine = in.readLine();
                    if(requestLine.toUpperCase().equals("EXIT")) {
                        out.println("goodbye");
                        out.println();
                        out.flush();
                        break;
                    }
                    out.println(requestLine);//출력
                    out.println(); // ("")이렇게 해도상관없음.
                    out.flush();
                }
            }
        }
    }
}
