<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="follow.FollowDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="follow" class="follow.Follow" scope="page" />
<jsp:setProperty name="follow" property="followerID" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Instagram</title>
</head>

<body>
	<%
		// 로그인을 한 사람만 팔로우를 할 수 있도록 하는 코드
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
		if(userID == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		} else {
			FollowDAO followDAO = new FollowDAO();
			int search = followDAO.Search(follow);
			
			if (search == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('검색한 사용자가 없습니다.')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('팔로우 완료')");
				script.println("history.back()");
				script.println("</script>");
			}
			
		}
	%>
</body>
</html>