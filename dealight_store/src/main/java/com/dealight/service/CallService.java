package com.dealight.service;

import java.util.HashMap;
import java.util.List;

import com.dealight.domain.WaitingVO;

public interface CallService {
	
	// '웨이팅'에게 콜 메시지 보내기
	boolean call(long waitingId);
	
	// 전체 콜 메시지 보내기
	// return은 성공한 메시지 개수
	int callAllList(List<WaitingVO> curStoreWaitList);
	
	String getProfile();
	
	String getAuth();
	
	HashMap<String, Object> getToken(String code);
	
	String sendMessage(String access_token);

}
