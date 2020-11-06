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
	// ���°� 'y'�� �г�Ƽ ȸ��
	boolean isCurPanalty(String userId); 
	
	// �߰� mapper method �ʿ�
	// ���� ������ ����������
	// wait mapper - userId�� �˻�
	boolean isCurWaiting(String userId);
	
	// ȸ���� �������� ��������
	List<ReservationVO> rsvdListThisUser(UserVO user);
	
	// mapper method �ʿ�
	// �ش� ������ ȸ���� �������� �������� 
	List<ReservationVO> rsvdListStoreUser(long storeId, UserVO user);

}
