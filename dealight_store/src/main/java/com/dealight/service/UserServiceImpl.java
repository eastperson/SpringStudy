package com.dealight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;
import com.dealight.mapper.UserMapper;
import com.dealight.mapper.WaitingMapper;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WaitingMapper waitMapper;

	@Override
	public UserVO read(String userId) {
		
		return userMapper.findById(userId);
	}

	@Override
	public boolean isCurPanalty(String userId) {
		
		UserVO user = userMapper.findById(userId);
		
		return user.getPmStus().equalsIgnoreCase("Y");
	}

	@Override
	public boolean isCurWaiting(String userId) {
		
		UserVO user = userMapper.findById(userId);
				
		return false;
	}

	@Override
	public List<ReservationVO> rsvdListThisUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationVO> rsvdListStoreUser(long storeId, UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

}
