package com.dealight.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AllStoreMapperTests {
	
	long storeId = 101;
	
	@Autowired
	private AllStoreMapper mapper;
	
	@Test
	public void DItest() {
		
		log.info(mapper);
		
	}
	
	@Test
	public void findAllStoreByStoreIdTests() {
		
		
		
	}

}
