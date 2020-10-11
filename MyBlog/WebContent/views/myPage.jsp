<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/setPrePath.jspf" %>
<%@ page import="me.ep.domain.UserVO, me.ep.dao.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<%
UserDAO udao = UserDAO.getInstance();
UserVO user = udao.selectUser((String)request.getSession().getAttribute("id"));
%>
<body>
<h1>ID : <%=user.getId() %></h1>
<h1>PW : <%=user.getPw() %></h1>
<h1>EMAIL : <%=user.getEmail() %></h1>
<h1>PHONE NUMBER :<%=user.getPhoneNum() %></h1>
<h1>생년월일 : <%=user.getDateOfBirth() %></h1>
<h1>가입날짜 : <%=user.getInDate() %></h1>
<h1>수정날짜 : <%=user.getUpdateDate() %></h1>
<h1>멤버등급 : <%=user.getGrade() %></h1>
<a href="/views/board/list.jsp">리스트</a>
<a href="/LogoutAction">로그아웃</a>
</body>
</html>