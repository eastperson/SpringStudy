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
public class ReservationVO {
	
	// composition
	private ReservationDetailVO revdDtls;
	
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
