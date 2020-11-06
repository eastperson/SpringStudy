package com.dealight.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.NStoreVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NStoreMapperTests {
	
	// nstore 객체
	private long storeId = 1;
	private String breakEntm = "21:00";
	private String menu = "돈까스";
	
	// store 객체
    private String storeNm = "영동족발";
    private String telno = "010-2737-5157";
    private String clsCd = "I";
    
    @Autowired
    private NStoreMapper mapper;
    
	// mapper 잘 주입되었는지 DI 테스트
	@Test
	public void mapperDItest() {
		log.info("mapper DI test : " + mapper);
	}
    
    @Test
    public void findByStoreIdTest() {
    	
    	NStoreVO nstore = mapper.findByStoreId(1);
    	
    	assertNotNull(nstore);
    	
    	log.info(nstore);
    	
    }
    
    @Test
    public void findAllTest() {
    	
    	List<NStoreVO> list = mapper.findAll();
    	
    	assertNotNull(list);
    	
    	log.info(list);
    	
    }
    
    @Test
    public void insertNStoreTest1() {
    	
		NStoreVO nstore = new NStoreVO().builder()
				.storeId(storeId)
				.breakEntm(breakEntm)
				.menu(menu)
				.build();
		
		
		log.info(nstore);
		
		mapper.insert(nstore);
    	
    }
    
    @Test
    public void updateNStoreTest1() {
    	
		NStoreVO nstore = new NStoreVO().builder()
				.storeId(storeId)
				.breakEntm("13:00")
				.menu(menu)
				.build();
		
		log.info(nstore);
		
		String bf = mapper.findByStoreId(storeId).getBreakEntm();
		
		int result = -100;
		if(!bf.equals(nstore.getBreakEntm()))
			result = mapper.update(nstore);
		if(bf.equals(nstore.getBreakEntm())) {
			nstore.setBreakEntm("14:00");
			result = mapper.update(nstore);
		}
		
		assertTrue(result == 1);
		
		nstore = mapper.findByStoreId(storeId);
		
		
		log.info(nstore);
		
		assertTrue(!bf.equals(nstore.getBreakEntm()));
		
    	
    }
    
    @Test
    public void deleteNStoreTest1() {
    	
		NStoreVO nstore = new NStoreVO().builder()
				.storeId(14)
				.breakEntm("14:00")
				.menu(menu)
				.build();
    	
		mapper.insert(nstore);
		
		assertNotNull(mapper.findByStoreId(14));
		
		int result = mapper.delete(14);
		
		
		assertTrue(result == 1);
		
		assertNull(mapper.findByStoreId(14));
    }

}
