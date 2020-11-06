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
public class HotDealVO {
	
	// 핫딜번호 
	@NonNull
    private long hotdealId;

    // 핫딜이름
	@NonNull
    private String name;

    // 매장번호
	@NonNull
    private long storeId;

    // 할인율 
	@NonNull
    private double dcRate;

    // 핫딜시작시간
	@NonNull
    private String startTm;

    // 핫딜마감시간
	@NonNull
    private String endTm;

    // 핫딜마감인원
	@NonNull
    private int lmtPnum;

    // 핫딜소개 
    private String intro;

    // 핫딜적용전가격
    @NonNull
    private int befPrice;

    // 할인차감금액
    @NonNull
    private int ddct;

    // 핫딜현재예약인원
    @NonNull
    private int curPnum;

    // 핫딜상태코드
    @NonNull
    @Builder.Default
    private String stusCd = "A";

}
