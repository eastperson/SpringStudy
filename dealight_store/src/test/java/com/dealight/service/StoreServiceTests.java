package com.dealight.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dealight.domain.AllStoreVO;
import com.dealight.domain.BStoreVO;
import com.dealight.domain.StoreVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StoreServiceTests {

	@Autowired
	private StoreService storeService;
	
	String userId = "kjuioq";
	long storeId = 13;
	
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
		String seatStusCd = "B";
		
		String stus = storeService.getCurSeatStus(storeId);
		
		log.info(stus);
		
		assertTrue(storeService.changeSeatStus(storeId, seatStusCd));
		
		stus = storeService.getCurSeatStus(storeId);
		
		log.info(stus);
		
		assertTrue(stus.equals(seatStusCd));
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
	
	@Test
	public void getStoreListByUserIdTest1() {
		
		List<StoreVO> list = storeService.getStoreListByUserId(userId);
		
		log.info(list);
		
		list.stream().forEach(store -> {
			assertNotNull(store.getBstore());
			assertTrue(store.getBstore().getBuserId().equals(userId));
			
		});
	}
	
	@Test
	public void findByStoreIdWithBStoreTest() {
		
		StoreVO store = storeService.findByStoreIdWithBStore(storeId);
		
		log.info(store);
		
		assertNotNull(store);
		
		assertTrue(store.getStoreId() == storeId);
		
	}
	
	@Test
	public void registerStoreTest1() {
		
		
	}
	
	@Test
	public void modifyStoreTest1() {
		
		StoreVO store = storeService.getStore(storeId);
		
		log.info(store);
		
		store.setStoreNm("수정");
		
		assertTrue(storeService.modifyStore(store));
		
		store = storeService.findByStoreIdWithBStore(storeId);
		
		log.info(store);
		
	}
	
	@Test
	public void modifyBStoreTest1() {
		
		StoreVO store = storeService.findByStoreIdWithBStore(storeId);
		
		log.info(store);
		
		store.getBstore().setHldy("수정");
		
		assertTrue(storeService.modifyStore(store));
		
		store = storeService.findByStoreIdWithBStore(storeId);
		
		log.info(store);
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void registerStoreAndBStoreTest2() throws Exception {
		
		BStoreVO bstore = new BStoreVO().builder()
				.closeTm("22:00")
				.storeIntro("안녕하세요!")
				.openTm("09:00")
				.buserId("aaa")
				.build();
		
		StoreVO store = new StoreVO.Builder(-1, "대머리칼국수", "000-0000-1321")
				.setBStore(bstore)
				.build();
		
		storeService.registerStoreAndBStore(store);

		
	}
	
	@Test
	public void findAllStoreByStoreIdTest1() {
		
		storeId = 101;
		
		AllStoreVO allStore = storeService.findAllStoreInfoByStoreId(storeId);
		
		assertNotNull(allStore);
		
		log.info(allStore);
		
	}
}
