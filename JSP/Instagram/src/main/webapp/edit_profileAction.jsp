<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>

<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userMessage"/>
<jsp:setProperty name="user" property="userNickname"/>
<jsp:setProperty name="user" property="userPassword" />

<%!
	String userID = null;
%>
<%
	request.setCharacterEncoding("utf-8");
    userID = (String)session.getAttribute("userID");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Instagram</title>
</head>

<body>
	<%
		if (user.getUserMessage() == null || user.getUserPassword() == null || user.getUserNickname() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else {
			UserDAO userDAO = new UserDAO();
			int result = userDAO.edit_profile(user);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원 정보 수정이 완료되었습니다.')");
			script.println("location.href = 'profile.jsp'");
			script.println("</script>");
		}
	%>
</body>
</html>