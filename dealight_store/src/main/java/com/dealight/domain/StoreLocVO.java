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

    // �����ȣ 
    private long storeId;

    // �����ּ� 
    private String addr;

    // ���� 
    private double lt;

    // �浵 
    private double lo;
}
