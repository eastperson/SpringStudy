package com.ep.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class UserVOTests {
	
	String id = "abcd";
	String pw =  "1234";
	String name = "김동인";
	String email ="kjuioq@naver.com";
	String phoneNum = "01027375157";
	Date dateOfBirth = new Date(1993,12,11);
	Date inDate = new Date();
	Date updateDate = inDate;
	Grade grade = Grade.BRONZE;
	
	// 유저가 잘 생성 되는지
	@Test
	public void generateUserVO() {
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		assertNotNull(user);
		
		System.out.println(user);
		
	}
	
	@Test
	public void generateUserVO_idTest1() {
		
		id = "01234567890";
		
		assertTrue(id.length() > 10);
		
		String message = "에러가 발생하지 않았습니다.";
		
		try {
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass() == IllegalArgumentException.class);
			message = e.getMessage();
		}
		
		assertFalse(message.equals("에러가 발생하지 않았습니다."));
		System.out.println(message);
		
	}
	
	@Test
	public void generateUserVO_pwTest1() {
		
		pw = "012";
		
		assertTrue(pw.length() < 4);
		
		String message = "에러가 발생하지 않았습니다.";
		
		try {
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass() == IllegalArgumentException.class);
			message = e.getMessage();
		}
		
		assertFalse(message.equals("에러가 발생하지 않았습니다."));
		System.out.println(message);
		
	}
	
	@Test
	public void generateUserVO_pwTest2() {
		
		pw = "01234567890123456789";
		
		assertTrue(pw.length() > 19);
		
		String message = "에러가 발생하지 않았습니다.";
		
		try {
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass() == IllegalArgumentException.class);
			message = e.getMessage();
		}
		
		assertFalse(message.equals("에러가 발생하지 않았습니다."));
		System.out.println(message);
		
	}
	
	@Test
	public void generateUserVO_nameTest1() {
		
		name = "01234567890";
		
		assertTrue(name.length() > 10);
		
		String message = "에러가 발생하지 않았습니다.";
		
		try {
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass() == IllegalArgumentException.class);
			message = e.getMessage();
		}
		
		assertFalse(message.equals("에러가 발생하지 않았습니다."));
		System.out.println(message);
		
	}
	
	@Test
	public void generateUserVO_emailTest1() {
		
		email = "0123";
		
		assertTrue(email.lastIndexOf("@") == -1);
		
		String message = "에러가 발생하지 않았습니다.";
		
		try {
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		} catch (IllegalArgumentException e) {
			assertTrue(e.getClass() == IllegalArgumentException.class);
			message = e.getMessage();
		}
		
		assertFalse(message.equals("에러가 발생하지 않았습니다."));
		System.out.println(message);
		
	}
	
}
