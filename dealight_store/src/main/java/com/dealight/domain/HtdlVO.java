package com.dealight.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HtdlVO {
	
	// composition
	private List<HtdlDtlsVO> htdlDtls;
	
	// �ֵ���ȣ 
	@NonNull
    private long htdlId;

    // �ֵ��̸�
	@NonNull
    private String name;

    // �����ȣ
	@NonNull
    private long storeId;

    // ������ 
	@NonNull
    private double dcRate;

    // �ֵ����۽ð�
	@NonNull
    private String startTm;

    // �ֵ������ð�
	@NonNull
    private String endTm;

    // �ֵ������ο�
	@NonNull
    private int lmtPnum;

    // �ֵ��Ұ� 
    private String intro;

    // �ֵ�����������
    @NonNull
    private int befPrice;

    // ���������ݾ�
    @NonNull
    private int ddct;

    // �ֵ����翹���ο�
    @NonNull
    private int curPnum;

    // �ֵ������ڵ�
    @NonNull
    @Builder.Default
    private String stusCd = "A";

}
