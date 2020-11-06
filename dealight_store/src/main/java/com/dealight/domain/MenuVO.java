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
public class MenuVO {
	
    // �����ȣ 
	@NonNull
    private long storeId;

    // �޴��Ϸù�ȣ
	@NonNull
    private long menuSeq;

    // �޴�����
	@NonNull
    private int price;

    // �޴������ּ� 
    private String imgUrl;

    // �޴��̸�
    @NonNull
    private String name;

    // ��õ���� 
    @Builder.Default
    @NonNull
    private String recoMenu = "N";

}
