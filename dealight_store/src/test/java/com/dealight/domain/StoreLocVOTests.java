package com.dealight.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StoreLocVOTests {
	
	private long storeId = 13;
	private String addr = "аж╪р";
	private int lt = 90;
	private int lo = 30;
	
	@Test
	public void StoreLocGenerateTest1() {
		
		StoreLocVO sloc = new StoreLocVO.StoreLocVOBuilder()
				.addr(addr)
				.lt(lt)
				.lo(lo)
				.storeId(storeId)
				.build();
		
		assertNotNull(sloc);
		
		assertTrue(sloc.getStoreId() == storeId);
		assertTrue(sloc.getAddr().equals(addr));
		assertTrue(sloc.getLo() == lo);
		assertTrue(sloc.getLt() == lt);
		
		
	}

}
