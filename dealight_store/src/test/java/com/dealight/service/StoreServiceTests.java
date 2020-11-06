package com.dealight.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StoreServiceTests {


	
	@Test
	public void serviceDITest() {
		

		
	}
	/*
	
	@Test
	public void seatStusChangeTests1() {
		
		long storeId = 1;
		String seatStusCd = "G";
		
		String stus = storeService.getCurSeatStus(storeId);
		
		log.info(stus);
		
		storeService.changeSeatStus(storeId, seatStusCd);
		
		stus = storeService.getCurSeatStus(storeId);
		
		log.info(stus);
	}
	*/
}
