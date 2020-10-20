<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/setPrePath.jspf" %>
<%@ page import="com.ep.domain.UserVO,java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
List<UserVO> userList = null;
if(request.getAttribute("userList") != null)
	userList = (List<UserVO>) request.getAttribute("userList");
%>
<c:set var="userList" value="<%=userList %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/index.css?ver=1">
<link rel="stylesheet" href="/resources/css/userInfo.css?ver=1">
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jspf" %>
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
<%@ include file="/WEB-INF/views/include/footer.jspf" %>
</body>
</html>