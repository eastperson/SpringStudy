<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>채팅방 목록</h1>
<ul>
    {{#rooms}}
    <li><a href="/chat/rooms/{{id}}">{{name}}</a></li>
    {{/rooms}}
</ul>

</body>
</html>