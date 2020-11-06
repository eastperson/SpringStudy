package com.dealight.service;

import com.dealight.domain.UserVO;

public interface UserService {
	
	// read
	// user mapper - select
	UserVO read(String userId);
	
	// mapper method ÇÊ¿ä
	// read
	// user mapper - select
	String isCurPanalty(String userId);                                                                                                                                                                                                       

}
