<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="bitcamp.java110.cms.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, th, td {
    border: 1px solid gray;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h1>매니저 목록</h1>
<p><a href='form.html'>추가</a></p>
<table>
<thead>
<tr>
    <th>번호</th> <th>이름</th> <th>이메일</th> <th>직위</th>
</tr>
</thead>
<tbody>
<%
StudentDao studentDao = (StudentDao)this.getServletContext()
.getAttribute("studentDao");
List<Student> list = studentDao.findAll();
for (Student s : list) {
%>
<tr>
    <td><%= s.getNo() %></td>
    <td><a href='detail?no=<%= s.getNo() %> %>'><%= s.getName() %></a></td>
    <td><%=s.getEmail() %></td>
    <td><%=s.getSchool() %></td>
    <td><%=s.isWorking() %></td>
</tr>
<% } %>
</tbody>
</table>

<jsp:include page="../footer.jsp"/>

</body>
</html>
