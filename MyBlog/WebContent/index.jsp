<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/setPrePath.jspf" %>
<%@ include file="/include/getMsg.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Blog</title>
<link rel="stylesheet" href="/css/index.css" type="text/css">
</head>
<%
String id = "";
if(request.getSession().getAttribute("id") != null)
	id = (String) request.getSession().getAttribute("id");
%>
<body>
<%@ include file="/include/header.jspf" %>
    <div class="flexbox_row"> <!-- flex box row -->
    <main id="main_box" class="flexbox_column1"> <!-- main_box -->
        <div id="content_wrapper"> <!-- content wrapper -->
            <div class="login_box">
                <form action="/LoginAction" method="POST" id="login_form">
                    <div class="input_box">
                        <label for="user_id">아이디</label><br/>
                        <input type="text" id="user_id" name="user_id"><br>
                        <label for="user_pw">비밀번호</label><br/>
                        <input type="password" id="user_pw" name="user_pw"><br>
                        <input type="hidden" id="prepath" value=<%=prePath %>>
                    </div>
                    <div class="button_box"> <!-- button_box -->
                        <button id="login_btn" type="submit">LOGIN NOW</button>
                        <button id="join_btn" type="submit">JOIN NOW</button>
                    </div> <!-- end button_box -->
                </form><!-- end form -->
                <h1><%=msg %></h1>
                <h1><%=id %></h1>
            </div> <!-- end login_box -->
            <div class="imagebox">
                <div class="imagebox_image"><img src="https://via.placeholder.com/200x200" alt=""></div>
                <div class="imagebox_content"> 6                  
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                </div>
            </div>
        </div> <!-- end content wrapper -->
    </main><!-- end main box -->
    <nav id="side_box" class="flexbox_column2"> <!-- side box -->
        <span>*광고 영역 입니다</span>
        <div id="side_wrapper" class="side_flexcolumn"><!-- side wrapper -->
            <ul id="ad_box">
                <a href="#"><div class="side_flexrow"><li>ad1</li></div></a>
                <a href="#"><div class="side_flexrow"><li>ad2</li></div></a>
                <a href="#"><div class="side_flexrow"><li>ad3</li></div></a>
            </ul>
        </div> <!-- end side wrapper -->
    </nav> <!-- end side box -->
</div> <!-- end flex box row -->
<%@ include file="/include/footer.jspf" %>
<script type="text/javascript" src="/js/loginBtn.js"></script>
</body>
</html>