<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instagram</title>
</head>
<body>
	<%
		// 세션 값 초기화하기
		session.invalidate();
	%>
	
	<script>
		alert('로그아웃 되었습니다.');
		location.href="login.jsp";
	</script>
</body>
</html>