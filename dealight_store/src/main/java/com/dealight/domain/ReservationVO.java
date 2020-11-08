package com.dealight.domain;

import java.util.Date;
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
public class ReservationVO {
	
	// composition
	private List<ReservationDetailVO> rsvdDtlsList;
	
    // �����ȣ 
	@NonNull
    private long id;

    // �����ȣ
	@NonNull
    private long storeId;

    // ȸ�����̵�
	@NonNull
    private String userId;

    // �ֵ���ȣ 
    private long htdlId;

    // �������ι�ȣ 
    private int aprvNo;

    // �����ο�
    @NonNull
    private int pnum;

    // ����ð�
    @NonNull
    private String time;

    // ��������ڵ�
    @NonNull
    @Builder.Default
    private String stusCd = "P";

    // �����Ѿ�
    @NonNull
    private int totAmt;

    // �Ѹ޴�����
    @NonNull
    private int totQty;
    
    private Date inDate;

}
