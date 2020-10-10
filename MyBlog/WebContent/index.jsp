<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/getPrePath.jspf" %>
<%@ include file="/include/getMsg.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
                <h1><%=msg %></h1>
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