<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*" %>

<%!
	String userID = null;
	String query = null;
	String id = null;
	String pw = null;
	String name = null;
	String nick = null;
	String message = null;
%>
<%
	request.setCharacterEncoding("utf-8");

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    userID = (String)session.getAttribute("userID");
    
    // JDBC driver loading
    try {
    	String url="jdbc:mysql://localhost/instagram";
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection(url, "root" , "0000" );
    	
    	stmt = conn.createStatement();
    	query = "SELECT * FROM instagram.user WHERE userID = " + userID;
    	rs = stmt.executeQuery(query);
    	
    	while(rs.next()) {
    		id = (String)rs.getString("userID");
    		pw = rs.getString("userPassword");
    		name = (String)rs.getString("userName");
    		nick = rs.getString("userNickname");
    		message = rs.getString("userMessage");
    	}
    } catch (Exception e) {
    	e.printStackTrace();
    } finally {
    	if (rs != null) {
    		try {
    			rs.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	if (stmt != null) {
    		try {
    			stmt.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	if (conn != null) {
    		try {
    			conn.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>Instagram</title>
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <!-- favicon -->
    <link rel="icon" href="img/favicon.png">
    <link rel="instagram-icon" href="img/favicon.png">
</head>

<body>
    <!-- navigation -->
    <nav>
        <div class="nav-container">
            <div class="nav-1">
                <a href="logout.jsp"><img class="logo_instagram_txt" src="img/brand_logo.png" alt="logo_text"></a>
            </div>
            
            <!-- /////////////////  이 부분 수정했습니다  ///////////////// -->
            <form action="searchAction.jsp" method="post">
	            <input name="searchInput" id="searchInput" type="search" class="input-search" placeholder="검색">
            </form>
            <!-- ///////////////// ///////////////// ///////////////// -->
            
            <div class="nav-2">
                <a href="profile.jsp"><img class="logo_instagram_txt" src="img/human.png" alt="profilet"></a>
            </div>
        </div>
    </nav>
    <!-- main -->
    <main>
        <div class="feeds">
            <!-- article -->
            <article>
                <header>
                    <div class="profile-of-article">
                        <img class="img-profile pic" src="img/favicon.png" alt="사진">
                        <span class="userID main-id point-span">board</span>
                    </div>
                    <img class="icon-react icon-more" src="img/more.png" alt="more">
                </header>
                <div class="icons-react">
                    <div class="icons-left">
                        <img class="icon-react" src="img/heart.png" alt="하트">
                        <img class="icon-react" src="img/comment.png" alt="말풍선">
                        <img class="icon-react" src="img/dm.png" alt="DM">
                    </div>
                    <img class="icon-react" src="img/bookmark.png" alt="북마크">
                </div>
                <!-- article text data -->
                <div class="reaction">
                    <div class="liked-people">
                        <img class="pic" src="img/favicon.png" alt="johnnyjsuh님의 프로필 사진">
                        <p><span class="point-span">like</span>님 <span class="point-span">외 2,412,751명</span>이
                            좋아합니다</p>
                    </div>
                    <div class="description">
                        <p><span class="point-span userID">board</span> 🌱</p>
                    </div>
                    <span class="sub-span">
                        댓글 4개 모두 보기
                    </span>
                    <div class="comment-section">
                        <ul class="comments">
                            <li>
                                <span><span class="point-span userID">comment</span>댓글 기능 구현</span>
                                <div>
                                    <img class="comment-more" src="img/more.png" alt="more">
                                    <div class="comment-like">
                                        <img class="comment-heart" src="img/heart.png" alt="하트">
                                        <img class="comment-heart-liked" src="img/liked.png" alt="좋아요된하트">
                                    </div>
                                </div>
                            </li>
                            <!-- input 값 여기에 추가 -->
                        </ul>
                        <div class="time-log">
                            <span>32분 전</span>
                        </div>
                    </div>
                </div>
                <div class="hl"></div>
                <div class="comment">
                    <input id="input-comment" class="input-comment" type="text" placeholder="댓글 달기...">
                    <button type="submit" class="submit-comment" disabled>게시</button>
                </div>
            </article>
            <article>
                <header>
                    <div class="profile-of-article">
                        <img class="img-profile pic" src="img/favicon.png" alt="thisisyourhyung님의 프로필 사진">
                        <span class="userID main-id point-span">thisisyourhyung</span>
                    </div>
                    <img class="icon-react icon-more" src="img/more.png" alt="more">
                </header>

                <div class="icons-react">
                    <div class="icons-left">
                        <img class="icon-react" src="img/heart.png" alt="하트">
                        <img class="icon-react" src="img/comment.png" alt="말풍선">
                        <img class="icon-react" src="img/dm.png" alt="DM">
                    </div>
                    <img class="icon-react" src="img/bookmark.png" alt="북마크">
                </div>
                <!-- article text data -->
                <div class="reaction">
                    <div class="liked-people">
                        <img class="pic" src="img/favicon.png" alt="_jeongjaehyun님의 프로필 사진">
                        <p><span class="point-span">_jeongjaehyun</span>님 <span class="point-span">외 4,612,203명</span>이
                            좋아합니다</p>
                    </div>
                    <div class="description">
                        <p><span class="point-span userID">thisisyourhyung</span>코로나 언제 사라지나 ㅠㅠ 여행 가고 싶다~~</p>
                    </div>
                    <span class="sub-span">
                        댓글 4개 모두 보기
                    </span>
                    <div class="comment-section">
                        <ul class="comments">
                            <li>
                                <span><span class="point-span userID">williamhammington</span>나도 호주 가고 싶다!</span>
                                <div>
                                    <img class="comment-more" src="img/more.png" alt="more">
                                    <div class="comment-like">
                                        <img class="comment-heart" src="img/heart.png" alt="하트">
                                        <img class="comment-heart-liked" src="img/liked.png" alt="좋아요된하트">
                                    </div>
                                </div>
                            </li>
                            <!-- input 값 여기에 추가 -->
                        </ul>
                        <div class="time-log">
                            <span>1시간 전</span>
                        </div>
                    </div>
                </div>
                <div class="hl"></div>
                <div class="comment">
                    <input id="input-comment2" class="input-comment" type="text" placeholder="댓글 달기...">
                    <button type="submit" class="submit-comment" disabled>게시</button>
                </div>
            </article>

        </div>
        <!-- main-right -->
        
        <div class="main-right">
            <div class="myProfile">
                <img class="pic" src="img/profile1.png" alt="thisisyourhyung님의 프로필 사진">
                <div>
                    <span class="userID point-span">
                        <%= nick %>
                    </span>
                    <span class="sub-span">
                        <%= name %>
                    </span>
                </div>
            </div>
        </div>
    </main>
    <script src="js/main.js"></script>
</body>

</html>