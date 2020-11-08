package com.dealight.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.dealight.domain.ReservationDetailVO;
import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

public interface ReservationService {
	
	final static int timeGap = 30;
	
	// '����' Ȯ��
	// reservation mapper read
	// select
	ReservationVO read(long rsvdId);

	// '���� ��' Ȯ��
	// reservation detail mapper read
	// select
	List<ReservationDetailVO> readDetail(long rsvdId);
	
	// �߰� mapper method �ʿ� - �߰� �Ϸ�
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
	// '����'�� '����'�� '���ฮ��Ʈ'Ȯ���ϱ�
	// ���� ������ ���Ͽ��ุ �����Ƿ� ũ�� ��� x
	// time = today
	List<ReservationVO> readTodayCurRsvdList(long storeId);
	
	
	
	List<ReservationVO> readRsvdListByDate(long storeId,String date);

	
	
	// ���� ���ɿ��� �Ǵ��ϱ�
	// "�� �ð�"�� "�� ����"���� ������ ��������
	// rsvd_stus = "c", time = this time
	// acm�� �� ������ �� ���� ���� �ο�
	// *******acm�� ������ ���� ���� �ο����� �����ؾ���
	boolean isReserveThisTimeStore(long storeId, Date date, int acm);
	
	// time���� ���� string Ÿ���� second�� ���
	// 00:00 -> 0
	// 12:30 -> 12*60 + 30-> 720 + 30 == 750
	String getTime(Date date);
	
	// time���� ���� string Ÿ���� second�� ���
	// 00:00 -> 0
	// 12:30 -> 12*60 + 30-> 720 + 30 == 750
	int calTimeMinutes(String time);
	
	// ��¥�� ���� ����Ʈ
	// mapper �߰�
	// date �� ������ "yyyyMMdd"
	List<ReservationVO> getListByDate(long storeId,String date);
	
	// �ð��뺰 ���� ����Ʈ
	// map���� �ؾ��ϳ�?
	// 15�� ������ �ֱ�
	// HashMap<String rsvdByTime,int count>.
	HashMap<String,List<Long>> getRsvdByTimeMap(List<ReservationVO> listByDate);
	
	
	// hour = hour
	// if minute < 60 -> 45
	// 		minute < 45 -> 30
	// 		minute < 30 -> 15
	// 		minute < 15 -> 00
	// String rsvdByTime = hour.toString() + ":" + minute.toString()
	String toRsvdByTimeFormat(String time);
	
	
	// �ٷ� ���� ���� Ȯ���ϱ�
	// �ð������� �����ؾ���
	long readNextRsvdId(HashMap<String, List<Long>> getTodayRsvdByTimeMap);
	
	
	// �ֵ����� �ƴ��� Ȯ���ϱ�
	boolean isHtdl(ReservationVO rsvd);
	
	ReservationVO findRsvdByRsvdId(long rsvdId, List<ReservationVO> readTodayCurRsvdList);
	
	
	// ===============���� ��Ȳ�� ����
	
	// ���� ���� ���� �հ�
	int totalTodayRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	// ���� ���� �ο� �հ�
	int totalTodayRsvdPnum(List<ReservationVO> readTodayCurRsvdList);
	
	// ���� ��ȣ �޴�
	HashMap<String,Integer> todayFavMenu(long storeId);
	
	// ���� ���� �� ����Ʈ
	List<UserVO> userListTodayRsvd(long storeId, String date);
	
	// �� �̿� �ð���
	// �ϴ� ����
	
	// �Ϻ� ���� ����(������)
	//�ϴ� ����
	
	
}
