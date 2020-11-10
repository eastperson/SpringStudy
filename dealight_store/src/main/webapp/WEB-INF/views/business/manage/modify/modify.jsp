<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>매장 수정</title>
</head>
<body>

<h1>Business Modify Page</h1>

${msg}

<form action="/business/manage/modify" method="post">

	<input name="storeId" value="${store.storeId}" hidden>

	<label id="storeNm">매장명</label>
	<input name="storeNm" value="${store.storeNm}" readonly></br>
	
	<label id="telno">전화번호</label>
	<input name="telno" value="${store.telno}"></br>
	
	<label id="openTm">시작시간</label>
	<input name="openTm" value="${store.bstore.openTm}"></br>
	
	<label id="closeTm">마감시간</label>
	<input name="closeTm" value="${store.bstore.closeTm}"></br>
	
	<label id="buserId">사업자 회원 아이디</label>
	<input name="buserId" value="${store.bstore.buserId}" readonly></br>
	
	<label id="breakSttm">브레이크타임시작시간</label>
	<input name="breakSttm" value="${store.bstore.breakSttm}"></br>
	
	<label id="breakEntm">브레이크타임마감시간</label>
	<input name="breakEntm" value="${store.bstore.breakEntm}"></br>
	
	<label id="lastOrdTm">라스트오더 시간</label>
	<input name="lastOrdTm" value="${store.bstore.lastOrdTm}"></br>
	
	<label id="n1SeatNo">1인 테이블 개수</label>
	<input name="n1SeatNo" value="${store.bstore.n1SeatNo}"></br>
	
	<label id="n2SeatNo">2인 테이블 개수</label>
	<input name="n2SeatNo" value="${store.bstore.n2SeatNo}"></br>
	
	<label id="n4SeatNo">4인 테이블 개수</label>
	<input name="n4SeatNo" value="${store.bstore.n4SeatNo}"></br>
	
	<label id="storeIntro">매장소개</label>
	<input name="storeIntro" value="${store.bstore.storeIntro}"></br>
	
	<label id="avgMealTm">매장평균식사시간</label>
	<input name="avgMealTm" value="${store.bstore.avgMealTm}" readonly></br>
	
	<label id="hldy">매장휴무일</label>
	<input name="hldy" value="${store.bstore.hldy}"></br>
	
	<label id="acmPnum">매장수용인원</label>
	<input name="acmPnum" value="${store.bstore.acmPnum}"></br>
	
	<button type="submit">제출하기</button>
</form>

<h2><a href="/business/manage/menu?storeId=${store.storeId}" }>메뉴수정</a></h2>

</body>
</html>