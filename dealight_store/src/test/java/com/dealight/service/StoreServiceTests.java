package com.dealight.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.StoreVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StoreServiceTests {

	@Autowired
	private StoreService storeService;
	
	@Test
	public void serviceDITest() {
		
		log.info(storeService);
		
	}
	
	@Test
	public void getSeatStusTests1() {
		
		long storeId = 13;
		String seatStusCd = "G";
		
		String stus = storeService.getCurSeatStus(storeId);
		
		log.info(stus);
		
		stus.equals("G");
	}

	
	@Test
	public void seatStusChangeTests1() {
		
		long storeId = 13;
		String seatStusCd = "G";
		
		String stus = storeService.getCurSeatStus(storeId);
		
		log.info(stus);
		
		assertTrue(storeService.changeSeatStus(storeId, seatStusCd));
		
		stus = storeService.getCurSeatStus(storeId);
		
		log.info(stus);
	}
	
	@Test
	// @Transactional 롤백, 리드온리
	// @Rollback(false) 롤백이 안된다.
	public void getCurTests1() {
		
		log.info(storeService.getCurTime());
	}
	
	@Test
	public void getStore() {
		
		StoreVO store = storeService.getStore(13);
		
		assertNotNull(store);
	}
	
	@Test
	public void getBStore() {
		
		BStoreVO bstore = storeService.getBStore(13);
		
		assertNotNull(bstore);
		
	}
	
}
