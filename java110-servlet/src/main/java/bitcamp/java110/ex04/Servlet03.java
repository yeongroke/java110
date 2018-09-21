package bitcamp.java110.ex04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*
 * javax.servlet.Genericservlet
 * 클라이언트가 보낸 데이터 읽기 - POST 요청으로 보낸 데이터 
 */

@WebServlet("/ex04/servlet03")
public class Servlet03 extends GenericServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // POST 요청으로 값을 서버에 전달하는 방법
        // => HTTP 요청에서 message-body 영역에 데이터를 붙여 전달한다.
        //
        // 테스트 :
        // => HTML의 form 태그를 이용하여 전송한다.
        // => http://localhost:8888/ex04/post.html 페이지에서 값을 입력한 후 보내기버튼 클릭
        //
        // => 그러나 서블릿에서 값을 꺼내는 방법은 GET 요청 때와 같다.
        //

        // 멀티파트 형식으로 업로드 된 데이터를 getParameter()로 값을 꺼낼 수 없다.
        // => 별도의 처리 작업을 해야 한다.
        /*
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean working = Boolean.parseBoolean(req.getParameter("working"));
        String file1 = req.getParameter("file1");
        String file2 = req.getParameter("file2");
         */

        //http://commons.apache.org/proper/commons-fileupload/using.html
        // 1) 멀티 파트 데이터를 분석하여 객체로 만드는 공장을 준비한다.
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 2) 클라이언트 요청을 처리할 객체를 준비하고 공장과 연결한다.
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 3) 클라이언트 요청을 처리한다.
        //    => ServletFileUploadsms ServletRequest 객체를 통해 데이터를 읽는다.
        //    => 각 파트는 DistFileItemFactory를 통해 FileItem 객체로 만든다.
        //
        HashMap<String, String> parts = new HashMap<>();
        try {
            List<FileItem> items = upload.parseRequest((HttpServletRequest)req);

            for(FileItem item : items) {
                if(item.isFormField()) { //일반 데이터
                    parts.put(item.getFieldName()//파라미터 명
                            , item.getString("UTF-8"));//파라미터 값
                }else { // 파일
                    parts.put(item.getFieldName()//파라미터 명
                            , item.getName());// 저장할 때 사용한 파일명
                    
                    String filename = UUID.randomUUID().toString();
                    //저장할 때마다 파일 번호가 바뀌게 설정해주는 것
                    
                    String path = this.getServletContext().getRealPath("/upload/"+filename);
                    
                    item.write(new File(path));
                    //write 은 파일타입이므로 파일에 담아서 주어야하낟
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name = %s\n",parts.get("name"));
        out.printf("age = %d\n",Integer.parseInt(parts.get("age")));
        out.printf("working = %b\n",Boolean.parseBoolean(parts.get("working")));
        out.printf("file1=%s\n",parts.get("file1"));
        out.printf("file2=%s\n",parts.get("file2"));

    }
}

// 멀티파트 POST 요청
//
/*
POST /ex04/servlet03 HTTP/1.1
Host: localhost:8888
Content-Length: 105917
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryyTYhVOIZhHsehLfG
User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,;q=0.8
Referer: http://localhost:8888/ex04/file.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cookie: JSESSIONID=3C16BA5E559A11DF60356AF93DF6AAA0
Connection: keep-alive

------WebKitFormBoundaryyTYhVOIZhHsehLfG
Content-Disposition: form-data; name="name"

홍길동
------WebKitFormBoundaryyTYhVOIZhHsehLfG
Content-Disposition: form-data; name="age"

234
------WebKitFormBoundaryyTYhVOIZhHsehLfG
Content-Disposition: form-data; name="working"

true
------WebKitFormBoundaryyTYhVOIZhHsehLfG
Content-Disposition: form-data; name="file1"; filename="pic1.jpeg"
Content-Type: image/jpeg
 */
