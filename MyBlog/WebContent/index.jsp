<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/setPrePath.jspf" %>
<%@ include file="/include/getMsg.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="/webapp/css/index.css" type="text/css">
</head>
<%
String id = "";
if(request.getSession().getAttribute("id") != null)
	id = (String) request.getSession().getAttribute("id");

%>
<body>
<%@ include file="/include/header.jspf" %>
            <div class="login_box">
                <form action="/LoginAction" method="POST" id="login_form">
                    <label for="user_id"">아이디</label>
                    <input type="text" id="user_id" name="user_id" required><br>
                    
                    <label for=""user_pw">비밀번호</label>
                    <input type="password" id="user_pw" name="user_pw" required><br>
                    
                    <input type="hidden" id="prepath" value="">
                    <button id="login_btn" type="submit" class="btn_submit">LOGIN NOW</button>
                    <button id="join_btn" type="submit" class="btn_join">JOIN NOW</button>
                </form>
                <a href="/views/board/list.jsp">리스트</a>
                <a href="/LogoutAction">로그아웃</a>
                <h1><%=msg %></h1>
                <h1><%=id %></h1>
            </div>
            <script>
            	window.onload = function() {
            		const loginForm = document.querySelector("#login_form"),
            			inputList = document.querySelectorAll("input"),
                    	btn_submit = document.querySelector(".btn_submit"),
                    	btn_join = document.querySelector(".btn_join");
            		
            		btn_submit.addEventListener("click", (e) => {

            	            e.preventDefault();

            	            console.log("submit 성공");
            	            loginForm.submit();
            	     })
            	     
            	     btn_join.addEventListener("click", (e) => {

            	            e.preventDefault();
            	            
            	            console.log("submit 성공");
            	            location.replace("/views/registerForm.jsp");
            	     });
            		
            	}
            </script>
</body>
</html>