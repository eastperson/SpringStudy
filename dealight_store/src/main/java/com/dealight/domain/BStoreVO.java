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
public class BStoreVO {
	
    // �����ȣ 
    @NonNull private long storeId;

    // �����ȸ�����̵� 
    private String buserId;

    // ���������ڵ� 
    @Builder.Default
    @NonNull private String seatStusCd = "B";

    // �������۽ð� 
    @NonNull private String openTm;

    // ��������ð� 
    @NonNull private String closeTm;

    // �극��ũŸ�Խ��۽ð� 
    private String breakSttm;

    // �극��ũŸ������ð� 
    private String breakEntm;

    // ��Ʈ�����ð� 
    private String lastOrdTm;

    // 1�����̺��� 
    private int n1SeatNo;

    // 2�����̺��� 
    private int n2SeatNo;

    // 4�����̺��� 
    private int n4SeatNo;

    // ����Ұ� 
    private String storeIntro;

    // ������սĻ�ð� 
    private int avgMealTm;

    // �����޹��� 
    private String hldy;

    // �����ο� 
    private int acmPnum;
	
	

}
