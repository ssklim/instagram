<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Instagram</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="container">
        <img class="logo_instagram" src="img/logo_text.png" alt="instagram_logo">
        	<form action="loginAction.jsp" method="post">
		        <input type="text" class="input_login" name="userID" id="userID" placeholder="전화번호, 사용자 이름 또는 이메일">
		        <input type="password" class="input_login" name="userPassword" id="userPW" placeholder="비밀번호">
		        <a href="#none"><button id="btn_login" disabled>로그인</button></a>
        	</form>
        <span class="button_join"><a href="join.jsp">회원가입</a></span>
    </div>
    <script src="js/login.js"></script>
</body>
</html>