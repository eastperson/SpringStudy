package com.dealight.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.WaitingVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WaitingMapperTests {
	
	//필수 입력값
    private long id = 1;
    private long storeId = 13;
    private Date waitRegTm = new Date();
    private int waitPnum = 30;
    private String custTelno = "010-0000-0000";
    private String custNm = "김동인"; 
    private String waitStusCd;
    
    // 선택입력값
    private String userId = "kjuioq";
    
    @Autowired
    private WaitingMapper mapper;
    
    // create
    @Test
    public void insertTest1() {
    	WaitingVO waiting = new WaitingVO().builder()
				.storeId(storeId)
				.waitRegTm(waitRegTm)
				.waitPnum(waitPnum)
				.custTelno(custTelno)
				.custNm(custNm)
				.build();
    	
    	List<WaitingVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insert(waiting);
    	
    	list = mapper.findAll();
    	
    	assertTrue(bf + 1 == list.size());
    	
    }
    
    // create
    @Test
    public void insertSelectKeyTest1() {
    	WaitingVO waiting = new WaitingVO().builder()
				.storeId(storeId)
				.waitRegTm(waitRegTm)
				.waitPnum(waitPnum)
				.custTelno(custTelno)
				.custNm(custNm)
				.build();
    	
    	List<WaitingVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insertSelectKey(waiting);
    	
    	list = mapper.findAll();
    	
    	assertTrue(bf + 1 == list.size());
    	
    	assertTrue(list.get(list.size()-1).getId() == waiting.getId());
    	
    }
    
    // read
    @Test
    public void findTest1() {
    	
    	WaitingVO waiting = mapper.findById(id);
    	
    	assertNotNull(waiting);
    	
    }
    
    // read
    // by store id
    @Test
    public void findByStoreIdTest1() {
    	
    	List<WaitingVO> list = mapper.findByStoreId(storeId);
    	
    	assertNotNull(list);
    	
    	list.stream().forEach(wait -> {
    		
    		assertTrue(wait.getStoreId() == storeId);
    		
    	});
    	
    }
    
    // read
    // by store id and stus_cd
    @Test
    public void findByStoreIdAndStusCdTest1() {
    	
    	// C
    	List<WaitingVO> list = mapper.findByStoreIdAndStusCd(storeId, waitStusCd);
    	
    	assertNotNull(list);
    	
    	list.stream().forEach(wait -> {
    		
    		assertTrue(wait.getStoreId() == storeId);
    		assertTrue(wait.getWaitStusCd().equalsIgnoreCase("C"));
    		
    	});
    	
    }
    
    // read
    // by store id and date
    @Test
    public void findByStoreIdAndDateTest1() {
    	
    	String date = "20201107";
    	
    	List<WaitingVO> list = mapper.findByStoreIdAndDate(storeId, date);
    	
    	assertNotNull(list);
    	
    	String pattern = "yyyyMMdd";
    	
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	
    	list.stream().forEach(wait -> {
    		
    		assertTrue(wait.getStoreId() == storeId);
    		assertTrue(simpleDateFormat.format(wait.getWaitRegTm()).equals(date));
    		
    	});
    	
    }
    
    // read list
    @Test
    public void findAllTest1() {
    	List<WaitingVO> list = mapper.findAll();
    	
    	log.info(list);
    	
    	assertNotNull(list);

    	
    }
    
    
    // update
    @Test
    public void updateTest1() {
    	WaitingVO waiting = new WaitingVO().builder()
				.id(id)
				.storeId(storeId)
				.waitRegTm(waitRegTm)
				.waitPnum(waitPnum)
				.custTelno("수정")
				.custNm(custNm)
				.build();

    	String bf = mapper.findById(id).getCustTelno();
    	
    	int result = mapper.update(waiting);
    	
    	assertTrue(result == 1);
    	
    	waiting = mapper.findById(id);
    	
    	assertTrue(!waiting.getCustTelno().equals(bf));
    	
    	waiting.setCustTelno(bf);
    	
    	result = mapper.update(waiting);
    	
    	assertTrue(result == 1);
    	
    }
    
    // delete
    @Test
    public void deleteTest1() {
    	
    	int result = mapper.delete(21);
    	
    	assertTrue(result==1);
    	
    	
    	
    }
    
    @Test
    public void findByUserIdAndStusCd() {
    	
    	String userId = "kjuioq";
    	String waitStusCd = "C";
    	
    	List<WaitingVO> list = mapper.findByUserId(userId, waitStusCd);
    	
    	log.info(list);
    	
    	assertNotNull(list);
    }
    
    @Test
    public void changeWaitStusCdTest1() {
    	
    	String waitStusCd = "W";
    	
    	id = 58;
    	
    	WaitingVO wait = mapper.findById(id);
    	
    	log.info(wait);
    	
    	int result = mapper.changeWaitStusCd(wait.getId(), waitStusCd);
    	
    	assertTrue(result==1);
    	
    	wait = mapper.findById(id);
    	
    	log.info(wait);
    	
    	assertTrue(wait.getWaitStusCd().equals(waitStusCd));
    	
    	
    }

}
