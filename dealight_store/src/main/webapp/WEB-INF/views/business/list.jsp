<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����Ʈ</title>
</head>
<body>

<h1>Business List Page</h1>

<h2>${userId}</h2>

<h2><a href="/business/register">����ϱ�</a></h2>

<c:forEach items="${storeList}" var="store">
============================================
	<a href='/business/manage/?storeId=${store.storeId}'><div>
	<h2>���� �̸� : <c:out value="${store.storeNm}" /></h2>
	<h2>���� ��ȭ��ȣ : <c:out value="${store.telno}" /></h2>
	<h2>���� ������ ���̵� : <c:out value="${store.bstore.buserId}" /></h2>
	<h2>���� ���� ���� �ð� : <c:out value="${store.bstore.openTm}" /></h2>
	<h2>���� ���� ���� �ð� : <c:out value="${store.bstore.closeTm}" /></h2>
	</div></a>
============================================</br>
</c:forEach>


</body>
</html>