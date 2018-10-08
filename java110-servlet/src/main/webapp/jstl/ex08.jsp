<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:forTokens</h1>
<pre>
- 반복문을 만든다.
</pre>

<h2>Query String 문자열</h2>

<%
pageContext.setAttribute("qs","name=홍길동&age=20&tel=1111-2222");
%>

<ul>
<%--
Map 객체에 대해 반복문을 돌리면 var로 저장하는 것은
key와 value를 갖고 있는 Entry 객체이다.
 --%>
    <c:forTokens items = "${pageScope.qs}" var="n" delims="&">
        <li>${n}</li>
    </c:forTokens>
</ul>

</body>
</html>


