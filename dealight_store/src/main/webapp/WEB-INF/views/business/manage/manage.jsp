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

<h1>Business Manage Main Page</h1>

<h1><a href="/business/manage/dealhistory?storeId=${storeId}">Deal History</a></h1>


<p>���� ��¥ : <fmt:formatDate pattern="yyyy-MM-dd" value="${today}" /></p>
<p>���� �ð� : <fmt:formatDate pattern="HH:mm:ss" value="${today}" /></p>

<p>���� ���� ���� : ${nextRsvd}</p>

<p>���� ������ ���� : ${nextWait}</p>
<a href="/business/manage/enter?waitId=${nextWait.id}&storeId=${storeId}">����</a> </br>
<a href="/business/manage/noshow?waitId=${nextWait.id}&storeId=${storeId}">���</a>

<p>���� ���� ���� ���� : ${store.bstore.seatStusCd}</p>

<p><a href="/business/manage/waiting/register?storeId=${storeId}">�������� ������ ���</a></p>

<p><a href="/business/manage/modify?storeId=${storeId}">���� ���� ����</a></p>

<h2>������ ����Ʈ</h2>

<c:if test="${not empty waitList}">

<c:forEach items="${waitList}" var="wait">
<a href="/business/manage/waiting?waitId=${wait.id}"><div>
������ ��ȣ : ${wait.id}
���� ��ȣ : ${wait.storeId}
ȸ�� ���̵� : ${wait.userId}
������ �����ð� : ${wait.waitRegTm}
������ �ο� = ${wait.waitPnum}
�� ����ó = ${wait.custTelno }
�� �̸� = ${wait.custNm }
������ ���� = ${wait.waitStusCd}
</div>
</a>
</c:forEach>
</c:if>
 

<p>�������� : ${store}</p>


<h2>���ฮ��Ʈ</h2>
<c:if test="${not empty rsvdList}">
<c:forEach items="${rsvdList}" var="rsvd">
<a href="/business/manage/reservation?rsvdId=${rsvd.id}"><div>
=====================================
���� ��ȣ: ${rsvd.id}
���� ��ȣ: ${rsvd.storeId}
���� ȸ�� ���̵�: ${rsvd.userId}
�ֵ� ��ȣ: ${rsvd.htdlId}
���� ��ȣ: ${rsvd.aprvNo}
���� �ο�: ${rsvd.pnum}
���� �ð�: ${rsvd.time}
���� ����: ${rsvd.stusCd}
���� �� �ݾ�: ${rsvd.totAmt}
���� �� ����: ${rsvd.totQty}
���� �ۼ� ��¥: ${rsvd.inDate}
=====================================
</div>
</a>
</c:forEach>
</c:if>

<p>�ð��뺰 ������ ��Ȳ : ${todayRsvdMap }</p>
-------
<p>���� ���� �� : ${totalTodayRsvd }</p>
<p>���� ���� �ο� �� : ${totalTodayRsvdPnum}</p>
<p>���� ��ȣ �޴� �� : ${todayFavMenuMap }</p>

<h2>���� ���� ȸ��</h2>
<c:if test="${not empty todayRsvdUserList}">
<c:forEach items="${todayRsvdUserList}" var="user">
<div>
==========================================
ȸ�� ���̵� : ${userId}
ȸ�� �̸� : ${name}
ȸ�� �̸��� : ${email}
ȸ�� ��ȭ��ȣ : ${telno}
���� ���� : ${brdt}
���� : ${sex }
ȸ�� ������ ���� : ${photoSrc}
�г�Ƽ ȸ�� ���� : ${pmStus}
==========================================
</div>
</c:forEach>
</c:if>
 
</body>
</html>