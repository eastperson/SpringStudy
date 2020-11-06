package com.dealight.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.BUserVO;
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

}
