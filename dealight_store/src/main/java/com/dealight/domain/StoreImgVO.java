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
public class StoreImgVO {
	
	 // �����ȣ 
    private long storeId;

    // ÷�λ����Ϸù�ȣ 
    private long imgSeq;

    // ��������ּ� 
    private String imgUrl;

}