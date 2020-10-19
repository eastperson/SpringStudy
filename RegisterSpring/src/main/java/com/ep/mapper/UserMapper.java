package com.ep.mapper;

import java.util.List;

import com.ep.domain.UserVO;

public interface UserMapper {

	public UserVO selectUser(String userId);
	
	public int insertUser(UserVO user);
	
	public List<UserVO> selectUserAll();
	
	public int updateUser(UserVO user);
	
	public int deleteUser(String userId);
}
