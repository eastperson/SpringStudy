<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Blog</title>
<link rel="stylesheet" href="/resources/css/index.css?ver=1" type="text/css">
<%@ include file="/WEB-INF/views/include/setPrePath.jspf" %>
<%@ include file="/WEB-INF/views/include/getMsg.jspf" %>
<%@ include file="/WEB-INF/views/include/getId.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jspf" %>
    <div class="flexbox_row"> <!-- flex box row -->
    <main id="main_box" class="flexbox_column1"> <!-- main_box -->
        <div id="content_wrapper"> <!-- content wrapper -->
            <div class="login_box">
                <form action="/users/login" method="POST" id="login_form">
                    <div class="input_box">
                        <label for="user_id">아이디</label><br/>
                        <input type="text" id="user_id" name="id"><br>
                        <label for="user_pw">비밀번호</label><br/>
                        <input type="password" id="user_pw" name="pw"><br>
                        <input type="hidden" id="prepath" value=<%=prePath %>>
                    </div>
                    <div class="button_box"> <!-- button_box -->
                        <button id="btn_login" type="submit">LOGIN NOW</button>
                        <button id="btn_join" href="/users/register">JOIN NOW</button>
                    </div> <!-- end button_box -->
                </form><!-- end form -->
                <%=msg %><br/>
                <%=id %>
            </div> <!-- end login_box -->
            <div class="imagebox">
                <div class="imagebox_image"><img src="https://via.placeholder.com/200x200" alt=""></div>
                <div class="imagebox_content">                
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                </div>
            </div>
        </div> <!-- end content wrapper -->
    </main><!-- end main box -->
    <nav id="side_box" class="flexbox_column2"> <!-- side box -->
        <span>광고 영역</span>
        <div id="side_wrapper" class="side_flexcolumn"><!-- side wrapper -->
            <ul id="ad_box">
                <a href="#"><div class="side_flexrow"><li>ad1</li></div></a>
                <a href="#"><div class="side_flexrow"><li>ad2</li></div></a>
                <a href="#"><div class="side_flexrow"><li>ad3</li></div></a>
            </ul>
        </div> <!-- end side wrapper -->
    </nav> <!-- end side box -->
</div> <!-- end flex box row -->
<%@ include file="/WEB-INF/views/include/footer.jspf" %>
<script type="text/javascript" src="/resources/js/loginBtn.js?ver=1"></script>
</body>
</html>