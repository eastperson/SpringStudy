package com.dealight.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NStoreVOTests {

	// nstore 객체
	private long storeId = 1;
	private String breakEntm = "21:00";
	private String menu = "돈까스";
	
	// store 객체
    private String storeNm = "영동족발";
    private String telno = "010-2737-5157";
    private String clsCd = "I";


	// 1. 필수 입력값만 입력하고 매장객체가 생성될 수 있는지.
	// not null 값만 입력
	// 필수값 : storeId, breakEntm
	// 선택값 : menu
	@Test
	public void nstoreGenerateTest1() {
		NStoreVO nstore = new NStoreVO.NStoreVOBuilder()
				.storeId(storeId)
				.breakEntm(breakEntm)
				.build();

		assertTrue(nstore.getStoreId() == storeId);
		assertTrue(nstore.getBreakEntm().equals(breakEntm));
		assertNull(nstore.getMenu());
		assertNotNull(nstore);

	}

	// 2. 모든입력값
	@Test
	public void nstoreGenerateTest2() {
		NStoreVO nstore = new NStoreVO.NStoreVOBuilder()
				.storeId(storeId)
				.breakEntm(breakEntm)
				.menu(menu)
				.build();

		assertTrue(nstore.getStoreId() == storeId);
		assertTrue(nstore.getBreakEntm().equals(breakEntm));
		assertTrue(nstore.getMenu().equals(menu));
		assertNotNull(nstore);

	}

}
