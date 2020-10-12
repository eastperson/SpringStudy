<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/getPrePath.jspf" %>
<%@ include file="/include/getMsg.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
    <link rel="stylesheet" href="/css/index.css?ver=1">
    <link rel="stylesheet" href="/css/registerForm.css?ver=1">
</head>
<body>
<%@ include file="/include/header.jspf" %>
<main class="main_box"> <!-- main_box -->
    <div class="content"> <!-- content -->
        <div class="instruction">
        <h1>AI 아카데미 등록을 환영합니다.</h1>
        <p>            
            Pando members get full access to every article published on Pando, including our full archive. You’ll also get free access to Pando Monthly events, each event’s live video stream and our full video archive.
        </p>
        <p>
            To activate your membership immediately, enter your payment details and subscription preferences below.
        </p>
    </div>
<form action="/RegisterAction" method="post" id="register_action" class="form">
	<div class="radio">
        <h2>등급 선택</h2>
            <input type="radio" name="grade" value="Diamond"><span>Diamond</span><br/>
            <input type="radio" name="grade" value="Platinum"><span>Platinum</span><br/>
            <input type="radio" name="grade" value="Gold"><span>Gold</span><br/>
            <input type="radio" name="grade" value="Silver"><span>Silver</span><br/>
            <input type="radio" name="grade" value="Bronze"><span>Bronze</span><br/>
        </div>
        
	<input id="user_id" type="text" name="user_id" placeholder="아이디">
	<br/><span id="id_msg" class="check_msg"></span><br/>
	
	
	<input id="user_pw" type="password" name="user_pw" placeholder="비밀번호">
	<br/><span id="pw_msg" class="check_msg"></span><br/>
	
	
	<input id="user_pw_check" type="password" name="user_pw_check" placeholder="비밀번호 확인">
	<br/><span id="pwCheck_msg" class="check_msg"></span><br/>
	
	
	<input id="name" type="text" name="name" placeholder="이름">
	<br/><span id="name_msg" class="check_msg"></span><br/>
	
	
	<input id="email" type="email"name="email" placeholder="이메일">
	<br/><span id="email_msg" class="check_msg"></span><br/>
	
	
	<input id="phoneNum" type="text"name="phoneNum" placeholder="휴대번호">
	<br/><span id="phoneNum_msg" class="check_msg"></span><br/>
	
	
	<input id="dateOfBirth" type="date" name="dateOfBirth" placeholder="생년월일" >
	<br/><span id="dateOfBirth_msg" class="check_msg"></span><br/>
	
	<button type="submit" id="form_submit">회원가입</button>
</form>
<h1><%=msg %></h1>
</div> <!-- end content -->
</main> <!-- end main_box -->
<%@ include file="/include/footer.jspf" %>
<script type="text/javascript" src="/js/registerFormCheck.js"></script>
</body>
</html>