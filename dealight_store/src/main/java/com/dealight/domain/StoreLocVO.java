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
public class StoreLocVO {

    // 매장번호 
    private long storeId;

    // 매장주소 
    private String addr;

    // 위도 
    private double lt;

    // 경도 
    private double lo;
}
