<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link href="css/edit_profile.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="img/favicon.png">
    <link rel="instagram-icon" href="img/favicon.png">
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
	%>
	<nav>
    Servlet.serviceJspFile(JspServlet.java:383)
    org.apache.jasper.servlet.J  <div class="nav-container">
        <div class="nav-1">
            <img class="logo_instagram_txt" src="img/brand_logo.png" alt="logo_text">
        </div>
        <input id="searchInput" type="search" class="input-search" placeholder="검색">
      	<div class="nav-2"></div>
      </div>
    </nav>
    <main>
    <div class="edit_profile">
    	<div class="edit_profile_box">
        	<form action="edit_profileAction.jsp" method="post">

<!-- 		        <span class="text">ID</span>&ensp;<input type="text" class="input_login" name="userID" id="userID" placeholder="전화번호 또는 이메일"><br> -->
		        <span class="text">사용자 이름</span>&ensp;<input type="text" class="input_login" name="userNickname" id="userNickname" placeholder="사용자 이름"><br>
		        &emsp;
		        <span class="text">패스워드</span> <input type="text" class="input_login" name="userPassword" id="userPW" placeholder="비밀번호"><br>
		        &emsp;
		        <span class="text">소개 문구</span><input type="text" name="userMessage" class="input_login" id="userMessage" placeholder="소개 문구">
        		<a href="#none"><button class="btn_edit">회원정보 수정</button></a>
        	</form>
        </div>
    </div>
    </main>
    <script src="js/edit_profile.js"></script>
</body>
</html>