package user;

import java.sql.*;
import java.util.*;

public class UserDAO {
	private String user_id;
	private String password;
	private String name;
	private String phone_num;
	
	private Connection conn;
	private ResultSet rs;
	
	public UserDAO() {
		 try {// create a mysql database connection
			 String url = "jdbc:mysql://localhost:3306/instagram";
			 Class.forName("com.mysql.jdbc.Driver");
		     conn = DriverManager.getConnection(url, "root", "12345");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	//로그인
	//-2 : 데이터베이스 오류
	//-1 : 아이디 없음
	//0  : 비밀번호 불일치
	//1  : 로그인 성공
	
	public int login(String user_id, String password) {
		try {
			 PreparedStatement pst = conn.prepareStatement("SELECT password FROM user Where user_id = ?");
			 pst.setString(1,user_id);
			 rs = pst.executeQuery();
			 if(rs.next()) {
				 if(rs.getString(1).equals(password)) {
					 return 1;//로그인 성공
				 }
				 else {
					 return 0;//비밀번호 불일치				
					 }
			 }else {
				 return -1;//아이디 없음
			 }
		}catch(Exception e) {
				 e.printStackTrace();
				 return -2;//데이터베이스 오류
			 }
		}
	public boolean ID_check(String user_id) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM user WHERE user_id = ?");
			pst.setString(1, user_id);
			rs = pst.executeQuery();
			if (rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 회원가입
	/*
	 -1: 서버오류
	  0: 이미 존재하는 아이디
	  1: 성공
	 */
	public int join(User user) {
		
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT into user values (?,?,?,?)");
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getName());
			pst.setString(4, user.getPhone_num());
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//유저 데이터 가져오기
		public UserDAO getUser(String user_id) {
			try {
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM user WHERE user_id = ?");
				pst.setString(1, user_id);
				rs = pst.executeQuery();
				if (rs.next()) {
					UserDAO userDAO = new UserDAO();
					userDAO.setUser_id(rs.getString(1));
					userDAO.setPassword(rs.getString(2));
					userDAO.setName(rs.getString(3));
					userDAO.setPhone_num(rs.getString(4));
					return userDAO;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getUserPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone_num() {
			return phone_num;
		}
		public void setPhone_num(String phone_num) {
			this.phone_num = phone_num;
		}
	}