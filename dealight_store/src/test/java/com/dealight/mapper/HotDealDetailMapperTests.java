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

import com.dealight.domain.BUserVO;
import com.dealight.domain.HotDealDetailVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HotDealDetailMapperTests {
	
    private long htdlId = 4;
    private long htdlSeq = 1;
    private String menuName = "µ·±î½º";
    private int menuPrice = 3000;
    
    @Autowired
    private HotDealDetailMapper mapper;
    
    // create
    @Test
    public void insertTest1() {
    	HotDealDetailVO htdlDtls = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName(menuName)
				.menuPrice(menuPrice)
				.build();
    	
    	HotDealDetailVO ht = mapper.findBySeq(htdlSeq);
    	
    	assertNull(ht);
    	
    	List<HotDealDetailVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insert(htdlDtls);
    	
    	list = mapper.findAll();
    	
    	assertTrue(list.size() == bf + 1);
    	
    }
    
    @Test
    public void insertSelectTest1() {
    	HotDealDetailVO htdlDtls = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName(menuName)
				.menuPrice(menuPrice)
				.build();
    	
    	HotDealDetailVO ht = mapper.findBySeq(htdlSeq);
    	
    	assertNull(ht);
    	
    	List<HotDealDetailVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insertSelectKey(htdlDtls);
    	
    	list = mapper.findAll();
    	
    	assertTrue(list.size() == bf + 1);
    	
    	assertTrue(list.get(list.size()-1).getHtdlSeq() == htdlDtls.getHtdlSeq());
    	
    	log.info(htdlDtls);
    }
    
    // read
    @Test
    public void findTest1() {
    	
    	HotDealDetailVO ht = mapper.findBySeq(9);
    	
    	assertNotNull(ht);
    	
    }
    
    
    // read list
    @Test
    public void findAllTest1() {
    	
    	List<HotDealDetailVO> list = mapper.findAll();
    	
    	log.info(list);
    	
    	assertNotNull(list);
    	
    }
    
    
    // update
    @Test
    public void updateTest1() {
    	HotDealDetailVO htdlDtls = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName("¼öÁ¤")
				.menuPrice(menuPrice)
				.build();
    	
    	int result = mapper.update(htdlDtls);
  
    	assertTrue(result == 1);
    	
   
    	HotDealDetailVO htdl = mapper.findBySeq(htdlSeq);
    	htdl.setMenuName(menuName);
    	
    	result = mapper.update(htdlDtls);
    	
    	assertTrue(result == 1);
    	
    }
    
    
    // delete
    @Test
    public void deleteTest1() {
    	
    	HotDealDetailVO htdlDtls = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName(menuName)
				.menuPrice(menuPrice)
				.build();
    	
    	HotDealDetailVO ht = mapper.findBySeq(htdlSeq);
    	
    	assertNull(ht);
    	
    	mapper.insert(htdlDtls);
    	
    	ht = mapper.findBySeq(htdlSeq);
    	
    	assertNotNull(ht);
    	
    	int result = mapper.delete(htdlSeq);
    	
    	assertTrue(result == 1);
    	
    }

}
