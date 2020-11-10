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
public class StoreTagVO {
	
    // �����ȣ 
    private long storeId;

    // �ؽ��±��̸� 
    private String tagNm;

}
