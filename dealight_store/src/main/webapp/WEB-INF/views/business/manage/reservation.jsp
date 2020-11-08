<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>Business Reservation Page</h1>

<h6>예약 번호: ${rsvd.id}</h6>
<h6>매장 번호: ${rsvd.storeId}</h6>
<h6>예약 회원 아이디: ${rsvd.userId}</h6>
<h6>핫딜 번호: ${rsvd.htdlId}</h6>
<h6>승인 번호: ${rsvd.aprvNo}</h6>
<h6>예약 인원: ${rsvd.pnum}</h6>
<h6>예약 시간: ${rsvd.time}</h6>
<h6>예약 상태: ${rsvd.stusCd}</h6>
<h6>예약 총 금액: ${rsvd.totAmt}</h6>
<h6>예약 총 수량: ${rsvd.totQty}</h6>
<h6>예약 작성 날짜: ${rsvd.inDate}</h6>


<c:forEach items="${rsvd.rsvdDtlsList}" var="dtls">
<div>
=====================================
	<h2>매장 이름 : <c:out value="${dtls.rsvdId}" /></h2>
	<h2>매장 전화번호 : <c:out value="${dtls.rsvdSeq}" /></h2>
	<h2>매장 소유자 아이디 : <c:out value="${dtls.menuNm}" /></h2>
	<h2>매장 영업 시작 시간 : <c:out value="${dtls.menuTotQty}" /></h2>
	<h2>매장 영업 종료 시간 : <c:out value="${dtls.menuPrc}" /></h2>
=====================================
</div>
</c:forEach>

</body>
</html>