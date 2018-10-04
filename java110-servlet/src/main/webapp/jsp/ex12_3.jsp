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
	<h1>JSP:useBean - 보관소에 객체가 없을 때 ?</h1>
	<pre>
- 보관소에 객체가 없으면 class 속성에 지정된 타입으로 객체를 만든다.
&lt;jsp:useBean 
        scope="보관소이름" 
        id="보관할 때 사용한 이름"
        class="저장된 객체의 타입"%>
위의 태그는 다음과 같이 동작하는 자바 코드로 변환한다.
자바 코드:
java.util.ArrayList names1 = 
(java.util.ArrayList)request.getAttribute("names1")
if(names1 == null) {
    names1 = new java.util.ArrayList();
    pageContext.setAttribute("names1",names1);
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
<jsp:useBean scope="request" id="names1" class="java.util.ArrayList"/>
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
<p>names2의 사이즈: <%=names2.size() %>
</body>
</html>