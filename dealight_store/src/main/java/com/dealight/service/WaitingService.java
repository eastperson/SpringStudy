package com.dealight.service;

import java.util.List;

import com.dealight.domain.WaitingVO;

public interface WaitingService {
	
	// 웨이팅 상세 보기
	// wait dtls mapper - select
	WaitingVO read(long waitingId);
	
	// 온라인 웨이팅 등록
	// wait mapper - inserSelectKey
	void registerOnWaiting(WaitingVO waiting);
	
	// 오프라인 웨이팅 등록
	// wait mapper - inserSelectKey
	void registerOffWaiting(WaitingVO waiting);
	
	// 웨이팅 취소
	// 웨이팅 clsCd waitStusCd = "C" 
	// wait mapper - update
	boolean cancelWaiting(long waitingId);
	
	// 웨이팅 입장
	// 웨이팅 clsCd waitStusCd = "E" 
	// wait mapper - update
	int enterWating(long waitingId);
	
	// 웨이팅 노쇼
	// 웨이팅 clsCd waitStusCd = "P" 
	// wait mapper - update
	int enterWaiting(long waitingId);
	
	// mapper method 필요
	// 이 매장의 전체 웨이팅 리스트(과거포함)
	// wait mapper - select list
	List<WaitingVO> allStoreWaitList(long storeId);
	
	// mapper method 필요
	// 현재 이 매장에서 대기중인 웨이팅 리스트
	// wait mapper - select list
	// -storeid
	// -clsCd waitStusCd = "C" 
	List<WaitingVO> curStoreWaitList(long storeId, String waitStusCd);
	
	// 웨이팅 순서 계산
	// 현재 '이 매장'에서 상태가 '대기중'인 '웨이팅 리스트' 중 해당 웨이팅의 대기순서
	int calWatingOrder(List<WaitingVO> curStoreWaitiList, long waitingId);
	
	// 예상 소요 시간
	// 현재 '이 웨이팅'이 식사까지 얼만큼의 시간이 소요되는지
	// 반환의 단위는 '초'
	int calWaitingTime(long waitingId);
	


}
