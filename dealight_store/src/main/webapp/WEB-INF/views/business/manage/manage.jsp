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

<h1>Business Manage Main Page</h1>

<h1><a href="/business/manage/dealhistory?storeId=${storeId}">Deal History</a></h1>


<p><fmt:formatDate pattern="yyyy-MM-dd" value="${today}" /></p>

<p>���� ������ ���� : ${nextRsvd}</p>
<p>������ ��Ȳ  : ${waitList }</p>
<p>�������� : ${store}</p>
<p>���� ����Ʈ : ${rsvdList }</p>
<p>�ð��뺰 ������ ��Ȳ : ${todayRsvdMap }</p>
-------
<p>���� ���� �� : ${totalTodayRsvd }</p>
<p>���� ���� �ο� �� : ${totalTodayRsvdPnum}</p>
<p>���� ��ȣ �޴� �� : ${todayFavMenuMap }</p>
<p>���� ������ ����Ʈ : ${todayRsvdUserList}</p>
</body>
</html>