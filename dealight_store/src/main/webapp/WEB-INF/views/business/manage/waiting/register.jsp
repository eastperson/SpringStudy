<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>오프라인 웨이팅 등록</title>
</head>
<body>

<h1>Business Waiting Register Page</h1>

<form action="/business/manage/waiting/register?storeId=${storeId}" method="post">

	<label id="custNm">고객 이름</label>
	<input name="custNm"></br>
	
	<label id="custTelno">고객 연락처</label>
	<input name="custTelno"></br>
	
	<label id="waitPnum">웨이팅 인원</label>
	<input name="waitPnum"></br>

	<label id="curTime">현재시간</label>
	<input name="curTime" value="${curTime}" hidden>
	<h2>현재 시간 : ${curTime}</h2>
	
	<input name="storeId" value="${storeId}" hidden>

	<button type="submit">제출하기</button>
</form>

</body>
</html>