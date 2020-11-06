package com.dealight.service;

import java.util.List;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

public interface UserService {
	
	// read
	// user mapper - select
	UserVO read(String userId);
	
	// mapper method �ʿ�
	// read
	// user mapper - select
	boolean isCurPanalty(String userId); 
	
	// ���� ������ ����������
	// user mapper -
	boolean isCurWaiting(String userId);
	
	// ȸ���� �������� ��������
	List<ReservationVO> rsvdListThisUser(UserVO user);
	
	// mapper method �ʿ�
	// �ش� ������ ȸ���� �������� �������� 
	List<ReservationVO> rsvdListStoreUser(long storeId, UserVO user);

}
