package bitcamp.java110.cms.server;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {

    static Scanner keyIn = new Scanner(System.in);
    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;
    public ServerApp() throws Exception {
        createIoCContainer();
        logBeanOfContainer();
        processRequestHandlerMappingAnnotation();
    }
    
    private void createIoCContainer() {
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java110/cms/conf/application-context.xml");
    }
    
    private void processRequestHandlerMappingAnnotation() {
        requestHandlerMap = new RequestMappingHandlerMapping();
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            Object obj = iocContainer.getBean(name);

            requestHandlerMap.addMapping(obj);
        }
    }
    private void logBeanOfContainer() {
        System.out.println("--------------------------");
        String [] nameList = iocContainer.getBeanDefinitionNames();
        for(String name : nameList) {
            System.out.println(name);
        }
        System.out.println("--------------------------");
    }
    
    public void service() throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888); 
        System.out.println("서버 실행 중 . . . . . . . . . . . .");
        
        while(true) {
            try (
                    Socket socket = serverSocket.accept();
                    PrintWriter out =new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    ) {
                System.out.println(in.readLine());
                out.println("ok : kyr"); out.flush();
                while(true) {
                    String requestLine = in.readLine();
                    if(requestLine.toUpperCase().equals("EXIT")) {
                        out.println("goodbye");
                        out.println();
                        out.flush();
                        break;
                    }
                    //요청 객체 준비
                    Request request = new Request(requestLine);
                    //응답 객체 준비
                    Response response = new Response(out);
                    
                    RequestMappingHandler mapping = requestHandlerMap.getMapping(request.getAppPath());
                    if (mapping == null) {
                        out.println("해당 요청을 처리할 수 없습니다.");
                        out.println();
                        out.flush();
                        continue;
                    }
                    
                    try {
                        //요청 핸들러 호출
                        mapping.getMethod().invoke(mapping.getInstance(), request , response);
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("요청 처리 중에 오류가 발생하였습니다.");
                    }
                    out.println(); // ("")이렇게 해도상관없음.
                    out.flush();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        ServerApp serverApp = new ServerApp();
        serverApp.service();
    }
}
