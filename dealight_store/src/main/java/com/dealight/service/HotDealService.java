package com.dealight.service;

import java.util.List;

import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.HotDealResultVO;
import com.dealight.domain.HotDealVO;

public interface HotDealService {
	
	// 핫딜 확인
	// htdl mapper read
	HotDealVO read(long htdlId);
	
	// 핫딜 상세 확인
	// htdlDtls mapper read
	HotDealDetailVO readDtls(long htdlId);
	
	// 핫딜 결과 확인
	// htdlRslt mapper read
	HotDealResultVO readRslt(long htdlId);
	
	// 핫딜 마감 시간
	int calHtdlEndTm(HotDealVO htdl);
	
	// 현재 '이 매장'에 등록된 '핫딜' 리스트 전부 보기
	List<HotDealVO> readAllStoreHtdlList(long storeId);
	
	// 현재 '이 매장'에 등록된 '핫딜' 중 '활성화'상태인 리스트 보기
	List<HotDealVO> readActStoreHtdlList(long storeId);

}
