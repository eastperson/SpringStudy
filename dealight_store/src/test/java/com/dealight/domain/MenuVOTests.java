package com.dealight.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuVOTests {
	
	// 필수 입력값
    private long storeId = 1;
    private long menuSeq = 1;
    private int price = 5000;
    private String name = "돈까스"; 
    private String recoMenu;

    //선택 입력값
    private String imgUrl = "/a.jpg";

	// 1. 필수 입력값만 입력하고 매장객체가 생성될 수 있는지.
	// not null 값만 입력
	// 필수값 : storeId, menuSeq, price, name
	// 기본값 : recoMenu
	@Test
	public void menuGenerateTest1() {
		MenuVO menu = new MenuVO.MenuVOBuilder()
				.storeId(storeId)
				.menuSeq(menuSeq)
				.price(price)
				.name(name)
				.build();
		
		assertTrue(menu.getStoreId() == storeId);
		assertTrue(menu.getMenuSeq() == menuSeq);
		assertTrue(menu.getPrice() == price);
		assertTrue(menu.getName().equals(name));
		assertTrue(menu.getRecoMenu().equals("N"));
		
		assertNull(menu.getImgUrl());
		assertNotNull(menu);
	}
	
	// 2. 모든 입력값
	@Test
	public void menuGenerateTest2() {
		MenuVO menu = new MenuVO.MenuVOBuilder()
				.storeId(storeId)
				.menuSeq(menuSeq)
				.price(price)
				.name(name)
				.imgUrl(imgUrl)
				.build();
		
		assertTrue(menu.getStoreId() == storeId);
		assertTrue(menu.getMenuSeq() == menuSeq);
		assertTrue(menu.getPrice() == price);
		assertTrue(menu.getName().equals(name));
		assertTrue(menu.getRecoMenu().equals("N"));
		assertTrue(menu.getImgUrl().equals(imgUrl));
		
		assertNotNull(menu);
	}

}
