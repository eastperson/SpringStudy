<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
</head>
<body>

<h1>Business Store Register Form</h1>
<form action="/business/register" method="post">

	<label id="storeNm">�����</label>
	<input name="storeNm"></br>
	
	<label id="telno">��ȭ��ȣ</label>
	<input name="telno"></br>
	
	<input name="buserId" value="${userId}" type="hidden">
	
	<label id="openTm">���۽ð�</label>
	<input name="openTm"></br>
	
	<label id="closeTm">�����ð�</label>
	<input name="closeTm"></br>
	
	<button type="submit">�����ϱ�</button>
</form>
</body>
</html>