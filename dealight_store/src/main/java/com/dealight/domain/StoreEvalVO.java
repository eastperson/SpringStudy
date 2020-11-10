package com.dealight.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreEvalVO {
	
	// 매장번호 
    private long storeId;

    // 평균평점 
    private double avgRating;

    // 리뷰수 
    private int revwTotNum;

    // 좋아요합계 
    private int likeTotNum;

}
