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

<h6>���� ��ȣ: ${rsvd.id}</h6>
<h6>���� ��ȣ: ${rsvd.storeId}</h6>
<h6>���� ȸ�� ���̵�: ${rsvd.userId}</h6>
<h6>�ֵ� ��ȣ: ${rsvd.htdlId}</h6>
<h6>���� ��ȣ: ${rsvd.aprvNo}</h6>
<h6>���� �ο�: ${rsvd.pnum}</h6>
<h6>���� �ð�: ${rsvd.time}</h6>
<h6>���� ����: ${rsvd.stusCd}</h6>
<h6>���� �� �ݾ�: ${rsvd.totAmt}</h6>
<h6>���� �� ����: ${rsvd.totQty}</h6>
<h6>���� �ۼ� ��¥: ${rsvd.inDate}</h6>


<c:forEach items="${rsvd.rsvdDtlsList}" var="dtls">
<div>
=====================================
	<h2>���� �̸� : <c:out value="${dtls.rsvdId}" /></h2>
	<h2>���� ��ȭ��ȣ : <c:out value="${dtls.rsvdSeq}" /></h2>
	<h2>���� ������ ���̵� : <c:out value="${dtls.menuNm}" /></h2>
	<h2>���� ���� ���� �ð� : <c:out value="${dtls.menuTotQty}" /></h2>
	<h2>���� ���� ���� �ð� : <c:out value="${dtls.menuPrc}" /></h2>
=====================================
</div>
</c:forEach>

</body>
</html>