<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http=equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Instagram_회원가입</title>
<link rel="stylesheet" href="css/join.css">
</head>
<body>
	<div class="join-container">
		<header class="logo">
			<img class="brand-logo" src="img/logo_text.png" alt="logo">
			<ul>
				<li>친구들의 사진과 동영상을 보려면</li>
				<li>가입하세요.</li>
			</ul>
		</header>
		<div class="or_line">
			<div class="line"></div>
			<div class="text">또는</div>
			<div class="line"></div>
		</div>
			<form name="join" action="" method="post">
				<input class="addEmail" type="text" placeholder="휴대폰 번호 또는 이메일 주소">
				<input class="name" type="text" placeholder="성명">
				<input class="id" type="text" placeholder="사용자 이름">
				<input class="pwd" type="password" placeholder="비밀번호">
				<button class="joinBtn" type="button"><a href="#">가입</a></button>
			</form>
	</div>
		<div class="account_login">
			<ul>
				<li>계정이 있으신가요?</li>
				<li><a href="login.jsp">로그인</a></li>
			</ul>
		</div>
	<script src="js/join.js"></script>
</body>
</html>