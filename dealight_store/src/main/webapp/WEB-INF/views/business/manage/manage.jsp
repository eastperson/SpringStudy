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

<h1>Business Manage Main Page</h1>

<h1><a href="/business/manage/dealhistory?storeId=${storeId}">Deal History</a></h1>


<p><fmt:formatDate pattern="yyyy-MM-dd" value="${today}" /></p>

<p>다음 웨이팅 정보 : ${nextRsvd}</p>
<p>웨이팅 현황  : ${waitList }</p>
<p>매장정보 : ${store}</p>
<p>예약 리스트 : ${rsvdList }</p>
<c:forEach items="${rsvdList}" var="rsvd">
<a href="/business/manage/reservation?rsvdId=${rsvd.id}"><div>
=====================================
예약 번호: ${rsvd.id}
매장 번호: ${rsvd.storeId}
예약 회원 아이디: ${rsvd.userId}
핫딜 번호: ${rsvd.htdlId}
승인 번호: ${rsvd.aprvNo}
예약 인원: ${rsvd.pnum}
예약 시간: ${rsvd.time}
예약 상태: ${rsvd.stusCd}
예약 총 금액: ${rsvd.totAmt}
예약 총 수량: ${rsvd.totQty}
예약 작성 날짜: ${rsvd.inDate}
=====================================
</div>
</a>
</c:forEach>
<p>시간대별 예약자 현황 : ${todayRsvdMap }</p>
-------
<p>오늘 예약 수 : ${totalTodayRsvd }</p>
<p>오늘 예약 인원 수 : ${totalTodayRsvdPnum}</p>
<p>오늘 선호 메뉴 맵 : ${todayFavMenuMap }</p>
<p>오늘 예약자 리스트 : ${todayRsvdUserList}</p>
</body>
</html>