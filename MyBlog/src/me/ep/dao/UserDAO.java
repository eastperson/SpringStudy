package me.ep.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import me.ep.domain.UserVO;

public class UserDAO extends DAO {
	static UserDAO USER_DAO;


	public static UserDAO getInstance() {

		if(USER_DAO == null) {
			System.out.println("dao 생성");
			USER_DAO = new UserDAO();
		}

		return USER_DAO;
	}

	public UserDAO(){}

	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public static int insertUser(UserVO u) {
		
		try {
			
		String query = "INSERT into MYBLOG_USER_INFO values (?,?,?,?,?,?,SYSDATE,SYSDATE)";

		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, u.getId());
		pstmt.setString(2, u.getPw());
		pstmt.setString(3, u.getName());
		pstmt.setString(4, u.getEmail());
		pstmt.setString(5, u.getPhoneNum());
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		pstmt.setString(6, format.format(u.getDateOfBirth()));

		return pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int updateUser(UserVO u){

		String query = "UPDATE MYBLOG_USER_INFO SET USER_PW = (?), name = (?), email = (?), PHONENUM = (?), DATEOFBIRTH = (?) where USER_ID = (?) ";
		
		try {
			
		pstmt = conn.prepareStatement(query);

		pstmt.setString(1, u.getPw());
		pstmt.setString(2, u.getName());
		pstmt.setString(3, u.getEmail());
		pstmt.setString(4, u.getPhoneNum());
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		pstmt.setString(5, format.format(u.getDateOfBirth()));
		pstmt.setString(6, u.getId());

		return pstmt.executeUpdate(); 	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static UserVO selectUser(String userId) {
		try {
			UserVO u2 = null;

			String query = "SELECT * from MYBLOG_USER_INFO where USER_ID = '" + userId +"'";


			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery(query);



			while(rs.next()) {
				u2 = new UserVO(userId, rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getDate(8));
			}
			return u2;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int deleteUser(String userId) {
		
		String query = "DELETE from MYBLOG_USER_INFO where user_id = '" + userId +"'";
		
		try {
		
		pstmt = conn.prepareStatement(query); // Statement를 가져온다.

		return pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static List<UserVO> selectAllUsers() {
		
		List<UserVO> list = new ArrayList<>();

		String query = "SELECT * from MYBLOG_USER_INFO";
		
		try {
		
		pstmt = conn.prepareStatement(query); // Statement를 가져온다.

		rs = pstmt.executeQuery(query);

		while(rs.next()) {
			list.add(new UserVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getDate(8)));

		}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
