package com.dealight.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class UserVOTests {
	
	// 필수 입력값
	String id = "kjuioq";
	String name = "김동인";
	String pwd = "123123";
	String email = "kjuioq@naver.com";
	String telno = "010-2737-5157";
	String sex = "M";

	// 선택 입력값
	String brdt = "931211";
	String photoSrc = "/a.jpg";
	Date pmExpi = new Date();
	
	// 1. 필수 입력값만 입력하고 유저객체가 생성될 수 있는지.
	// not null 값만 입력
	// 필수값 : id,name,pw,email,telno,sex
	// 선택값 : snsLginYn, clsCd, pmStus, pmCnt
	// 필수 입력값을 입력하지 않았을시 컴파일에러
	@Test
	public void userGenerateTest1() {
		UserVO user = new UserVO.Builder(id,name,pwd,email,telno,sex)
				.build();
		
		assertTrue(user.getUserId().equals(id));
		assertTrue(user.getName().equals(name));
		assertTrue(user.getPwd().equals(pwd));
		assertTrue(user.getEmail().equals(email));
		assertTrue(user.getTelno().equals(telno));
		assertTrue(user.getSex().equals(sex));
		assertNotNull(user);
		
	}
	
	
	// 2. 모든 입력값을 입력해서 유저 객체를 생선한다.
	// 추가 : brdt, photoSrc, pmExpi
	@Test
	public void userGenerateTest2() {
		UserVO user = new UserVO.Builder(id,name,pwd,email,telno,sex)
				.setBrbt(brdt)
				.setPhotoSrc(photoSrc)
				.setPmExpi(pmExpi)
				.build();
		
		assertTrue(user.getUserId().equals(id));
		assertTrue(user.getName().equals(name));
		assertTrue(user.getPwd().equals(pwd));
		assertTrue(user.getEmail().equals(email));
		assertTrue(user.getTelno().equals(telno));
		assertTrue(user.getSex().equals(sex));
		assertTrue(user.getBrdt().equals(brdt));
		assertTrue(user.getPhotoSrc().equals(photoSrc));
		assertTrue(user.getPmExpi().equals(pmExpi));
		
		
		assertNotNull(user);
	}
	
	
	// 3. 입력한 값이 형식에 맞지 않을때 예외를 발생시킨다.
	// 3-1. 아이디가 20자 이상일 때
	@Test(expected=IllegalArgumentException.class)
	public void userGenerateExceptionTest1() {
			UserVO user = new UserVO.Builder("dddddddddddddddddddddddddddddd", "김동인", "123123", "kjuioq@naver.com", "010-2737-5157",
														"M")
					.setBrbt("931211")
					.setPhotoSrc("/a.jpg")
					.setPmExpi(new Date())
					.build();
			
			System.out.println(user);
			assertNotNull(user);
	}
	
	// 3. 입력한 값이 형식에 맞지 않을때 예외를 발생시킨다.
	// 3-2. 이름의 글자수가 5자를 초과했을 때
	@Test(expected=IllegalArgumentException.class)
	public void userGenerateExceptionTest2() {
			UserVO user = new UserVO.Builder("ddd", "김동인인인인", "123123", "kjuioq@naver.com", "010-2737-5157",
														"M")
					.setBrbt("931211")
					.setPhotoSrc("/a.jpg")
					.setPmExpi(new Date())
					.build();
			
			System.out.println(user);
			assertNotNull(user);
	}
	
	// 3. 입력한 값이 형식에 맞지 않을때 예외를 발생시킨다.
	// 3-3. 비밀번호의 글자수가 20자를 초과했을 때
	@Test(expected=IllegalArgumentException.class)
	public void userGenerateExceptionTest3() {
			UserVO user = new UserVO.Builder("ddd", "김동인", "1231233333333333333333", "kjuioq@naver.com", "010-2737-5157",
														"M")
					.setBrbt("931211")
					.setPhotoSrc("/a.jpg")
					.setPmExpi(new Date())
					.build();
			
			System.out.println(user);
			assertNotNull(user);
	}
	
	// 3. 입력한 값이 형식에 맞지 않을때 예외를 발생시킨다.
	// 3-4. email의 글자수가 30자를 초과했을 때
	@Test(expected=IllegalArgumentException.class)
	public void userGenerateExceptionTest4() {
			UserVO user = new UserVO.Builder("dddddddd", "김동인", "123123", "kjuioq@naver.cdsandjsandjasdasjndasjndjasndjn dasjom", "010-2737-5157",
														"M")
					.setBrbt("931211")
					.setPhotoSrc("/a.jpg")
					.setPmExpi(new Date())
					.build();
			
			System.out.println(user);
			assertNotNull(user);
	}
	
	// 3. 입력한 값이 형식에 맞지 않을때 예외를 발생시킨다.
	// 3-5. 전화번호의 글자수가 13자를 초과했을 때
	@Test(expected=IllegalArgumentException.class)
	public void userGenerateExceptionTest5() {
			UserVO user = new UserVO.Builder("dddddddd", "김동인", "123123", "kjuioq@naver.com", "00000000000010-2737-5157",
														"M")
					.setBrbt("931211")
					.setPhotoSrc("/a.jpg")
					.setPmExpi(new Date())
					.build();
			
			System.out.println(user);
			assertNotNull(user);
	}
	
	// 3. 입력한 값이 형식에 맞지 않을때 예외를 발생시킨다.
	// 3-6. 성별입력코드가 M 혹은 F가 아닐때
	@Test(expected=IllegalArgumentException.class)
	public void userGenerateExceptionTest6() {
			UserVO user = new UserVO.Builder("dddddddd", "김동인", "123123", "kjuioq@naver.com", "010-2737-5157",
														"G")
					.setBrbt("931211")
					.setPhotoSrc("/a.jpg")
					.setPmExpi(new Date())
					.build();
			
			System.out.println(user);
			assertNotNull(user);
	}
	
}
