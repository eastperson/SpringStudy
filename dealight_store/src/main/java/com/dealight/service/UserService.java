package com.dealight.service;

import java.util.List;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

public interface UserService {
	
	// read
	// user mapper - select
	UserVO read(String userId);
	
	// read
	// user mapper - select
	// 상태가 'y'면 패널티 회원
	boolean isCurPanalty(String userId); 
	
	// 추가 mapper method 필요
	// 현재 웨이팅 상태중인지
	// wait mapper - userId로 검색
	boolean isCurWaiting(String userId);
	
	// 회원의 예약정보 가져오기
	List<ReservationVO> rsvdListThisUser(UserVO user);
	
	// mapper method 필요
	// 해당 매장의 회원의 예약정보 가져오기 
	List<ReservationVO> rsvdListStoreUser(long storeId, UserVO user);

}
