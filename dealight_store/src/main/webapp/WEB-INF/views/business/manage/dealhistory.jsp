<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �ֵ� �����丮</title>
</head>
<body>

<h1>Business Hotdeal History Page</h1>

<c:forEach items="${htdlList}" var="htdl">
	--------------------------------------------------------
	<div>
	<h2>�ֵ� �̸� : <c:out value="${htdl.name}" /></h2>
	<h2>�ֵ� ���η� : <c:out value="${htdl.dcRate}" /></h2>
	<h2>�ֵ� ���� �ð� : <c:out value="${htdl.startTm}" /></h2>
	<h2>�ֵ� ���� �ð� : <c:out value="${htdl.endTm}" /></h2>
	<h2>�ֵ� ���� �ο� : <c:out value="${htdl.lmtPnum}" /></h2>
	<h2>�ֵ� �Ұ� : <c:out value="${htdl.intro}" /></h2>
	<h2>�ֵ� ���� ���� : <c:out value="${htdl.befPrice}" /></h2>
	<h2>�ֵ� ���� ��� : <c:out value="${htdl.ddct}" /></h2>
	<h2>�ֵ� ���� �ο� : <c:out value="${htdl.curPnum}" /></h2>
	<h2>�ֵ� ���� ���� : <c:out value="${htdl.stusCd}" /></h2>
	</div>
	--------------------------------------------------------
</c:forEach>

</body>
</html>