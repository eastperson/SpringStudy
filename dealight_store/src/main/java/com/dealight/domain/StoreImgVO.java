package com.dealight.domain;

import java.util.Date;
import java.util.UUID;

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
	
	 // 매장번호 
    private long storeId;

    // 첨부사진일련번호 
    private long imgSeq;
    
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;

}
