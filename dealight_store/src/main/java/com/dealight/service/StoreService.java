package com.dealight.service;

import java.util.Date;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.StoreVO;

public interface StoreService {
	
	// 현재 착석 상태 확인
	String getCurSeatStus(long storeId);
	
	// 착석 가능 여부 변경
	// bstore mapper update
	boolean changeSeatStus(long storeId,String seatStusCd);
	
	
	// 현재시간?
	Date getCurTime();
	
	StoreVO getStore(long storeId);
	
	BStoreVO getBStore(long storeId);
	
	
	// ===============매장 수정 로직
	
	

}
