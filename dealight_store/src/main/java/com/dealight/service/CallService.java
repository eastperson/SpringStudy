package com.dealight.service;

import java.util.List;

import com.dealight.domain.WaitingVO;

public interface CallService {
	
	// '�� ������'���� �� �޽��� ������
	boolean call(long waitingId);
	
	// ��ü �� �޽��� ������
	// return�� ������ �޽��� ����
	int callAllList(List<WaitingVO> curStoreWaitList);

}
