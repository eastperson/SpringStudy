package com.ep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ep.domain.UserVO;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();
	
	public UserVO selectUser();
	
	
}
