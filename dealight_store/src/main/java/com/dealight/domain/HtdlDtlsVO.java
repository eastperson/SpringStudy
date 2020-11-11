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
public class HtdlDtlsVO {
	
    // �ֵ���ȣ
	@NonNull
    private long htdlId;

    // �ֵ����Ϸù�ȣ
	@NonNull
    private long htdlSeq;

    // �ֵ��޴��̸�
	@NonNull
    private String menuName;

    // �޴�����
	@NonNull
    private int menuPrice;

}
