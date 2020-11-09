<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>매장 등록</title>
</head>
<body>

<h1>Business Store Register Form</h1>
<form action="/business/register" method="post">

	<label id="storeNm">매장명</label>
	<input name="storeNm"></br>
	
	<label id="telno">전화번호</label>
	<input name="telno"></br>
	
	<input name="buserId" value="${userId}" type="hidden">
	
	<label id="openTm">시작시간</label>
	<input name="openTm"></br>
	
	<label id="closeTm">마감시간</label>
	<input name="closeTm"></br>
	
	<button type="submit">제출하기</button>
</form>
</body>
</html>