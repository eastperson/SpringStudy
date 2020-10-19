package com.ep.mapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

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
public class UserMapperTests {
	
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
	
	@Setter(onMethod_ = @Autowired)
	private UserMapper userMapper;
	
	@Test
	public void selectUserTest1() {
		
		// 아이디가 "f22f"일 때,
		String id = "f22f";
		
		// mapper로 해당 id 유저를 가져오면
		UserVO user = userMapper.selectUser(id);
		
		// user는 null이 아니어야 한다.
		assertNotNull(user);
		assertTrue(user.getId().equals(id));
	}
	
	@Test
	public void selectUserTest2() {
		
		// 없는 아이디를 셀렉트했을 때,
		String id = "@@@";
		
		// mapper로 해당 id 유저를 가져오면
		UserVO user = userMapper.selectUser(id);
		
		// user는 null이어야 한다.
		assertNull(user);
	}
	
	@Test
	public void insertUserTest1() {
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		int size = userMapper.selectUserAll().size();
		
		assertNull(userMapper.selectUser(id));
		
		assertTrue(1 == userMapper.insertUser(user));
		
		user = userMapper.selectUser(id);
		
		assertNotNull(user);
		
		assertTrue(user.getId().equals(id));
		
		assertTrue(userMapper.selectUserAll().size() == size + 1);
		
	}
	
	@Test
	public void insertUserTest2() {
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		assertNotNull(userMapper.selectUser(id));
		
		//assertTrue(0 == userMapper.insertUser(user));
		
	}
	
	@Test
	public void selectUserAllTest1() {
		
		List<UserVO> list = userMapper.selectUserAll();
		
		assertNotNull(list);
		
	}
	
	@Test
	public void updateUserTest1() {
		
		String ogPw = pw;
		String ogEmail = email;
		
		pw = "1234";
		email = "abc@google.com";
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		UserVO selectedUser = userMapper.selectUser(id);
		
		assertTrue(user.getId().equals(selectedUser.getId()));
		
		assertFalse(user.getPw().equals(selectedUser.getPw()));
		assertFalse(user.getEmail().equals(selectedUser.getEmail()));
		
		System.out.println(selectedUser);
		userMapper.updateUser(user);
		selectedUser = userMapper.selectUser(id);
		System.out.println(selectedUser);
		
		assertTrue(user.getId().equals(selectedUser.getId()));
		assertTrue(user.getPw().equals(selectedUser.getPw()));
		assertTrue(user.getEmail().equals(selectedUser.getEmail()));		
		
		//rollback
		
		pw = ogPw;
		email = ogEmail;
		
		user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate,grade);
		
		userMapper.updateUser(user);
		
		selectedUser = userMapper.selectUser(id);
	
		selectedUser.getPw().equals(ogPw);
		selectedUser.getEmail().equals(ogEmail);
	}
	
	@Test
	public void deleteUserTest1() {
		
		// 미리 유저 정보를 넣어준다.
		id = "APQLZ";
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,dateOfBirth,inDate,updateDate, grade);
		
		assertTrue(1 == userMapper.insertUser(user));
		
		UserVO selectedUser = userMapper.selectUser(id);
		
		assertNotNull(selectedUser);
		
		assertTrue(1 == userMapper.deleteUser(id));
		
		assertNull(userMapper.selectUser(id));
		
	}
	
	
	
	
	
	
}
