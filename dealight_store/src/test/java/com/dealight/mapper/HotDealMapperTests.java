package com.dealight.mapper;

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

import com.dealight.domain.BUserVO;
import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.HotDealVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HotDealMapperTests {
	
	// 필수입력값
    private long hotdealId = 1;
    private String name = "돈까스세트";
    private long storeId = 13;
    private double dcRate = 0.5;
    private String startTm = "13:00";
    private String endTm = "14:00";
    private int lmtPnum = 40;
    private int befPrice = 15000; 
    private int ddct = 7500;
    private int curPnum = 25;
    
    // 기본값
    private String stusCd;
    
    //선택 입력값
    private String intro = "핫딜 고고";
    
    @Autowired
    private HotDealMapper mapper;
    
    // create
    @Test
    public void insertTest1() {
    	HotDealVO htdl = new HotDealVO().builder()
				.hotdealId(hotdealId)
				.name(name)
				.storeId(storeId)
				.dcRate(dcRate)
				.startTm(startTm)
				.endTm(endTm)
				.lmtPnum(lmtPnum)
				.befPrice(befPrice)
				.ddct(ddct)
				.curPnum(curPnum)
				.build();
    	
    	List<HotDealVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insert(htdl);

    	assertTrue(mapper.findAll().size() == bf +1);
    	
    	
    }
    
    // create
    @Test
    public void insertSelectKeyTest1() {
    	HotDealVO htdl = new HotDealVO().builder()
				.name(name)
				.storeId(storeId)
				.dcRate(dcRate)
				.startTm(startTm)
				.endTm(endTm)
				.lmtPnum(lmtPnum)
				.befPrice(befPrice)
				.ddct(ddct)
				.curPnum(curPnum)
				.build();
    	
    	List<HotDealVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insertSelectKey(htdl);
    	
    	list = mapper.findAll();

    	assertTrue(mapper.findAll().size() == bf +1);
    	
    	assertTrue(list.get(list.size()-1).getHotdealId() == htdl.getHotdealId());
    	
    	log.info(htdl);
    	
    	
    }
    
    // read
    @Test
    public void findByIdTest1() {
    	

    	HotDealVO htdl = mapper.findById(2);
    	
    	assertNotNull(htdl);
    	
    }
    
    // read
    // by store id
    @Test
    public void findByStoreIdTest1() {
    	

    	List<HotDealVO> list = mapper.findByStoreId(storeId);
    	
    	assertNotNull(list);
    	
    }
    
    // read
    // by store id and stus cd
    @Test
    public void findByStoreStusCdIdTest1() {
    	

    	List<HotDealVO> list = mapper.findByStoreIdStusCd(storeId, "A");
    	
    	assertNotNull(list);
    	
    }
    
    
    // read list
    @Test
    public void findAllTest1() {
    	List<HotDealVO> list = mapper.findAll();
    	
    	log.info(list);
    	
    	assertNotNull(list);

    	
    }
    
    
    // update
    @Test
    public void updateTest1() {
    	HotDealVO htdl = new HotDealVO().builder()
				.hotdealId(2)
				.name("수정")
				.storeId(storeId)
				.dcRate(dcRate)
				.startTm(startTm)
				.endTm(endTm)
				.lmtPnum(lmtPnum)
				.befPrice(befPrice)
				.ddct(ddct)
				.curPnum(curPnum)
				.build();
    	
    	String bf = mapper.findById(2).getName();
    	
    	int result = mapper.update(htdl);
    	
    	assertTrue(result == 1);
    	
    	htdl = mapper.findById(2);
    	
    	assertTrue(!htdl.getName().equals(bf));
    	
    	htdl.setName(bf);
    	
    	mapper.update(htdl);

    	
    }
    
   
    // delete
    @Test
    public void deleteTest1() {
    	
    	
    	List<HotDealVO> list = mapper.findAll();
    	
    	HotDealVO htdl = list.get(list.size()-1);
    	
    	mapper.insert(htdl);
    	
    	htdl = list.get(list.size()-1);
    	
    	long id = htdl.getHotdealId();
    	
    	htdl = new HotDealVO().builder()
				.hotdealId(id+1)
				.name(name)
				.storeId(storeId)
				.dcRate(dcRate)
				.startTm(startTm)
				.endTm(endTm)
				.lmtPnum(lmtPnum)
				.befPrice(befPrice)
				.ddct(ddct)
				.curPnum(curPnum)
				.build();
    	
    	mapper.insert(htdl);
    	
    	int result = mapper.delete(id+1);
    	
    	assertTrue(result == 1);

    	
    }

}
