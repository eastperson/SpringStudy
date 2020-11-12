<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매장 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	<input name="openTm" value="${store.openTm}"></br>
	
	<label id="closeTm">마감시간</label>
	<input name="closeTm" value="${store.closeTm}"></br>
	
	<label id="buserId">사업자 회원 아이디</label>
	<input name="buserId" value="${store.buserId}" readonly></br>
	
	<label id="breakSttm">브레이크타임시작시간</label>
	<input name="breakSttm" value="${store.breakSttm}"></br>
	
	<label id="breakEntm">브레이크타임마감시간</label>
	<input name="breakEntm" value="${store.breakEntm}"></br>
	
	<label id="lastOrdTm">라스트오더 시간</label>
	<input name="lastOrdTm" value="${store.lastOrdTm}"></br>
	
	<label id="n1SeatNo">1인 테이블 개수</label>
	<input name="n1SeatNo" value="${store.n1SeatNo}"></br>
	
	<label id="n2SeatNo">2인 테이블 개수</label>
	<input name="n2SeatNo" value="${store.n2SeatNo}"></br>
	
	<label id="n4SeatNo">4인 테이블 개수</label>
	<input name="n4SeatNo" value="${store.n4SeatNo}"></br>
	
	<label id="storeIntro">매장소개</label>
	<input name="storeIntro" value="${store.storeIntro}"></br>
	
	<label id="avgMealTm">매장평균식사시간</label>
	<input name="avgMealTm" value="${store.avgMealTm}" readonly></br>
	
	<label id="hldy">매장휴무일</label>
	<input name="hldy" value="${store.hldy}"></br>
	
	<label id="acmPnum">매장수용인원</label>
	<input name="acmPnum" value="${store.acmPnum}"></br>
	
	<button type="submit">제출하기</button>
</form>

매장 주소 : ${store.addr } </br>
매장 위도 : ${lti}</br>
매장 경도 : ${store.lo}</br>

평균 평점 : ${store.avgRating }</br>
리뷰 수 : ${store.revwTotNum }</br>
좋아요 합계 : ${store.likeTotNum }</br>

<h2>메뉴 리스트</h2>
<c:if test="${not empty menuList}">
<c:forEach items="${menuList}" var="menu">
=====================================</br>
메뉴 일련번호 : ${menu.menuSeq}</br>
메뉴 가격 : ${menu.price }</br>
메뉴사진주소 : ${menu.imgUrl}</br>
메뉴이름 : ${menu.name }</br>
메뉴추천여부 : ${menu.recoMenu }</br>
</c:forEach>
</c:if>

<h2>사진 리스트</h2>
<c:if test="${not empty imgList}">
<c:forEach items="${imgList}" var="img">
=====================================</br>
사진 일련번호 : ${img.imgSeq }</br>
매장 사진 주소 : ${img.imgUrl }</br>
</c:forEach>
</c:if>

<h2>리뷰 리스트</h2>
<c:if test="${not empty revwList}">
<c:forEach items="${revwList}" var="revw">
=====================================</br>
예약 번호 : ${revw.rsvdId }</br>
웨이팅 번호 : ${revw.waitSeq }</br>
회원 아이디 : ${revw.userId }</br>
리뷰 내용 : ${revw.cnts }</br>
리뷰 작성 날짜 : ${revw.regDt }</br>
리뷰 평점 : ${revw.rating }</br>
답글 내용 : ${revw.replyCnts }</br>
답글 등록 날짜 : ${revw.replyRegDt }</br>
</c:forEach>
</c:if>

<h2>태그 리스트</h2>
<c:if test="${not empty tagList}">
<c:forEach items="${tagList}" var="tag">
=====================================</br>
해시 태그 이름 : ${tag.tagNm }</br>
</c:forEach>
</c:if>

<h2><a href="/business/manage/menu?storeId=${store.storeId}" }>메뉴수정</a></h2>

</body>
</html>