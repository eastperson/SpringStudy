package com.dealight.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import lombok.NonNull;

public class ReservationDetailVOTests {

	//�ʼ� �Է°�
    private long rsvdId = 1;
    private long rsvdSeq = 1;
    private String menuNm = "���";
    private int menuTotQty = 5;
    private int menuPrc = 3000;
	
	// 1. �ʼ� �Է°��� �Է��ϰ� ���尴ü�� ������ �� �ִ���.
	@Test
	public void reservationDetailGenerateTest1() {
		
		ReservationDetailVO rsvdDtls = new ReservationDetailVO.ReservationDetailVOBuilder()
				.rsvdId(rsvdId)
				.rsvdSeq(rsvdSeq)
				.menuNm(menuNm)
				.menuTotQty(menuTotQty)
				.menuPrc(menuPrc)
				.build();
		
		assertTrue(rsvdDtls.getRsvdId() == rsvdId);
		assertTrue(rsvdDtls.getRsvdSeq() == rsvdSeq);
		assertTrue(rsvdDtls.getMenuNm().equals(menuNm));
		assertTrue(rsvdDtls.getMenuTotQty() == menuTotQty);
		assertTrue(rsvdDtls.getMenuPrc() == menuPrc);
		
		
	}

}
