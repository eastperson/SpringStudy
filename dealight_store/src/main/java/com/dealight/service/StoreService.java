package com.dealight.service;

import java.util.Date;
import java.util.List;

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
	
	// BStores
	StoreVO findByStoreIdWithBStore(long storeId);
	
	BStoreVO getBStore(long storeId);
	
	List<StoreVO> getStoreListByUserId(String userId);
	
	
	// 매장 등록하기
	void registerStoreAndBStore(StoreVO store);
	
	
	// 매장 수정하기
	boolean modifyStore(StoreVO store);
	
	
	boolean modifyBStore(StoreVO store);
	
	// 필요 x
	boolean modifyNStore(StoreVO store);
	
	// ===============매장 수정 로직
	
	

}
