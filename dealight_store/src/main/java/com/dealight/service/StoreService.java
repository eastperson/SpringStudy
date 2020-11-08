package com.dealight.service;

import java.util.Date;
import java.util.List;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.StoreVO;

public interface StoreService {
	
	// ���� ���� ���� Ȯ��
	String getCurSeatStus(long storeId);
	
	// ���� ���� ���� ����
	// bstore mapper update
	boolean changeSeatStus(long storeId,String seatStusCd);
	
	// ����ð�?
	Date getCurTime();
	
	StoreVO getStore(long storeId);
	
	// BStores
	StoreVO findByStoreIdWithBStore(long storeId);
	
	BStoreVO getBStore(long storeId);
	
	List<StoreVO> getStoreListByUserId(String userId);
	
	
	// ===============���� ���� ����
	
	

}
