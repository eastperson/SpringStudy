package com.dealight.service;

import java.util.List;

import com.dealight.domain.WaitingVO;

public interface WaitingService {
	
	// ������ �� ����
	// wait dtls mapper - select
	WaitingVO read(long waitingId);
	
	// �¶��� ������ ���
	// wait mapper - inserSelectKey
	void registerOnWaiting(WaitingVO waiting);
	
	// �������� ������ ���
	// wait mapper - inserSelectKey
	void registerOffWaiting(WaitingVO waiting);
	
	// ������ ���
	// ������ clsCd waitStusCd = "C" 
	// wait mapper - update
	boolean cancelWaiting(long waitingId);
	
	// ������ ����
	// ������ clsCd waitStusCd = "E" 
	// wait mapper - update
	int enterWating(long waitingId);
	
	// ������ ���
	// ������ clsCd waitStusCd = "P" 
	// wait mapper - update
	int enterWaiting(long waitingId);
	
	// mapper method �ʿ�
	// �� ������ ��ü ������ ����Ʈ(��������)
	// wait mapper - select list
	List<WaitingVO> allStoreWaitList(long storeId);
	
	// mapper method �ʿ�
	// ���� �� ���忡�� ������� ������ ����Ʈ
	// wait mapper - select list
	// -storeid
	// -clsCd waitStusCd = "C" 
	List<WaitingVO> curStoreWaitList(long storeId, String waitStusCd);
	
	// ������ ���� ���
	// ���� '�� ����'���� ���°� '�����'�� '������ ����Ʈ' �� �ش� �������� ������
	int calWatingOrder(List<WaitingVO> curStoreWaitiList, long waitingId);
	
	// ���� �ҿ� �ð�
	// ���� '�� ������'�� �Ļ���� ��ŭ�� �ð��� �ҿ�Ǵ���
	// ��ȯ�� ������ '��'
	int calWaitingTime(long waitingId);
	


}
