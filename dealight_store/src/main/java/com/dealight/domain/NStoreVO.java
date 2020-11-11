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
	
    // �����ȣ 
    @NonNull private long storeId;

    // �����ð� 
    // ���� biz tm
    private String bizTm;
    //@NonNull private String breakEntm;

    // �޴� 
    private String menu;

}
