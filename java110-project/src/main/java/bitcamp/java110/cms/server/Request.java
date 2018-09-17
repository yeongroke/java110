package bitcamp.java110.cms.server;


import java.util.HashMap;
import java.util.Map;

public class Request {
    String command;
    String appPath;
    String queryString;
    Map<String, String> paramMap = new HashMap<>();
    
    public Request(String command) {
        this.command=command;
        //명령어에서 Query String을 분리한다.
        //ex) manager/detail?no=10
        //ex) manager/add?name=aaa&email =aaa@test.com&password=1111
        String[] values = command.split("\\?"); 
        //정규분포식에서는 그냥 ?을 인식 못하므로 저렇게 해주어야한다
        // 그냥 \?은 자바 자체에서 printf에서 \?을 인식하므로 \\?을 써주어야한다.
        this.appPath = values[0]; //ex)manager/detail
        if(values.length >=2) {   
            queryString = values[1]; //ex) no = 10
            parseQueryString(queryString);
        }
    }
    private void parseQueryString(String qs) {
        String[] values = qs.split("&");
        for(String value : values) {
            String[] kv = value.split("="); 
            paramMap.put(kv[0], kv[1]);
        }
    }
    public String getParameter(String name) {
        return this.paramMap.get(name);
    }
    public String getCommand() {
        return this.command;
    }
    public String getAppPath() {
        return this.appPath;
    }
    public String getQueryString() {
        return this.queryString;
    }
    public static void main(String[] args) {
        String str = "manager/add?name=aaa&email =aaa@test.com&password=1111";
        
        Request req =new Request(str);
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("password"));
        
        /*System.out.println(req.getCommand());
        System.out.println(req.getAppPath());
        System.out.println(req.getQueryString());*/
        
        /*assertEquals(req.getCommand(), "manager/detail?no=20");
        assertEquals(req.getAppPath(), "manager/detail");
        assertEquals(req.getQueryString(), "no=20");*/
        
    }
}
