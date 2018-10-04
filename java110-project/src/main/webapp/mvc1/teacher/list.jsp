<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@page import="bitcamp.java110.cms.dao.TeacherDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>매니저 관리</title>
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
TeacherDao teacherDao = (TeacherDao)this.getServletContext()
.getAttribute("teacherDao");
List<Teacher> list = teacherDao.findAll();
for (Teacher t : list) {
%>
<tr>
    <td><%=t.getNo() %></td>
    <td><a href='detail?no=<%=t.getNo() %>'><%=t.getName() %></a></td>
    <td><%=t.getEmail() %></td>
    <td><%=t.getPay() %></td>
    <td><%=t.getSubjects() %></td>
</tr>
<% } %>
</tbody>
</table>

<jsp:include page="../footer.jsp"/>

</body>
</html>
