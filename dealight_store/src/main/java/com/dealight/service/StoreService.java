package com.dealight.service;

import java.util.Date;

public interface StoreService {
	
	// ���� ���� ���� Ȯ��
	String getCurSeatStus(long storeId);
	
	// ���� ���� ���� ����
	// bstore mapper update
	boolean changeSeatStus(long storeId,String seatStusCd);
	
	
	// ����ð�?
	Date curTime();
	
	
	// ===============���� ���� ����
	
	

}
