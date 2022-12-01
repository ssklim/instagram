package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {

	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
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
		return ""; 
	}
	public int getNext() {
		String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 1; 
	}
	
	public int getCount(int boardID) {
		String SQL = "SELECT COUNT(*) FROM bbs WHERE boardID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, boardID);
			rs = pstmt.executeQuery();
			if (rs.next()) {	
				return rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int write(String boardUserID, String bbsTitle, String userID, String bbsContent) {
		String SQL = "INSERT INTO bbs VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, boardUserID);
			pstmt.setInt(2, getNext());
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			pstmt.executeUpdate();
			return getNext();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; 
	}
	

	public ArrayList<Bbs> getList(String boardUserID, int pageNumber){
		String SQL = "SELECT * FROM BBS WHERE boardUserID = ? AND bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10"; 
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, boardUserID);
			pstmt.setInt(2,  getNext() - (pageNumber - 1) * 10);
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
		return list;
	}
	/*
	 검색기능 아직 미완성ㅠ
	public ArrayList<Bbs> searchList(int boardID, int pageNumber, String search){
		String SQL = "SELECT * FROM BBS WHERE boardID = ? AND bbsID < ? AND (bbsTitle like ? OR bbsContent like ? OR map like ?) AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10"; 
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, boardID);
			pstmt.setInt(2,  getNext() - (pageNumber - 1) * 10);
			pstmt.setString(3, "%"+search+"%");
			pstmt.setString(4, "%"+search+"%");
			pstmt.setString(5, "%"+search+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBoardID(rs.getInt(1));
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
		return list;
	}
	*/
	
	public boolean nextPage (String boardUserID, int pageNumber) {
		String SQL = "SELECT * FROM BBS WHERE boardUserID = ? AND bbsID < ? AND bbsAvailable = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, boardUserID);
			pstmt.setInt(2,  getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean searchNextPage (String boardUserID, int pageNumber, String search) {
		String SQL = "SELECT * FROM BBS WHERE boardUserID = ? AND bbsID < ? AND (bbsTitle like ? OR bbsContent like ?) AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10"; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, boardUserID);
			pstmt.setInt(2,  getNext() - (pageNumber - 1) * 10);
			pstmt.setString(3, "%"+search+"%");
			pstmt.setString(4, "%"+search+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Bbs getBbs(int bbsID) {
		String SQL = "SELECT * FROM BBS WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  bbsID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBoardUserID(rs.getString(1));
				bbs.setBbsID(rs.getInt(2));

				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));

				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int bbsID, String bbsTitle, String bbsContent, String map) {
		String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsID LIKE ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);

			pstmt.setInt(3, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(int bbsID) {
		String SQL = "DELETE FROM BBS WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}