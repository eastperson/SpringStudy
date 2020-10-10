package me.ep.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.ep.dao.UserDAO;
import me.ep.domain.UserVO;

class UserDAOTest {



	// 1개의 udao로 테스트를 진행한다.
	static UserDAO udao = UserDAO.getInstance();
	static String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String DB_USER = "student";
	static String DB_PASSWORD = "1234";

	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;


	// 초기 설정
	// 모든 테스트 코드가 시작하기 전에 DB를 연결한다.
	@BeforeAll
	static void initialConnection() {
		try {
			System.out.println("DB 연결");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			udao.setConnection(conn);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// 모든 테스트 코드가 끝나면 DB를 닫는다.
	@AfterAll
	static void finalClose() {
		try {
			conn.close();
			System.out.println("DB 닫기");
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("udao getInstance")
	void UserDAOTest1() {

		System.out.println(udao.getClass());

		// udao가 객체를 잘 가져왔는지 확인
		assertTrue(udao instanceof UserDAO);
	}

	// sql로 받아오는 date 데이터와 java date date데이터와 일치하는지
	@Test
	@DisplayName("udao 날짜 비교하기(yyyy-MM-dd HH:mm:ss)")
	void udaoDateTest1() {

		try {

			String query = "SELECT sysdate FROM dual";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery(query);

			while(rs.next()) {
				String curDate = rs.getString(1);

				System.out.println(curDate);

				Date date = new Date();

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				System.out.println(format.format(date));

				assertTrue(curDate.equals(format.format(date)));

			}	

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// sql로 받아오는 date 데이터와 java date date데이터와 일치하는지
	@Test
	@DisplayName("udao 날짜 비교하기(yyyy-MM-dd HH:mm)")
	void udaoDateTest2() {

		try {

			String query = "SELECT sysdate FROM dual";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery(query);

			while(rs.next()) {
				String curDate = rs.getString(1);
				curDate = curDate.substring(0, curDate.lastIndexOf(":"));

				System.out.println(curDate);

				Date date = new Date();

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

				System.out.println(format.format(date));

				assertTrue(curDate.equals(format.format(date)));

			}	

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	@DisplayName("udao selectUser")
	void udaoSelectUserTest1() {

		UserVO user = udao.selectUser("aaa");

		// user를 잘 가져왔는지
		assertNotNull(user);
		System.out.println(user);

		assertAll(
				() -> assertTrue(user.getId().equals("aaa")),
				() -> assertTrue(user.getPw().equals("1234")),
				() -> assertTrue(user.getName().equals("김동인")),
				() -> assertTrue(user.getEmail().equals("aaa@naver.com")),
				() -> assertTrue(user.getPhoneNum().equals("1027375157")),
				() -> assertTrue(user.getDateOfBirth().toString().equals("2020-10-10"))

				);

	}
	
	@Test
	@DisplayName("udao selectUser 없는 id")
	void udaoSelectUserTest2() {

		UserVO user = udao.selectUser("!!!");

		// user를 잘 가져왔는지
		assertNull(user);
		System.out.println(user);

		

	}

	@Test
	@DisplayName("udao selectAllUSer user 객체 비교")
	void udaoSelectAllUserTest1() {

		List<UserVO> userList = udao.selectAllUsers();

		System.out.println(userList);

		UserVO user = udao.selectUser("abc");

		System.out.println(user);

		// select로 가져온 user와 list로 가져온 user가 같은지 비교
		assertTrue(userList.get(0).equals(user)); 

	}

	@Test
	@DisplayName("udao selectAllUSer 리스트 count 비교")
	void udaoSelectAllUserTest2() {

		List<UserVO> userList = udao.selectAllUsers();

		try {

			String query = "SELECT COUNT(*) from MYBLOG_USER_INFO";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery(query);

			// sql로 확인한 user count와 List로 받은 userList의 크기가 같은지 확인
			while(rs.next()) {
				int userCount = Integer.parseInt(rs.getString(1));
				assertTrue(userCount == userList.size());
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("udao insertUser")
	void udaoInsertUserTest1() {
		
		UserVO user = new UserVO("bbb", "4321", "김경주", "bbb@daum.net", "01033334444", new Date());
		int beforeSize = udao.selectAllUsers().size();
		
		assertTrue(udao.insertUser(user) == 1);

		assertTrue(beforeSize +1 == udao.selectAllUsers().size());
		
		// roll back
		assertTrue(udao.deleteUser(user.getId()) == 1);
		assertTrue(beforeSize == udao.selectAllUsers().size());
	}

	@Test
	@DisplayName("udao deleteUser")
	void udaoDeleteUserTest1() {
		UserVO user = new UserVO("aaa", "1234", "김동인", "aaa@naver.com", "01027375157", new Date());
		
		int beforeSize = udao.selectAllUsers().size();
		
		assertTrue(udao.deleteUser(user.getId()) == 1);
		
		assertTrue(beforeSize -1 == udao.selectAllUsers().size());
		
		// roll back
		assertTrue(udao.insertUser(user) == 1);
		assertTrue(beforeSize == udao.selectAllUsers().size());
	}
	
	@Test
	@DisplayName("udao updateUser")
	void udaoUpdateUserTest1() {
		
		// 테스트 반복을 위해 새로운 user 생성 및 roll back
		UserVO user = new UserVO("ccc", "1234", "김동인", "aaa@naver.com", "01027375157", new Date());

		assertTrue(udao.insertUser(user)==1);

		UserVO tmp = udao.selectUser("ccc");
		
		// insertUser와 생성한 user가 같은지 확인
		assertAll(
				() -> assertTrue(user.getId().equals(tmp.getId())),
				() -> assertTrue(user.getPw().equals(tmp.getPw())),
				() -> assertTrue(user.getName().equals(tmp.getName())),
				() -> assertTrue(user.getEmail().equals(tmp.getEmail()))
		);
		
		// id는 동일하고, 내용을 바꾼 새로운 userVO 생성
		UserVO modifiedUser = new UserVO("ccc", "4321", "이현중", "bbb@naver.com", "01027375157", new Date());
		
		// update
		assertTrue(udao.updateUser(modifiedUser) == 1);
		
		// update가 완료되었는지 확인하기 위해 동일 id user select
		UserVO selectedUser = udao.selectUser("ccc"); 
		
		// 변경된 user가 맞는지 비교
		assertAll(
				() -> assertTrue(modifiedUser.getId().equals(selectedUser.getId())),
				() -> assertTrue(modifiedUser.getPw().equals(selectedUser.getPw())),
				() -> assertTrue(modifiedUser.getName().equals(selectedUser.getName())),
				() -> assertTrue(modifiedUser.getEmail().equals(selectedUser.getEmail()))
		);
		
		// roll back
		// 삽입된 id의 유저 삭제
		assertTrue(udao.deleteUser(user.getId()) == 1);
		
		
	}
}
