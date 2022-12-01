package heart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HeartDAO {

	private Connection conn;	//db에 접근하는 객체
	private ResultSet rs;
	
	public HeartDAO() {
			try {// create a mysql database connection
				 String url = "jdbc:mysql://localhost:3306/instagram";
				 Class.forName("com.mysql.jdbc.Driver");
			     conn = DriverManager.getConnection(url, "root", "12345");
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
	}
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ""; //데이터베이스 오류
	}
	public int write(int bbsID, String userID,int likeBbs) {
		String SQL = "INSERT INTO evaluation VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			pstmt.setString(2, userID);
			pstmt.setInt(3, likeBbs);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	public ArrayList<Heart> whereList(int bbsID, String userID){
		String SQL = "SELECT * FROM heart WHERE bbsID = ? AND userID =?"; 
		ArrayList<Heart> list = new ArrayList<Heart>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			pstmt.setString(2, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Heart eva = new Heart();
				eva.setBbsID(rs.getInt(1));
				eva.setUserID(rs.getString(2));
				eva.setLikeBbs(rs.getInt(3));
				list.add(eva);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list; //데이터베이스 오류
	}
	
	public ArrayList<Heart> getList(int bbsID){
		String SQL = "SELECT * FROM heart WHERE bbsID = ?"; 
		ArrayList<Heart> list = new ArrayList<Heart>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Heart eva = new Heart();
				eva.setBbsID(rs.getInt(1));
				eva.setUserID(rs.getString(2));
				eva.setLikeBbs(rs.getInt(3));
				list.add(eva);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list; //데이터베이스 오류
	}
	
	public Heart getEvaluation(int bbsID) {
		String SQL = "SELECT * FROM heart WHERE bbsID = ?";
		ArrayList<Heart>list = new ArrayList<Heart>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  bbsID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Heart eva = new Heart();
				eva.setBbsID(rs.getInt(1));
				eva.setUserID(rs.getString(2));
				eva.setLikeBbs(rs.getInt(3));
				list.add(eva);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int update(int bbsID, String userID,int likeBbs) {
		String SQL = "UPDATE heart SET likeBbs=? WHERE bbsID = ? AND userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, likeBbs);
			pstmt.setInt(2, bbsID);
			pstmt.setString(3, userID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int delete(int bbsID, String userID) {
		String SQL = "DELETE FROM heart WHERE bbsID = ? AND userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			pstmt.setString(2, userID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
}