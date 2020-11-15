//package com.dealight.mapper;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.dealight.domain.StoreLocVO;
//
//import lombok.Setter;
//import lombok.extern.log4j.Log4j;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
//public class StoreTagTests {
//	
//	@Setter(onMethod_ = @Autowired)
//	private StoreTagMapper mapper;
//	
//	private long storeId = 101;
//	private String tagNm = "еб╠в";
//	
//	@Test
//	public void updateTest1() {
//		
//		StoreLocVO loc = new StoreLocVO().builder()
//				.storeId(storeId)
//				.addr(addr)
//				.lt(lt)
//				.lo(lo)
//				.build();
//		
//		int result = mapper.update(loc);
//		
//		assertTrue(result == 1);
//	}
//
//}
