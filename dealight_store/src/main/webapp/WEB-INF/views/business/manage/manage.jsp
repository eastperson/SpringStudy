<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>매장 관리</title>
</head>
<body>

<h1>Business Manage Main Page</h1>

<h1><a href="/business/manage/dealhistory?storeId=${storeId}">Deal History</a></h1>


<p>현재 날짜 : <fmt:formatDate pattern="yyyy-MM-dd" value="${today}" /></p>
<p>현재 시간 : <fmt:formatDate pattern="HH:mm:ss" value="${today}" /></p>

<p>다음 예약 정보 : ${nextRsvd}</p>

<p>다음 웨이팅 정보 : ${nextWait}</p>
<a href="/business/manage/enter?waitId=${nextWait.id}&storeId=${storeId}">입장</a> </br>
<a href="/business/manage/noshow?waitId=${nextWait.id}&storeId=${storeId}">노쇼</a>

<p>현재 착석 가능 여부 : ${store.bstore.seatStusCd}</p>

<p><a href="/business/manage/waiting/register?storeId=${storeId}">오프라인 웨이팅 등록</a></p>

<p><a href="/business/manage/modify?storeId=${storeId}">매장 정보 수정</a></p>

<h2>웨이팅 리스트</h2>

<c:if test="${not empty waitList}">
<c:forEach items="${waitList}" var="wait">
=====================================</br>
<a href="/business/manage/waiting?waitId=${wait.id}"><div>
웨이팅 번호 : ${wait.id}</br>
매장 번호 : ${wait.storeId}</br>
회원 아이디 : ${wait.userId}</br>
웨이팅 접수시간 : ${wait.waitRegTm}</br>
웨이팅 인원 = ${wait.waitPnum}</br>
고객 연락처 = ${wait.custTelno }</br>
고객 이름 = ${wait.custNm }</br>
웨이팅 상태 = ${wait.waitStusCd}</br>
</div>
</a>
</c:forEach>
</c:if>
 

<p>매장정보 : ${store}</p>
<p>라스트 오더 시간 : ${lastOrder}</p>


<h2>예약리스트</h2>
<c:if test="${not empty rsvdList}">
<c:forEach items="${rsvdList}" var="rsvd">
<a href="/business/manage/reservation?rsvdId=${rsvd.id}"><div>
=====================================</br>
예약 번호: ${rsvd.id}</br>
매장 번호: ${rsvd.storeId}</br>
예약 회원 아이디: ${rsvd.userId}</br>
핫딜 번호: ${rsvd.htdlId}</br>
승인 번호: ${rsvd.aprvNo}</br>
예약 인원: ${rsvd.pnum}</br>
예약 시간: ${rsvd.time}</br>
예약 상태: ${rsvd.stusCd}</br>
예약 총 금액: ${rsvd.totAmt}</br>
예약 총 수량: ${rsvd.totQty}</br>
예약 작성 날짜: ${rsvd.inDate}</br>
</div>
</a>
</c:forEach>
</c:if>

<p>시간대별 예약자 현황 : ${todayRsvdMap }</p>
-------
<p>오늘 예약 수 : ${totalTodayRsvd }</p>
<p>오늘 예약 인원 수 : ${totalTodayRsvdPnum}</p>
<p>오늘 선호 메뉴 맵 : ${todayFavMenuMap }</p>

<h2>오늘 예약 회원</h2>
<c:if test="${not empty todayRsvdUserList}">
<c:forEach items="${todayRsvdUserList}" var="user">
<div>
==========================================</br>
회원 아이디 : ${user.userId}</br>
회원 이름 : ${user.name}</br>
회원 이메일 : ${user.email}</br>
회원 전화번호 : ${user.telno}</br>
생년 월일 : ${user.brdt}</br>
성별 : ${user.sex }</br>
회원 프로필 사진 : ${user.photoSrc}</br>
패널티 회원 여부 : ${user.pmStus}</br>
</div>
</c:forEach>
</c:if>
 
</body>
</html>