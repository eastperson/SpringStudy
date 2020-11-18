package com.dealight.service;

import java.util.List;

import com.dealight.domain.WaitVO;

public interface WaitingService {
	
	// ������ �� ����
	// wait dtls mapper - select
	// read
	WaitVO read(long waitingId);
	
	// �¶��� ������ ���
	// wait mapper - inserSelectKey
	// insert
	long registerOnWaiting(WaitVO waiting);
	
	// ������ ���� ����
	// �ߺ� ������, �г�Ƽ �� ��ģ��
	boolean isPossibleWaitingUser(String userId);
	
	// �ߺ� ������ ����
	boolean isCurWaitingUser(String userId);
	
	// �г�Ƽ �� ����
	boolean isCurPanaltyUser(String userId);
	
	// �������� ������ ���
	// wait mapper - inserSelectKey
	// insert
	long registerOffWaiting(WaitVO waiting);
	
	// ������ ���
	// ������ clsCd waitStusCd = "C" 
	// wait mapper - update
	boolean cancelWaiting(long waitingId);
	
	// ������ ����
	// ������ clsCd waitStusCd = "E" 
	// wait mapper - update
	boolean enterWaiting(long waitingId);
	
	// ������ ���
	// ������ clsCd waitStusCd = "P" 
	// wait mapper - update
	boolean panaltyWaiting(long waitingId);
	
	// mapper method �ʿ�
	// �� ������ ��ü ������ ����Ʈ(��������)
	// wait mapper - select list
	List<WaitVO> allStoreWaitList(long storeId);
	
	// mapper method �ʿ�
	// ���� �� ���忡�� ������� ������ ����Ʈ
	// wait mapper - select list
	// -storeid
	// -clsCd waitStusCd = "C" 
	List<WaitVO> curStoreWaitList(long storeId, String waitStusCd);
	
	// ������ ���� ���
	// ���� '�� ����'���� ���°� '�����'�� '������ ����Ʈ' �� �ش� �������� ������
	int calWatingOrder(List<WaitVO> curStoreWaitiList, long waitingId);
	
	// ���� �ҿ� �ð�
	// ���� '�� ������'�� �Ļ���� ��ŭ�� �ð��� �ҿ�Ǵ���
	// ��ȯ�� ������ '��'
	int calWaitingTime(List<WaitVO> curStoreWaitiList, long waitingId, int avgTime);
	
	// �ٷ� ���� ������ ��ü ��������
	WaitVO readNextWait(List<WaitVO> curStoreWaitiList);
	


}
