package me.ep.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.ep.domain.UserVO;

public class UserVOTest {
	
	UserVO user;
	
	// 정상적인 셋팅
	String id = "abcdf";
	String pw = "123123";
	String name = "kim";
	String email = "abc@naver.com";
	String phoneNum = "010-2737-5157";
	Date dateOfBirth = new Date();
	
	@Test
	@DisplayName("UserVO 생성 테스트")
	void newUserVOTest() {
		
		user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth);
		
		// user 객체가 잘 생성되었는지 확인한다.
		assertNotNull(user);
		
		// user 객체에 들어간 iv가 인자값과 동일한지 확인해본다.
		assertAll(
				()->assertTrue(user.getId().equals(id)),
				()->assertTrue(user.getPw().equals(pw)),
				()->assertTrue(user.getName().equals(name)),
				()->assertTrue(user.getEmail().equals(email)),
				()->assertTrue(user.getPhoneNum().equals(phoneNum)),
				()->assertTrue(user.getDateOfBirth().equals(dateOfBirth))
		);
	}
	
	@Test
	@DisplayName("UserVO 생성 조건 예외 테스트(ID)")
	void newUserVOExceptionTest1() {

		//"ID는 10자 이하의 글자로만 저장이 되어야 합니다."
		assertTrue("12345678901".length() == 11);
		
		// 10자 초과의 아이디를 넣었을 때, 예외가 발생해야 한다.
		IllegalArgumentException idException= assertThrows(IllegalArgumentException.class, ()->{
			new UserVO("12345678901",pw,name,email,phoneNum,dateOfBirth);
		});
		
		String message = idException.getMessage();
		System.out.println(message);
	}
	
	@Test
	@DisplayName("UserVO 생성 조건 예외 테스트(PW)")
	void newUserVOExceptionTest2() {

		//"PW는 4글자 이상, 20자 미만의 글자로 저장이 되어야 합니다."
		// PW는 4글자 이상, 20자 미만의 글자의 비밀번호를 넣었을 때, 예외가 발생해야 한다.
		
		// PW가 4글자 미만일 때,
		assertTrue("123".length() == 3);
		IllegalArgumentException pwException1= assertThrows(IllegalArgumentException.class, ()->{
			new UserVO(id, "123",name,email,phoneNum,dateOfBirth);
		});
		
		// PW가 20자 이상일 때
		assertTrue("01234567890123456789".length() == 20);
		IllegalArgumentException pwException2= assertThrows(IllegalArgumentException.class, ()->{
			new UserVO(id,"01234567890123456789",name,email,phoneNum,dateOfBirth);
		});
		
		System.out.println(pwException1.getMessage());
		System.out.println(pwException2.getMessage());
	}
	
	@Test
	@DisplayName("UserVO 생성 조건 예외 테스트(NAME)")
	void newUserVOExceptionTest3() {

		//"이름은 10글자 이하의 글자로만 저장이 되어야 합니다."
		
		// 10자 초과의 이름을 넣었을 때, 예외가 발생해야 한다.
		assertTrue("01234567890".length() == 11);
		IllegalArgumentException nameException= assertThrows(IllegalArgumentException.class, ()->{
			new UserVO(id,pw,"01234567890",email,phoneNum,dateOfBirth);
		});
		
		String message = nameException.getMessage();
		System.out.println(message);
	}
	
	@Test
	@DisplayName("UserVO 생성 조건 예외 테스트(EMAIL)")
	void newUserVOExceptionTest4() {

		//"email은 '@'를 포함하고 있어야 합니다."
		assertTrue("123@123".lastIndexOf('@') != -1);
		assertTrue("123123".lastIndexOf('@') == -1);
		
		// '@'를 포함하고 있지 않을 때 예외가 발생한다.
		IllegalArgumentException idException= assertThrows(IllegalArgumentException.class, ()->{
			new UserVO(id,pw,name,"123123",phoneNum,dateOfBirth);
		});
		
		String message = idException.getMessage();
		System.out.println(message);
	}
}
