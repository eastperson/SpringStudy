package com.ep.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ep.domain.Grade;
import com.ep.domain.UserVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserServiceTests {

	@Setter(onMethod_ = @Autowired)
	private UserService userService;
	
	// f22f 아이디의 유저 DB 상에 존재
	
	// test 생성 유저
	String id = "bs2!";
	String pw =  "1234";
	String name = "김동인";
	String email ="kjuioq@naver.com";
	String phoneNum = "01027375157";
	Date dateOfBirth = new Date(1993,12,11);
	Date inDate = new Date();
	Date updateDate = inDate;
	Grade grade = Grade.BRONZE;
	
	HttpServletRequest request;
	
	@Test
	public void getTest1() {
		
		// 아이디가 "f22f"일 때,
		String userId = "f22f";
		
		UserVO user = userService.get(userId);
		
		assertNotNull(user);
		assertTrue(userId.equals(user.getId()));
		
	}
	
	@Test
	public void registerTest1() {
		
		id = "dlq!";
		
		assertNull(userService.get(id));
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		userService.register(user);
		
		user = userService.get(id);
		
		assertNotNull(user);
		assertTrue(id.equals(user.getId()));
		
		//rollback
		
		assertTrue(userService.remove(id));
		assertNull(userService.get(id));
	}
	
	@Test
	public void removeTest1() {
		
		id = "dlq!";
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		assertNull(userService.get(id));
		
		userService.register(user);
		
		assertNotNull(userService.get(id));
		
		assertTrue(userService.remove(id));
		
		assertNull(userService.get(id));
		
	}
	
	@Test
	public void getList() {
		
		List<UserVO> list = userService.getList();
		
		assertNotNull(list);
		
		int beforeSize = list.size();
		
		UserVO user = new UserVO("fds#",pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		userService.register(user);
		
		assertTrue(beforeSize + 1 == userService.getList().size());
		
		assertTrue(userService.remove(user.getId()));
		
		assertTrue(beforeSize == userService.getList().size());
		
	}
	
	@Test
	public void modifyTest1() {
		
		id = "abc";
		String beforePw = pw;
		String beforeName = "김동인";
		// "abc"
		assertNotNull(userService.get(id));
		
		pw = "123456";
		name = "김경주";
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		assertTrue(userService.modify(user));
		
		UserVO selectedUser = userService.get(id);
		
		assertNotNull(selectedUser);
		assertTrue(selectedUser.getPw().equals("123456"));
		assertTrue(selectedUser.getName().equals("김경주"));
		
		user = new UserVO(id,beforePw,beforeName,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		assertTrue(userService.modify(user));
		
		selectedUser = userService.get(id);
		
		assertNotNull(selectedUser);
		assertTrue(selectedUser.getPw().equals(beforePw));
		assertTrue(selectedUser.getName().equals(beforeName));
		
	}
	
	@Test
	public void loginValidCheckTest1() {
		
		UserVO user = userService.get("abc");
		
		assertTrue(userService.loginValidCheck("abc",user.getPw()));
		
		assertFalse(userService.loginValidCheck("abc", "444"));
		
		assertFalse(userService.loginValidCheck("!e1E@", pw));
	}
	
	@Test
	public void loginTest1() {
		
		id = "abc";
		
		pw = userService.get(id).getPw();
		
		assertTrue(userService.get(id).equals(userService.login(id, pw)));
		
	}
	
	@Test
	public void logoutTest1() {
		
		//HttpSession session = request.getSession();
		
		//UserVO user = userService.get(id);
		
		//session.setAttribute("id", user);
		
		//assertTrue(userService.logout(request, id));
		
	}
	
}
