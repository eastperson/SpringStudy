package com.dealight.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.BUserVO;
import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.HotDealVO;
import com.dealight.domain.ReservationDetailVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HotDealDetailMapperTests {
	
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
    
	
    private long htdlId = 4;
    private long htdlSeq = 1;
    private String menuName = "돈까스";
    private int menuPrice = 3000;
    
    @Autowired
    private HotDealMapper htdlMapper;
    
    @Autowired
    private HotDealDetailMapper htdlDtlsMapper;
    
    // create
    @Test
    public void insertTest1() {
    	HotDealDetailVO htdlDtls = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName(menuName)
				.menuPrice(menuPrice)
				.build();
    	
    	HotDealDetailVO ht = htdlDtlsMapper.findBySeq(htdlSeq);
    	
    	assertNull(ht);
    	
    	List<HotDealDetailVO> list = htdlDtlsMapper.findAll();
    	
    	int bf = list.size();
    	
    	htdlDtlsMapper.insert(htdlDtls);
    	
    	list = htdlDtlsMapper.findAll();
    	
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
    	
    	HotDealDetailVO ht = htdlDtlsMapper.findBySeq(htdlSeq);
    	
    	assertNull(ht);
    	
    	List<HotDealDetailVO> list = htdlDtlsMapper.findAll();
    	
    	int bf = list.size();
    	
    	htdlDtlsMapper.insertSelectKey(htdlDtls);
    	
    	list = htdlDtlsMapper.findAll();
    	
    	assertTrue(list.size() == bf + 1);
    	
    	assertTrue(list.get(list.size()-1).getHtdlSeq() == htdlDtls.getHtdlSeq());
    	
    	log.info(htdlDtls);
    }
    
    // read
    @Test
    public void findTest1() {
    	
    	HotDealDetailVO ht = htdlDtlsMapper.findBySeq(9);
    	
    	assertNotNull(ht);
    	
    }
    
    
    // read list
    @Test
    public void findAllTest1() {
    	
    	List<HotDealDetailVO> list = htdlDtlsMapper.findAll();
    	
    	log.info(list);
    	
    	assertNotNull(list);
    	
    }
    
    
    // update
    @Test
    public void updateTest1() {
    	HotDealDetailVO htdlDtls = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName("수정")
				.menuPrice(menuPrice)
				.build();
    	
    	int result = htdlDtlsMapper.update(htdlDtls);
  
    	assertTrue(result == 1);
    	
   
    	HotDealDetailVO htdl = htdlDtlsMapper.findBySeq(htdlSeq);
    	htdl.setMenuName(menuName);
    	
    	result = htdlDtlsMapper.update(htdlDtls);
    	
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
    	
    	HotDealDetailVO ht = htdlDtlsMapper.findBySeq(htdlSeq);
    	
    	assertNull(ht);
    	
    	htdlDtlsMapper.insert(htdlDtls);
    	
    	ht = htdlDtlsMapper.findBySeq(htdlSeq);
    	
    	assertNotNull(ht);
    	
    	int result = htdlDtlsMapper.delete(htdlSeq);
    	
    	assertTrue(result == 1);
    	
    }
    
    @Test
    public void insertRsvdDtls() {
    	
    	List<HotDealDetailVO> list = new ArrayList<>();
    	
    	int bf = htdlDtlsMapper.findAll().size();
    	
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
    	
    	
    	HotDealDetailVO htdlDtls = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName(menuName)
				.menuPrice(menuPrice)
				.build();

    	HotDealDetailVO htdlDtls2 = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName(menuName)
				.menuPrice(menuPrice)
				.build();
    	
    	HotDealDetailVO htdlDtls3 = new HotDealDetailVO().builder()
				.htdlId(htdlId)
				.htdlSeq(htdlSeq)
				.menuName(menuName)
				.menuPrice(menuPrice)
				.build();
    	
    	list.add(htdlDtls);
    	list.add(htdlDtls2);
    	list.add(htdlDtls3);
    	
    	
    	int result = htdlDtlsMapper.insertHtdlDtls(list);
    	
    	assertTrue(result == 3);
    	
    	log.info(result);
    	
    	assertTrue(bf + 3 == htdlDtlsMapper.findAll().size());
    	
    }

}
