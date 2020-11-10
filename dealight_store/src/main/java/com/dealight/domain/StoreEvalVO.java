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
	
	// �����ȣ 
    private long storeId;

    // ������� 
    private double avgRating;

    // ����� 
    private int revwTotNum;

    // ���ƿ��հ� 
    private int likeTotNum;

}
