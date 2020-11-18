package com.dealight.service;

import java.util.HashMap;
import java.util.List;

import com.dealight.domain.WaitingVO;

public interface CallService {
	
	// '������'���� �� �޽��� ������
	boolean call(long waitingId);
	
	// ��ü �� �޽��� ������
	// return�� ������ �޽��� ����
	int callAllList(List<WaitingVO> curStoreWaitList);
	
	String getProfile();
	
	String getAuth();
	
	HashMap<String, Object> getToken(String code);
	
	String sendMessage(String access_token);

}
