package com.dealight.service;

import java.util.Date;

public interface StoreService {
	
	
	
	// 착석 가능 여부 변경
	// bstore mapper update
	boolean seatStusChange(long storeId,String buser_id);
	
	
	// 현재시간?
	Date curTime();
	
	
	// ===============매장 수정 로직
	
	

}
