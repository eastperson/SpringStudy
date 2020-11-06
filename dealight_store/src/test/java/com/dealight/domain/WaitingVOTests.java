package com.dealight.domain;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class WaitingVOTests {
	
	//필수 입력값
    private long id = 1;
    private long storeId = 1;
    private Date waitRegTm = new Date();
    private int waitPnum = 30;
    private String custTelno = "010-0000-0000";
    private String custNm = "김동인"; 
    private String waitStusCd;
    
    // 선택입력값
    private String userId = "kjuioq";


	// 1. 필수 입력값만 입력하고 매장객체가 생성될 수 있는지.
	// not null 값만 입력
	// 필수값 : id, storeId, waitRegTm, waitPnum,custTelno,custNm,waitStusCd
	// 선택값 : userId
	@Test
	public void waitingGenerateTest1() {
		WaitingVO waiting = new WaitingVO.WaitingVOBuilder()
				.id(id)
				.storeId(storeId)
				.waitRegTm(waitRegTm)
				.waitPnum(waitPnum)
				.custTelno(custTelno)
				.custNm(custNm)
				.build();
		
		assertTrue(waiting.getId() == id);
		assertTrue(waiting.getStoreId() == storeId);
		assertTrue(waiting.getWaitRegTm().equals(waitRegTm));
		assertTrue(waiting.getWaitPnum() == waitPnum);
		assertTrue(waiting.getCustTelno().equals(custTelno));
		assertTrue(waiting.getCustNm().equals(custNm));
		assertTrue(waiting.getWaitStusCd().equals("W"));
		
		assertNull(waiting.getUserId());
		
	}
	
	// 2. 모든 입력값
	@Test
	public void waitingGenerateTest2() {
		WaitingVO waiting = new WaitingVO.WaitingVOBuilder()
				.id(id)
				.storeId(storeId)
				.waitRegTm(waitRegTm)
				.waitPnum(waitPnum)
				.custTelno(custTelno)
				.custNm(custNm)
				.userId(userId)
				.build();
		
		assertTrue(waiting.getId() == id);
		assertTrue(waiting.getStoreId() == storeId);
		assertTrue(waiting.getWaitRegTm().equals(waitRegTm));
		assertTrue(waiting.getWaitPnum() == waitPnum);
		assertTrue(waiting.getCustTelno().equals(custTelno));
		assertTrue(waiting.getCustNm().equals(custNm));
		assertTrue(waiting.getWaitStusCd().equals("W"));
		assertTrue(waiting.getUserId().equals(userId));
		
	}

}
