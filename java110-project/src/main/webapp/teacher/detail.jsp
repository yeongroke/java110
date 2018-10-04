<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강사 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, th, td {
    border: 1px solid gray;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<header>
    <ul>
<li><a href='/auth/login'>로그인</a></li>
        <li><a href='/student/list'>학생관리</a></li>
        <li><a href='/teacher/list'>강사관리</a></li>
        <li><a href='/manager/list'>매니저관리</a></li>
    </ul>
</header>
<h1>강사 상세정보(mvc)</h1>
<%
Teacher t = (Teacher)request.getAttribute("teacher");
if (t == null) {
%>
<p>해당 번호의 선생님이 없습니다!</p>
<%     
} else { 
%> 
<table>
<tbody>
<tr><th>번호</th><td><%=t.getNo() %></td></tr>
<tr><th>이름</th><td><%=t.getName() %></td></tr>
<tr><th>이메일</th><td><%=t.getEmail() %></td></tr>
<tr><th>암호</th><td><%=t.getPassword() %></td></tr>
<tr><th>전화</th><td><%=t.getTel() %></td></tr>
<tr><th>강의료</th><td><%=t.getPay() %></td></tr>
<tr><th>강의과목</th><td><%=t.getSubjects() %></td></tr>
</tbody>
</table>
<button type='button' onclick='remove()'>삭제</button>
<script>
function remove() {
    location.href = 'delete?no=<%=t.getNo() %>'
}
</script>
<%     
} 
%> 
<footer>
    <p>&copy;자바110기</p>
</footer>
</body>
</html>
