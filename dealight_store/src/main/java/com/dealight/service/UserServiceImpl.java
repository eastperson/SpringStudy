package com.dealight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;
import com.dealight.mapper.ReservationMapper;
import com.dealight.mapper.UserMapper;
import com.dealight.mapper.WaitingMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WaitingMapper waitMapper;
	
	@Autowired
	private ReservationMapper rsvdMapper;

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
		
		
		return null == waitMapper.findByUserId(userId, "W");
	}

	@Override
	public List<ReservationVO> getRsvdListThisUser(String userId) {
		
		
		return rsvdMapper.findByUserId(userId);
	}

	@Override
	public List<ReservationVO> getRsvdListStoreUser(long storeId, String userId) {
		
		
		return rsvdMapper.findByStoreIdAndUserId(storeId, userId);
	}

}
