package com.dealight.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RsvdVOTests {
	

	// 필수입력값
    private long id = 1;
    private long storeId = 1;
    private String userId = "kjuioq";
    private int pnum = 30;
    private String time = "09:30";
    private String stusCd;
    private int totAmt = 30;
    private int totQty = 30;
    
    // 선택입력값
    private long htdlId = 2;
    private int aprvNo = 1111;

	// 1. 필수 입력값만 입력하고 매장객체가 생성될 수 있는지.
	@Test
	public void reservationGenerateTest1() {
		
		RsvdVO rsvd = new RsvdVO.RsvdVOBuilder()
				.id(id)
				.storeId(storeId)
				.userId(userId)
				.pnum(pnum)
				.time(time)
				.totAmt(totAmt)
				.totQty(totQty)
				.build();
		
		assertTrue(rsvd.getId() == id);
		assertTrue(rsvd.getStoreId() == storeId);
		assertTrue(rsvd.getUserId().equals(userId));
		assertTrue(rsvd.getPnum() == pnum);
		assertTrue(rsvd.getTime().equals(time));
		assertTrue(rsvd.getTotAmt() == totAmt);
		assertTrue(rsvd.getTotQty() == totQty);
		assertTrue(rsvd.getStusCd().equals("P"));
		
		assertTrue(rsvd.getHtdlId() == 0);
		assertTrue(rsvd.getAprvNo() == 0);
		
	}
	
	// 2. 모든입력값
	@Test
	public void reservationGenerateTest2() {
		
		RsvdVO rsvd = new RsvdVO.RsvdVOBuilder()
				.id(id)
				.storeId(storeId)
				.userId(userId)
				.pnum(pnum)
				.time(time)
				.totAmt(totAmt)
				.totQty(totQty)
				.htdlId(htdlId)
				.aprvNo(aprvNo)
				.build();
		
		assertTrue(rsvd.getId() == id);
		assertTrue(rsvd.getStoreId() == storeId);
		assertTrue(rsvd.getUserId().equals(userId));
		assertTrue(rsvd.getPnum() == pnum);
		assertTrue(rsvd.getTime().equals(time));
		assertTrue(rsvd.getTotAmt() == totAmt);
		assertTrue(rsvd.getTotQty() == totQty);
		assertTrue(rsvd.getStusCd().equals("P"));
		
		assertTrue(rsvd.getHtdlId() == htdlId);
		assertTrue(rsvd.getAprvNo() == aprvNo);
		
	}

}
