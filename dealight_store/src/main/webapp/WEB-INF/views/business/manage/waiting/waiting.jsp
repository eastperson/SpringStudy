<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ��</title>
</head>
<body>

<h1>Business Waiting Page</h1>

<h5>������ ��ȣ : ${wait.id}</h5>
<h5>���� ��ȣ : ${wait.storeId}</h5>
<h5>ȸ�� ���̵� : ${wait.userId}</h5>
<h5>������ �����ð� : ${wait.waitRegTm}</h5>
<h5>������ �ο� : ${wait.waitPnum}</h5>
<h5>������ �� ����ó : ${wait.custTelno}</h5>
<h5>������ �� �̸� : ${wait.custNm}</h5>
<h5>������ ���� : ${wait.waitStusCd}</h5>
<h5>������ ��� ��¥ : ${wait.inDate}</h5>

</body>
</html>