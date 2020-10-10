<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/getPrePath.jspf" %>
<%@ include file="/include/getMsg.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/RegisterAction" method="post" id="register_acition">
	
	<label for="user_id">ID</label>
	<input id="user_id" type="text" name="user_id" placeholder="id를 입력하세요(10자 미만)" required><br/>
	
	<label for="user_pw">비밀번호</label>
	<input id="user_pw" type="password" name="user_pw" placeholder="password를 입력하세요(4글자 이상, 20자 미만)" required><br/>
	
	<label for="name">이름</label>
	<input id="name" type="text" name="name" placeholder="이름을 입력하세요(10자 이하)" required><br/>
	
	<label for="email">이메일</label>
	<input id="email" type="email"name="email" placeholder="email를 입력하세요(@포함)" required><br/>
	
	<label for="phoneNum">휴대번호</label>
	<input id="phoneNum" type="text"name="phoneNum" placeholder="휴대번호를 입력하세요" required><br/>
	
	<label for="dateOfBirth">생년월일</label>
	<input id="dateOfBirth" type="date" name="dateOfBirth" placeholder="생년월일을 입력하세요" required><br/>
	<input type="hidden" value=<%=prePath %>>
	
	<button type="submit">회원가입</button>
</form>
<h1><%=msg %></h1>
</body>
</html>