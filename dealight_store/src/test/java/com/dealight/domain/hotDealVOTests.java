package com.dealight.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class hotDealVOTests {
	
	// 필수입력값
    private long hotdealId = 1;
    private String name = "돈까스세트";
    private long storeId = 1;
    private double dcRate = 0.5;
    private String startTm = "13:00";
    private String endTm = "14:00";
    private int lmtPnum = 40;
    private int befPrice = 15000; 
    private int ddct = 7500;
    private int curPnum = 25;
    
    // 기본값
    private String stusCd;
    
    //선택 입력값
    private String intro = "핫딜 고고";

    // 1. 필수입력값
	@Test
	public void hotDealGenerateTest1() {
		
		HotDealVO htdl = new HotDealVO.HotDealVOBuilder()
				.hotdealId(hotdealId)
				.name(name)
				.storeId(storeId)
				.dcRate(dcRate)
				.startTm(startTm)
				.endTm(endTm)
				.lmtPnum(lmtPnum)
				.befPrice(befPrice)
				.ddct(ddct)
				.curPnum(curPnum)
				.build();
		
		assertTrue(htdl.getHotdealId() == hotdealId);
		assertTrue(htdl.getName().equals(name));
		assertTrue(htdl.getStoreId() == storeId);
		assertTrue(htdl.getDcRate() == dcRate);
		assertTrue(htdl.getStartTm().equals(startTm));
		assertTrue(htdl.getEndTm().equals(endTm));
		assertTrue(htdl.getLmtPnum() == lmtPnum);
		assertTrue(htdl.getBefPrice() == befPrice);
		assertTrue(htdl.getDdct() == ddct);
		assertTrue(htdl.getCurPnum() == curPnum);
		assertTrue(htdl.getStusCd().equals("A"));
		assertNull(htdl.getIntro());
		
	}
	
	 // 1. 모든입력값
		@Test
		public void hotDealGenerateTest2() {
			
			HotDealVO htdl = new HotDealVO.HotDealVOBuilder()
					.hotdealId(hotdealId)
					.name(name)
					.storeId(storeId)
					.dcRate(dcRate)
					.startTm(startTm)
					.endTm(endTm)
					.lmtPnum(lmtPnum)
					.befPrice(befPrice)
					.ddct(ddct)
					.curPnum(curPnum)
					.intro(intro)
					.build();
			
			assertTrue(htdl.getHotdealId() == hotdealId);
			assertTrue(htdl.getName().equals(name));
			assertTrue(htdl.getStoreId() == storeId);
			assertTrue(htdl.getDcRate() == dcRate);
			assertTrue(htdl.getStartTm().equals(startTm));
			assertTrue(htdl.getEndTm().equals(endTm));
			assertTrue(htdl.getLmtPnum() == lmtPnum);
			assertTrue(htdl.getBefPrice() == befPrice);
			assertTrue(htdl.getDdct() == ddct);
			assertTrue(htdl.getCurPnum() == curPnum);
			assertTrue(htdl.getStusCd().equals("A"));
			assertTrue(htdl.getIntro().equals(intro));
			
		}

}
