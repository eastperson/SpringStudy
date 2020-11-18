package com.dealight.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.WaitingVO;
import com.dealight.mapper.WaitMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WaitingServiceTests {

	@Autowired
	private WaitingService waitingService;
	
	@Autowired
	private WaitMapper waitMapper;
	
	
	@Test 
	public void DITest1(){
		
		assertNotNull(waitingService);
	}
	
	private long waitingId = 24;
	private String userId = "kjuioq";
	private long storeId = 13;
	
	@Test
	public void readByIdTest() {
		
		WaitingVO wait = waitingService.read(waitingId);
		
		assertNotNull(wait);
		
	}
	
	@Test
	public void registerOnWaitingTest1() {
		
		WaitingVO waiting = new WaitingVO().builder()
				.storeId(13)
				.userId("a")
				.waitPnum(3)
				.waitRegTm(new Date())
				.custTelno("010-2737-3333")
				.custNm("����")
				.waitStusCd("W")
				.build();
		
		waitingService.registerOnWaiting(waiting);
		
		long result = waiting.getId();
		log.info("size.................................."+waitMapper.findAll().size());
		log.info("result................................"+result);
		
		//assertTrue(result == 49);
		
	}
	
	@Test
	public void isCurWaitingUserTest() {
		
		assertTrue(waitingService.isCurWaitingUser(userId));
		
	}
	
	@Test
	public void isCurPanaltyUserTest1() {
		
		assertTrue(!waitingService.isCurPanaltyUser(userId));
	}
	
	@Test
	public void isPossibleWaitingUserTest1() {
		
		userId = "aaa";
		
		assertTrue(waitingService.isPossibleWaitingUser(userId));
	}
	
	@Test
	public void registerOffWaitingTest1() {
		
		WaitingVO waiting = new WaitingVO().builder()
				.storeId(13)
				.waitPnum(3)
				.waitRegTm(new Date())
				.custTelno("010-2737-3333")
				.custNm("����մ�")
				.waitStusCd("W")
				.build();
		
		waitingService.registerOffWaiting(waiting);
		
		long result = waiting.getId();
		
	}
	
	@Test
	public void cancelWaitingTest1() {
		
		assertTrue(waitingService.cancelWaiting(waitingId));
		
		assertTrue(waitingService.read(waitingId).getWaitStusCd().equals("C"));
	}
	
	@Test
	public void enterWatingTest1() {
		
		assertTrue(waitingService.enterWaiting(waitingId));
		
		assertTrue(waitingService.read(waitingId).getWaitStusCd().equals("E"));
	}
	
	@Test
	public void panaltyWaitingTest1() {
		
		assertTrue(waitingService.panaltyWaiting(waitingId));
		
		assertTrue(waitingService.read(waitingId).getWaitStusCd().equals("P"));
	}
	
	@Test
	public void allStoreWaitListTest1() {
		
		List<WaitingVO> list = waitingService.allStoreWaitList(storeId);
		
		assertNotNull(list);
		
		list.stream().forEach(wait -> {
			assertTrue(wait.getStoreId() == storeId);
		});

	}
	
	@Test
	public void curStoreWaitListTest1() {
		
		List<WaitingVO> list = waitingService.curStoreWaitList(storeId, "C");
		
		assertNotNull(list);
		
		list.stream().forEach(wait -> {
			assertTrue(wait.getStoreId() == storeId);
			assertTrue(wait.getWaitStusCd().equalsIgnoreCase("C"));
		});
	}
	
	@Test
	public void calWatingOrderTest1() {
		
		List<WaitingVO> list = waitingService.curStoreWaitList(storeId, "W");
		
		log.info(list);
		
		int result = waitingService.calWatingOrder(list, 25);
		
		log.info("result..................... : " + result);
		
	}
	
	@Test
	public void calWaitingTimeTest1() {
		
		List<WaitingVO> list = waitingService.curStoreWaitList(storeId, "W");
		
		int result = waitingService.calWaitingTime(list, waitingId, 30);
	
		log.info("result..................... : " + result);
		
	}
	
	@Test
	public void readNextWaitTest() {
		
		long storeId = 13;
		
		List<WaitingVO> curStoreWaitiList = waitingService.curStoreWaitList(storeId, "W");
		
		log.info(curStoreWaitiList);
		
		WaitingVO wait = waitingService.readNextWait(curStoreWaitiList);
		
		log.info(wait);
	}
	
}
