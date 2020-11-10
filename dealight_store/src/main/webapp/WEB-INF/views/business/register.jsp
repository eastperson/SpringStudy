<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<label id="breakSttm">브레이크 타입 시작시간</label>
	<input name="breakSttm"></br>
	
	<label id="breakEntm">브레이크 타입 마감시간</label>
	<input name="breakEntm"></br>
	
	<label id="lastOrdTm">라스트 오더 시간</label>
	<input name="lastOrdTm"></br>
	
	<label id="n1SeatNo">1인 테이블 수</label>
	<input name="n1SeatNo"></br>
	
	<label id="n2SeatNo">2인 테이블 수</label>
	<input name="n1SeatNo"></br>
	
	<label id="n4SeatNo">4인 테이블 수</label>
	<input name="n4SeatNo"></br>
	
	<label id=storeIntro">매장 소개</label>
	<input name="storeIntro"></br>
	
	<label id="avgMealTm">평균 식사 시간</label>
	<input name="avgMealTm"></br>
	
	<label id="hldy">휴무일</label>
	<input name="hldy"></br>
	
	<label id="acmPnum=">수용인원</label>
	<input name="acmPnum="></br>
	
	<button type="submit">제출하기</button>
</form>
</body>
</html>