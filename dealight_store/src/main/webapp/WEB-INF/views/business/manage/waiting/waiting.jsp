<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>웨이팅 상세</title>
</head>
<body>

<h1>Business Waiting Page</h1>

<h5>웨이팅 번호 : ${wait.id}</h5>
<h5>매장 번호 : ${wait.storeId}</h5>
<h5>회원 아이디 : ${wait.userId}</h5>
<h5>웨이팅 접수시간 : ${wait.waitRegTm}</h5>
<h5>웨이팅 인원 : ${wait.waitPnum}</h5>
<h5>웨이팅 고객 연락처 : ${wait.custTelno}</h5>
<h5>웨이팅 고객 이름 : ${wait.custNm}</h5>
<h5>웨이팅 상태 : ${wait.waitStusCd}</h5>
<h5>웨이팅 등록 날짜 : ${wait.inDate}</h5>

</body>
</html>