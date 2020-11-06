package com.dealight.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BStoreVO {
	
    // 매장번호 
    @NonNull private long storeId;

    // 사업자회원아이디 
    private String buserId;

    // 착석상태코드 
    @Builder.Default
    @NonNull private String seatStusCd = "B";

    // 영업시작시간 
    @NonNull private String openTm;

    // 영업종료시간 
    @NonNull private String closeTm;

    // 브레이크타입시작시간 
    private String breakSttm;

    // 브레이크타임종료시간 
    private String breakEntm;

    // 라스트오더시간 
    private String lastOrdTm;

    // 1인테이블개수 
    private int n1SeatNo;

    // 2인테이블개수 
    private int n2SeatNo;

    // 4인테이블개수 
    private int n4SeatNo;

    // 매장소개 
    private String storeIntro;

    // 매장평균식사시간 
    private int avgMealTm;

    // 매장휴무일 
    private String hldy;

    // 수용인원 
    private int acmPnum;
	
	

}
