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
public class ReservationVO {
	
	// composition
	private ReservationDetailVO revdDtls;
	
    // 예약번호 
	@NonNull
    private long id;

    // 매장번호
	@NonNull
    private long storeId;

    // 회원아이디
	@NonNull
    private String userId;

    // 핫딜번호 
    private long htdlId;

    // 결제승인번호 
    private int aprvNo;

    // 예약인원
    @NonNull
    private int pnum;

    // 예약시간
    @NonNull
    private String time;

    // 예약상태코드
    @NonNull
    @Builder.Default
    private String stusCd = "P";

    // 예약총액
    @NonNull
    private int totAmt;

    // 총메뉴수량
    @NonNull
    private int totQty;
    
    private Date inDate;

}
