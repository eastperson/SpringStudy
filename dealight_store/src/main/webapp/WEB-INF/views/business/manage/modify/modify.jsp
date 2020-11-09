<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����</title>
</head>
<body>

<h1>Business Modify Page</h1>

${msg}

<form action="/business/manage/modify" method="post">

	<label id="storeNm">�����</label>
	<input name="storeNm" value="${store.storeNm}"></br>
	
	<label id="telno">��ȭ��ȣ</label>
	<input name="telno" value="${store.telno}"></br>
	
	<input name="buserId" value="${userId}" type="hidden">
	
	<label id="openTm">���۽ð�</label>
	<input name="openTm" value="${store.bstore.openTm}"></br>
	
	<label id="closeTm">�����ð�</label>
	<input name="closeTm" value="${store.bstore.closeTm}"></br>
	
	<label id="buserId">����� ȸ�� ���̵�</label>
	<input name="buserId" value="${store.bstore.buserId}" readonly></br>
	
	<label id="breakSttm">�극��ũŸ�ӽ��۽ð�</label>
	<input name="breakSttm" value="${store.bstore.breakSttm}"></br>
	
	<label id="breakEntm">�극��ũŸ�Ӹ����ð�</label>
	<input name="breakEntm" value="${store.bstore.breakEntm}"></br>
	
	<label id="lastOrdTm">��Ʈ���� �ð�</label>
	<input name="lastOrdTm" value="${store.bstore.lastOrdTm}"></br>
	
	<label id="n1SeatNo">1�� ���̺� ����</label>
	<input name="n1SeatNo" value="${store.bstore.n1SeatNo}"></br>
	
	<label id="n2SeatNo">2�� ���̺� ����</label>
	<input name="n2SeatNo" value="${store.bstore.n2SeatNo}"></br>
	
	<label id="n4SeatNo">4�� ���̺� ����</label>
	<input name="n4SeatNo" value="${store.bstore.n4SeatNo}"></br>
	
	<label id="storeIntro">����Ұ�</label>
	<input name="storeIntro" value="${store.bstore.storeIntro}"></br>
	
	<label id="avgMealTm">������սĻ�ð�</label>
	<input name="avgMealTm" value="${store.bstore.avgMealTm}" readonly></br>
	
	<label id="hldy">�����޹���</label>
	<input name="hldy" value="${store.bstore.hldy}"></br>
	
	<label id="acmPnum">��������ο�</label>
	<input name="acmPnum" value="${store.bstore.acmPnum}"></br>
	
	<input name="storeId" value="${storeId}" hidden>
	
	<button type="submit">�����ϱ�</button>
</form>

<h2><a href="/business/manage/menu?storeId=${store.storeId}" }>�޴�����</a></h2>

</body>
</html>