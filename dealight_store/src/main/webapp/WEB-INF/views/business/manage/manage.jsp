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
<p>시간대별 예약자 현황 : ${todayRsvdMap }</p>
-------
<p>오늘 예약 수 : ${totalTodayRsvd }</p>
<p>오늘 예약 인원 수 : ${totalTodayRsvdPnum}</p>
<p>오늘 선호 메뉴 맵 : ${todayFavMenuMap }</p>
<p>오늘 예약자 리스트 : ${todayRsvdUserList}</p>
</body>
</html>