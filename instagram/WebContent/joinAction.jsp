<%@page import="java.io.PrintWriter"%>
<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="user_id" />
<jsp:setProperty name="user" property="password" />
<jsp:setProperty name="user" property="name" />
<jsp:setProperty name="user" property="phone_num" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>instagram</title>
</head>
<body>
	<%
	//현재 세션상태 체크
		String user_id = null;
		if(session.getAttribute("user_id") != null){
			user_id = (String)session.getAttribute("user_id");
		}
		//이미 로그인되어있으면 다시 로그인 하지못하게
		if(user_id != null){
			PrintWriter script = response.getWriter();
			script.println("</script>");
			script.println("alert('이미 로그인이 되어 있습니다')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
		
		if(user.getUser_id() == null || user.getPassword() == null || user.getName() == null || user.getPhone_num() == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다')");
			script.println("history.back()");
			script.println("</script>");
		}else{
			UserDAO userDAO = new UserDAO();
			int result = userDAO.join(user);
			if(result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디입니다')");
				script.println("history.back()");
				script.println("</script>");
			}else {
				session.setAttribute("user_id", user.getUser_id());
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원가입 성공')");
				script.println("location.href='main.jsp'");
				script.println("</script>");
			}
		}
	%>
</body>
</html>