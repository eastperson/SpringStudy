<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/setPrePath.jspf" %>
<%@ page import="me.ep.domain.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="me.ep.domain.UserVO" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="/css/list.css">
<link rel="stylesheet" href="/css/index.css">
</head>
<body>
<%@ include file="/include/header.jspf" %>
<main class="main_box"> <!-- main -->
        <div class="wrapper_content"> <!-- content wrapper -->
            <div class="content_box"> <!-- content_box 9*9 -->
                <div class="content_cell_a"> <!-- content -->
                    <img class="content_img" src="/img/a.jpg" alt="">
                    <div class="content_text">
                        <h6>비포 선 라이즈</h2>
                        <p>
                        </p>
                    </div>
                </div> 
                <div class="content_cell_b"> 
                    <img class="content_img" src="/img/b.jpg" alt="">
                    <div class="content_text">
                        <h6>비포 선 셋</h2>
                        <p></p>
                    </div>
                </div> 
                <div class="content_cell_c"> 
                    <img class="content_img" src="/img/c.jpg" alt="">
                    <div class="content_text">
                        <h6>비포 미드나잇</h2>
                            <p></p>
                    </div>
                </div> 
                <div class="content_cell_d"> 
                    <img class="content_img" src="/img/d.jpg" alt="">
                    <div class="content_text">
                        <h6>이터널 선샤인</h2>
                            <p></p>
                    </div>
                </div> 
                <div class="content_cell_e"> 
                    <img class="content_img" src="/img/e.jpg" alt="">
                    <div class="content_text">
                        <h6>노팅힐</h2>
                            <p></p>
                    </div>
                </div> 
                <div class="content_cell_f"> 
                    <img class="content_img" src="/img/f.jpg" alt="">
                    <div class="content_text">
                        <h6>미드나잇 인 파리</h2>
                            <p></p>
                    </div>
                </div> 
                <div class="content_cell_g"> 
                    <img class="content_img" src="/img/g.jpg" alt="">
                    <div class="content_text">
                        <h6>어바웃타임</h2>
                        <p></p>
                    </div>
                </div> 
                <div class="content_cell_h"> 
                    <img class="content_img" src="/img/h.jpg" alt="">
                    <div class="content_text">
                        <h6>비긴어게인</h2>
                            <p></p>
                    </div>
                </div> 
                <div class="content_cell_i"> 
                    <img class="content_img" src="/img/i.jpg" alt="">
                    <div class="content_text">
                        <h6>어거스트러쉬</h2>
                            <p></p>
                    </div>
                </div> 
                <!-- content -->
            </div> <!-- end content_box -->
            <div class="nav_bar"> <!-- navigation bar -->
                <div class="nav_bar_content">
                    <h2>ABOUT US</h2></br>
                    <p>자세한 내용을 확인하시려면 콘텐츠를 클릭하세요.</p><br>
                    <p>Contact : 010-2737-5157</p>
                </div>
            </div> <!-- end navigation bar -->
        </div>
    </main> <!-- end main -->
<%@ include file="/include/footer.jspf" %>
</body>
</html>