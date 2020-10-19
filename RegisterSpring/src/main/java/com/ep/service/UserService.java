package com.ep.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ep.domain.UserVO;

public interface UserService {
	
	public void register(UserVO user);
	
	public UserVO get(String userId);
	
	public boolean modify(UserVO user);
	
	public boolean remove(String userId);
	
	public List<UserVO> getList();
	
	public UserVO login(String userId, String pw);
	
	public boolean loginValidCheck(String userId, String pw);
	
	public boolean logout(HttpServletRequest request,String userId);
	
}
