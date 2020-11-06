package com.dealight.service;

import java.util.Date;
import java.util.List;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

public interface ReservationService {
	
	// '예약' 확인
	ReservationVO read(long rsvdId);

	// '예약 상세' 확인
	ReservationVO readDetail(long rsvdId);
	
	// '매장'의 '예약 리스트' 확인하기
	// 예약 히스토리
	List<ReservationVO> readAllRsvdList(long storeId);
	
	// '매장'의 '현재예약'중인 '예약리스트'확인하기
	List<ReservationVO> readCurRsvdList(long storeId);
	
	// '매장'의 '현재예약'중인 '오늘'의 '예약리스트'확인하기
	// 지금 당장은 당일예약만 있으므로 크게 상관 x
	List<ReservationVO> readTodayCurRsvdList(long storeId);
	
	// 예약 가능여부 판단하기
	// "이 시간"에 "이 매장"에서 예약이 가능한지
	boolean isReserveThisTimeStore(Date thisTm, long storeId);
	
	// 바로 다음 예약 확인하기
	ReservationVO readNextRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	
	// ===============당일 현황판 로직
	
	// 당일 예약 접수 합계
	int totalTodayRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	// 당일 예약 인원 합계
	int totalTodayRsvdPnum(List<ReservationVO> readTodayCurRsvdList);
	
	// 당일 선호 메뉴
	int todayFavMenu(List<ReservationVO> readTodayCurRsvdList);
	
	// 당일 예약 고객 리스트
	List<UserVO> userListTodayRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	// 주 이용 시간대
	// 일단 제외
	
	// 일별 예약 추이(일주일)
	//일단 제외
	
	
	
}
