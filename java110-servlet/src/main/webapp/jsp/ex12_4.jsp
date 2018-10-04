<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"
	isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 액션 태그</title>
</head>
<body>
	<h1>JSP:useBean - type 속성</h1>
	<pre>
- 지정한 타입의 객체가 보관소에 객체가 없으면 예외 발생!
    &lt;jsp:useBean 
        scope="request" 
        id="names1"
        type="java.util.ArrayList"%> 
위의 태그는 다음과 같이 동작하는 자바 코드로 변환한다.
자바 코드:
java.util.ArrayList names1 = 
(java.util.ArrayList)request.getAttribute("names1")
if(names1 == null) {
    throw new Exception("해당타입의 객체가 없습니다");
}
</pre>
<%
ArrayList<String> list1 = new ArrayList<>();
list1.add("홍길동");
list1.add("임꺽정");
list1.add("유관순");
request.setAttribute("names1",list1);
%>
<jsp:useBean scope="request" id="names2" class="java.util.ArrayList"/>
<jsp:useBean scope="request" id="names1" type="java.util.ArrayList"/>
<p>이름: <%=names1.get(0) %>
<p>이름: <%=names1.get(1) %>
<p>이름: <%=names1.get(2) %>

<%--
java.util.ArrayList names1 = 
(java.util.ArrayList)request.getAttribute("names1")
if(names2 == null) {
    names2 = new java.util.ArrayList();
    request.setAttribute("names1",names1);
 --%>
<p>names2의 사이즈: <%-- <%=names2.size() --%> %></p>
 <!-- ㅇ --><%-- 템ㄹㄹ--%>
<%  /* jsp 코드 */
String name="홍길동";
%>
<script> <%-- 템플릿 코드이다 자바스크립트가 아님--%>

</script>
</body>
</html>