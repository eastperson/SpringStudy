package com.ep.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ep.domain.UserVO;
import com.ep.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Setter(onMethod_= @Autowired)
	private UserMapper userMapper;

	@Override
	public void register(UserVO user) {
		
		if(!isValidRegisterUser(user))
			return;
		
			log.info("register : " + user);
			
			userMapper.insertUser(user);
		
	}
	
	@Override
	public boolean isValidRegisterUser(UserVO user) {
		if(userMapper.selectUser(user.getId()) == null)
			return true;
		
		return false;
	}

	@Override
	public UserVO get(String userId) {
		log.info("get : " + userId);
		
		return userMapper.selectUser(userId);
	}

	@Override
	public boolean modify(UserVO user) {
		log.info("modify : " + user);
		
		return 1 == userMapper.updateUser(user);
	}
	
	@Override
	public boolean isValidModifyUser(UserVO user) {
		if(userMapper.selectUser(user.getId()) != null)
			return true;
		
		return false;
	}

	@Override
	public boolean remove(String userId) {
		log.info("delete : " + userId);
		
		return 1 == userMapper.deleteUser(userId);
	}

	@Override
	public List<UserVO> getList() {
		log.info("getList : ");
		
		return userMapper.selectUserAll();
	}

	
	@Override
	public UserVO login(String userId, String pw) {
		
		log.info("user service : login...");
		
		if(loginValidCheck(userId,pw))
			return userMapper.selectUser(userId);
		
		
		return null;
	}

	@Override
	public boolean loginValidCheck(String userId, String pw) {
		
		log.info("user service : loginValidCheck...");
		
		if(userMapper.selectUser(userId) == null) {
			return false;
		}
		
		UserVO user = userMapper.selectUser(userId);
		
		if(userId.equals(user.getId()) && pw.equals(user.getPw()))
			return true;	
		
		return false;
	}

	@Override
	public void logout(HttpSession session) {
		
		log.info("user service : logout...");
		
		if(session.getAttribute("id") != null)
			session.invalidate();

	}
	
	
	
}
