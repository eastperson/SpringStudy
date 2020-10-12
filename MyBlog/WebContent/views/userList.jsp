<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/setPrePath.jspf" %>
<%@ page import="me.ep.domain.UserVO, me.ep.dao.UserDAO, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
UserDAO udao = UserDAO.getInstance();
List<UserVO> userList = udao.selectAllUsers();
%>
<c:set var="userList" value="<%=userList %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/userInfo.css">
</head>
<body>
<%@ include file="/include/header.jspf" %>
	<div class="info_box">
	<c:forEach var="user" items="${userList}">
	<div class="info_user"> <!-- info user -->
		<h1 class="info_id">ID : <c:out value="${user.getId()}"/></h1>
		<h1 class="info_pw">PW : <c:out value="${user.getPw()}"/></h1>
		<h1 class="info_email">EMAIL : <c:out value="${user.getEmail()}"/></h1>
		<h1 class="info_phoneNum">PHONE NUMBER :<c:out value="${user.getPhoneNum()}"/></h1>
		<h1 class="info_birthOfDate">생년월일 : <c:out value="${user.getDateOfBirth()}"/></h1>
		<h1 class="info_inDate">가입날짜 : <c:out value="${user.getInDate()}"/></h1>
		<h1 class="info_updateDate">수정날짜 : <c:out value="${user.getUpdateDate()}"/></h1>
		<h1 class="info_grade">멤버등급 : <c:out value="${user.getGrade()}"/></h1>
	</div>  <!-- /end info_user -->
	</c:forEach>
	<div class="info_user"> 
		<a class="withdraw" href="/UserWithdrawAction">회원탈퇴</a>
	</div>  <!-- /end info_user -->
	</div>
<%@ include file="/include/footer.jspf" %>
</body>
</html>