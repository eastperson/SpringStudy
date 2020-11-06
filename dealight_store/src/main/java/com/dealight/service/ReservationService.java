package com.dealight.service;

import java.util.Date;
import java.util.List;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

public interface ReservationService {
	
	// '����' Ȯ��
	ReservationVO read(long rsvdId);

	// '���� ��' Ȯ��
	ReservationVO readDetail(long rsvdId);
	
	// '����'�� '���� ����Ʈ' Ȯ���ϱ�
	// ���� �����丮
	List<ReservationVO> readAllRsvdList(long storeId);
	
	// '����'�� '���翹��'���� '���ฮ��Ʈ'Ȯ���ϱ�
	List<ReservationVO> readCurRsvdList(long storeId);
	
	// '����'�� '���翹��'���� '����'�� '���ฮ��Ʈ'Ȯ���ϱ�
	// ���� ������ ���Ͽ��ุ �����Ƿ� ũ�� ��� x
	List<ReservationVO> readTodayCurRsvdList(long storeId);
	
	// ���� ���ɿ��� �Ǵ��ϱ�
	// "�� �ð�"�� "�� ����"���� ������ ��������
	boolean isReserveThisTimeStore(Date thisTm, long storeId);
	
	// �ٷ� ���� ���� Ȯ���ϱ�
	ReservationVO readNextRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	
	// ===============���� ��Ȳ�� ����
	
	// ���� ���� ���� �հ�
	int totalTodayRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	// ���� ���� �ο� �հ�
	int totalTodayRsvdPnum(List<ReservationVO> readTodayCurRsvdList);
	
	// ���� ��ȣ �޴�
	int todayFavMenu(List<ReservationVO> readTodayCurRsvdList);
	
	// ���� ���� �� ����Ʈ
	List<UserVO> userListTodayRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	// �� �̿� �ð���
	// �ϴ� ����
	
	// �Ϻ� ���� ����(������)
	//�ϴ� ����
	
	
	
}
