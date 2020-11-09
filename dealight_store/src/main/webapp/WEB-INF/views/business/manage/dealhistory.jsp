<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>매장 핫딜 히스토리</title>
</head>
<body>

<h1>Business Hotdeal History Page</h1>

<c:forEach items="${htdlList}" var="htdl">
	--------------------------------------------------------
	<div>
	<h2>핫딜 이름 : <c:out value="${htdl.name}" /></h2>
	<h2>핫딜 할인률 : <c:out value="${htdl.dcRate}" /></h2>
	<h2>핫딜 시작 시간 : <c:out value="${htdl.startTm}" /></h2>
	<h2>핫딜 마감 시간 : <c:out value="${htdl.endTm}" /></h2>
	<h2>핫딜 제한 인원 : <c:out value="${htdl.lmtPnum}" /></h2>
	<h2>핫딜 소개 : <c:out value="${htdl.intro}" /></h2>
	<h2>핫딜 이전 가격 : <c:out value="${htdl.befPrice}" /></h2>
	<h2>핫딜 차감 비용 : <c:out value="${htdl.ddct}" /></h2>
	<h2>핫딜 현재 인원 : <c:out value="${htdl.curPnum}" /></h2>
	<h2>핫딜 현재 상태 : <c:out value="${htdl.stusCd}" /></h2>
	</div>
	--------------------------------------------------------
</c:forEach>

</body>
</html>