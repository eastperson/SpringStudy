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
public class WaitingVO {
	
	// �����ù�ȣ
	@NonNull
    private long id;

    // �����ȣ 
    @NonNull
    private long storeId;

    // ȸ�����̵� 
    private String userId;

    // �����������ð� 
    @NonNull
    private Date waitRegTm;

    // �������ο�
    @NonNull
    private int waitPnum;

    // ������ó
    @NonNull
    private String custTelno;

    // ���̸�
    @NonNull
    private String custNm;

    // �����û����ڵ�
    @NonNull
    @Builder.Default
    private String waitStusCd = "W";

}
