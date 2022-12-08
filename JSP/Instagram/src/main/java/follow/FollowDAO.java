package follow;

import java.sql.*;
import javax.servlet.http.*;

public class FollowDAO {
	
	private Connection conn;	//db에 접근하는 객체
	private ResultSet rs;
	PreparedStatement pstmt;

	HttpSession session;
	String followingID = (String)session.getAttribute("userID");
	
	public FollowDAO() {
			try {// create a mysql database connection
				 String url = "jdbc:mysql://localhost/instagram";
				 Class.forName("com.mysql.jdbc.Driver");
			     conn = DriverManager.getConnection(url, "root", "0000");
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
	}
	
	public int Search(Follow follow) {
		String sql = "INSERT INTO follow (followerID, followingID) VALUES (?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, follow.getFollowerID());
			pstmt.setString(2, followingID);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;	// DB error
	}
}
