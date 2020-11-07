package com.dealight.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.HotDealResultVO;
import com.dealight.domain.HotDealVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HotDealServiceTests {
	
	long htdlId = 29;
	long storeId = 13;

	@Autowired
	private HotDealService hotDealService;
	
	@Test
	public void DITest() {
		
		log.info(hotDealService);
		
	}
	
	@Test
	public void readByHtdlTest() {
		
		HotDealVO htdl = hotDealService.read(htdlId);
		
		assertNotNull(htdl);
		
	}
	
	@Test
	public void readDtlsByHtdlIdTest() {
		
		List<HotDealDetailVO> list = hotDealService.readDtls(htdlId);
		
		assertNotNull(list);
		
		list.stream().forEach(htdlDtls -> {
			
			assertTrue(htdlDtls.getHtdlId() == htdlId);
			
		});
	}
	
	@Test
	public void readRsltTest1() {
		
		htdlId = 4;
		
		HotDealResultVO htdlRslt = hotDealService.readRslt(htdlId);
		
		assertNotNull(htdlRslt);
		
	}
	
	@Test
	public void calHtdlEndTmTest1() {
		
		HotDealVO htdl = hotDealService.read(htdlId);
		
		int result = hotDealService.calHtdlEndTm(htdl);
		
		log.info("ÇÖµô ¸¶°¨ ½Ã°£ : " + result);
		
	}
	
	@Test
	public void readAllStoreHtdlListTest1() {
		
		List<HotDealVO> list = hotDealService.readAllStoreHtdlList(storeId);
		
		assertNotNull(list);
		
		list.stream().forEach(htdl -> {
			
			assertTrue(htdl.getStoreId() == storeId);
			
		});
	}
	
	@Test
	public void readActStoreHtdlListTest1() {
		
		List<HotDealVO> list = hotDealService.readActStoreHtdlList(storeId);
		
		assertNotNull(list);
		
		list.stream().forEach(htdl -> {
			
			assertTrue(htdl.getStoreId() == storeId);
			assertTrue(htdl.getStusCd().equals("A"));
			
		});
		
	}
	
}
