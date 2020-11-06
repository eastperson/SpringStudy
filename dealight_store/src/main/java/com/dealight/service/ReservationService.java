package com.dealight.service;

import java.util.Date;
import java.util.List;

import com.dealight.domain.ReservationDetailVO;
import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

public interface ReservationService {
	
	// '����' Ȯ��
	// reservation mapper read
	// select
	ReservationVO read(long rsvdId);

	// '���� ��' Ȯ��
	// reservation detail mapper read
	// select
	ReservationDetailVO readDetail(long rsvdId);
	
	// �߰� mapper method �ʿ�
	// '����'�� '���� ����Ʈ' Ȯ���ϱ�
	// ���� �����丮
	// read list
	List<ReservationVO> readAllRsvdList(long storeId);
	
	// �߰� mapper method �ʿ�
	// '����'�� '���翹��'���� '���ฮ��Ʈ'Ȯ���ϱ�
	// read list
	// rsvd_stus = "c"
	List<ReservationVO> readCurRsvdList(long storeId);
	
	// �߰� mapper method �ʿ�
	// '����'�� '���翹��'���� '����'�� '���ฮ��Ʈ'Ȯ���ϱ�
	// ���� ������ ���Ͽ��ุ �����Ƿ� ũ�� ��� x
	// rsvd_stus = "c", time = today
	List<ReservationVO> readTodayCurRsvdList(long storeId);
	

	// ���� ���ɿ��� �Ǵ��ϱ�
	// "�� �ð�"�� "�� ����"���� ������ ��������
	// rsvd_stus = "c", time = this time
	boolean isReserveThisTimeStore(List<ReservationVO> readTodayCurRsvdList);
	
	// �ٷ� ���� ���� Ȯ���ϱ�
	ReservationVO readNextRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	// �ֵ����� �ƴ��� Ȯ���ϱ�
	boolean isHtdl(ReservationVO rsvd);
	
	
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
