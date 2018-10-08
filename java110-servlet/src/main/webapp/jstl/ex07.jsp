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
<h1>JSTL - c:foreach</h1>
<pre>
- 반복문을 만든다.
</pre>

<h2>배열</h2>

<%
pageContext.setAttribute("names", new String[]{"뀨찌빠찌","둠칫둠칫","두둠칫"});
%>

<ul>
    <c:forEach items = "${pageScope.names}" var="n">
        <li>${n}</li>
    </c:forEach>
</ul>

<h2>Collection 객체</h2>

<%
List<String> names2 = new ArrayList<>();
names2.add("뀨찌빠찌");
names2.add("둠칫둠칫");
names2.add("두둠칫");
pageContext.setAttribute("names2",names2);
%>

<ul>
    <c:forEach items = "${pageScope.names2}" var="n">
        <li>${n}</li>
    </c:forEach>
</ul>

<h2>Map 객체</h2>

<%
Map<String,Object> names3 = new HashMap<>();
names3.put("s01","뀨찌빠찌");
names3.put("s02","둠칫둠칫");
names3.put("s03","두둠칫");
pageContext.setAttribute("names3",names3);
%>

<ul>
<%--
Map 객체에 대해 반복문을 돌리면 var로 저장하는 것은
key와 value를 갖고 있는 Entry 객체이다.
 --%>
    <c:forEach items = "${pageScope.names3}" var="n">
        <li>${n.key} : ${n.value}</li>
    </c:forEach>
</ul>

<h2>CVS(comma separated value) 문자열</h2>

<%
pageContext.setAttribute("names4","뀨찌빠찌,둠칫둠칫,두둠칫,ㅇ우에에엥");
%>

<ul>
<%--
Map 객체에 대해 반복문을 돌리면 var로 저장하는 것은
key와 value를 갖고 있는 Entry 객체이다.
 --%>
    <c:forEach items = "${pageScope.names4}" var="n">
        <li>${n}</li>
    </c:forEach>
</ul>

</body>
</html>

