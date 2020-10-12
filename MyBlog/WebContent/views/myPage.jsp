<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/setPrePath.jspf" %>
<%@ page import="me.ep.domain.UserVO, me.ep.dao.UserDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="readonly" value="readonly" />
<c:set var="method" value="get" />
<c:set var="modify" value="회원 정보 수정" />
<c:set var="withdraw" value="" />
<c:set var="autofocus" value="" />
<%
UserDAO udao = UserDAO.getInstance();
UserVO user = udao.selectUser((String)request.getSession().getAttribute("id"));
if(request.getAttribute("modify") != null){%>
	<c:set var="readonly" value="" />
	<c:set var="method" value="post" />
	<c:set var="modify" value="수정 완료" />
	<c:set var="autofocus" value="autofocus" />
	<c:set var="withdraw" value="<button class='withdraw' href='/UserWithdrawAction' >회원 탈퇴</button>" />
<%
}
%>
<c:set var="user" value="<%=user %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
    <link rel="stylesheet" href="/css/userInfo.css">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<%@ include file="/include/header.jspf" %>
<div class="info_box">
	<div class="info_content">
		<div class="info_instruction">
			<h1></h1>
			<p></p>
		</div>
	<div class="info_user"> <!-- info user -->
<form action="/UserModifyAction" method="${method}" class="form">
	<h1>아이디</h1><input id="info_id" name="info_id" readonly value="${user.getId()}">
	
	<h1>비밀번호</h1><input id="info_pw"${readonly} name="info_pw" value="${user.getPw()}" ${autofocus }>
	<br/><span id="pw_msg" class="check_msg"></span><br/>
	
	<h1>비밀번호 확인</h1><input id="info_pw_check"${readonly} value="">
	<br/><span id="pwCheck_msg" class="check_msg"></span><br/>
	
	<h1>이름</h1><input id="info_name" ${readonly} name="name" value="${user.getName()}">
	<br/><span id="name_msg" class="check_msg"></span><br/>
	
	<h1>이메일</h1><input id="info_email" ${readonly} name="email" value="${user.getEmail()}">
	<br/><span id="email_msg" class="check_msg"></span><br/>
	
	<h1>휴대번호</h1><input id="info_phoneNum" ${readonly} name="phoneNum" value="${user.getPhoneNum()}">
	<br/><span id="phoneNum_msg" class="check_msg"></span><br/>
	
	<h1>생년월일</h1><input id="info_birthOfDate" readonly name="dateOfBirth" value="${user.getDateOfBirth()}">
	
	<h1>가입날짜</h1><input id="info_inDate" readonly value="${user.getInDate()}">
	
	<h1>수정날짜</h1><input id="info_updateDate" readonly value="${user.getUpdateDate()}">
	
	<h1>멤버등급</h1><input id="info_grade" readonly value="${user.getGrade()}"></br>
	
	<input type="hidden" id="prepath" value=<%=prePath %>>
	<button type="submit" class="modify" id="form_submit">${modify}</button></br>
</form>
${withdraw}
	</div>  <!-- /end info_user -->
</div><!-- /end info content -->
</div><!-- /end info box -->
<%@ include file="/include/footer.jspf" %>
<script type="text/javascript" src="/js/infoFormCheck.js"></script>
</body>
</html>