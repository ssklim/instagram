package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FollowDAO {

	private Connection conn;
	private ResultSet rs;
	
	public FollowDAO() {
			try {// create a mysql database connection
				 String url = "jdbc:mysql://localhost:3306/instagram";
				 Class.forName("com.mysql.jdbc.Driver");
			     conn = DriverManager.getConnection(url, "root", "12345");
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		}
	
	public ArrayList<Bbs> getList(String followingID, int pageNumber){
		String SQL = "SELECT * FROM BBS WHERE boardUserID = (select boardUserID from follow where followingID = ?) ORDER BY bbsID DESC LIMIT 10"; 
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, followingID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBoardUserID(rs.getString(1));
				bbs.setBbsID(rs.getInt(2));

				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));

				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list; //db오류
	}

	
	public int write(String followerID, String followingID) {
		String SQL = "INSERT INTO follow VALUES(?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, followingID);
			pstmt.setString(2, followerID);
			pstmt.executeUpdate();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //db오류
	}
	
	public ArrayList<Follow> getFollow(String followerID, String followingID) {
		String SQL = "SELECT * FROM follow WHERE userID = ? AND boardID = ?";
		ArrayList<Follow> list = new ArrayList<Follow>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  followingID);
			pstmt.setString(2,  followerID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Follow follow = new Follow();
				follow.setFollowingID(rs.getString(1));
				follow.setFollowerID(rs.getString(2));
				list.add(follow);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int delete(String followerID,String followingID) {
		String SQL = "DELETE FROM follow WHERE followingID = ? AND followerID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, followingID);
			pstmt.setString(2, followerID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // db오류
	}
}