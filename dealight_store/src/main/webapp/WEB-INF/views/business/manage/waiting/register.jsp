<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ������ ���</title>
</head>
<body>

<h1>Business Waiting Register Page</h1>

<form action="/business/manage/waiting/register?storeId=${storeId}" method="post">

	<label id="custNm">�� �̸�</label>
	<input name="custNm"></br>
	
	<label id="custTelno">�� ����ó</label>
	<input name="custTelno"></br>
	
	<label id="waitPnum">������ �ο�</label>
	<input name="waitPnum"></br>

	<label id="curTime">����ð�</label>
	<input name="curTime" value="${curTime}" hidden>
	<h2>���� �ð� : ${curTime}</h2>
	
	<input name="storeId" value="${storeId}" hidden>

	<button type="submit">�����ϱ�</button>
</form>

</body>
</html>