<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"
	isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP:useBean</title>
</head>
<body>
	<h1>JSP:useBean - scope를 지정하지 않으면 ?지정하지 않으면 기본값은 page이다.</h1>
	<pre>
- scope를 지정하지 않으면 다음 순서로 객체를 찾는다.
  page --> request --> session --> application
</pre>
<%
// 테스트를 위해 기존에 세션에 보관된 데이터를 모두 제거하낟.
session.invalidate();
session = request.getSession();

request.setAttribute("name", "유관순");
pageContext.setAttribute("name","안중근");
%>
<jsp:useBean id="name" class="java.lang.String"/>

<p>이름: <%=name %>
</body>
</html>