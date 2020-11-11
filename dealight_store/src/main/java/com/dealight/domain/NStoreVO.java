package com.dealight.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NStoreVO{
	
    // 매장번호 
    @NonNull private long storeId;

    // 영업시간 
    // 수정 biz tm
    private String bizTm;
    //@NonNull private String breakEntm;

    // 메뉴 
    private String menu;

}
