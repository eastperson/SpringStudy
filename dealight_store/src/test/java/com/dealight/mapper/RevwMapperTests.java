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
import com.dealight.domain.RevwVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RevwMapperTests {
	
	// 필수 입력값
    private long id = 1;
    private long storeId = 13;
    private String userId = "kjuioq";
    private String cnts = "너무 맛있어용~";
    private Date regDt = new Date(); 
    private double rating = 5.5;
    private String replyCnts = "또 시켜주세요~";
    private Date replyRegDt = new Date();
    
    // 선택 입력값
    private long rsvdId = 1;
    private long waitId = 1;
    
    @Autowired
    private RevwMapper mapper;
    
    // create
    @Test
    public void insertTest1() {
    	RevwVO review = new RevwVO().builder()
				.storeId(storeId)
				.userId(userId)
				.cnts(cnts)
				.regDt(regDt)
				.rating(rating)
				.replyCnts(replyCnts)
				.replyRegDt(replyRegDt)
				.build();
    	
    	List<RevwVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insert(review);

    	list = mapper.findAll();
    	
    	assertTrue(list.size() == bf + 1);
    	
    }
    
    // create
    @Test
    public void insertSelectKeyTest1() {
    	RevwVO review = new RevwVO().builder()
				.storeId(storeId)
				.userId(userId)
				.cnts(cnts)
				.regDt(regDt)
				.rating(rating)
				.replyCnts(replyCnts)
				.replyRegDt(replyRegDt)
				.build();
    	
    	List<RevwVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insertSelectKey(review);

    	list = mapper.findAll();
    	
    	assertTrue(list.size() == bf + 1);
    	
    	assertTrue(list.get(list.size()-1).getId() == review.getId());
    	
    }
    
    // read
    @Test
    public void findTest1() {
    	
    	RevwVO revw = mapper.findById(22);
    	
    	assertNotNull(revw);
    	
    }
    
    
    // read list
    @Test
    public void findAllTest1() {
    	List<RevwVO> list = mapper.findAll();
    	
    	log.info(list);
    	
    	assertNotNull(list);

    	
    }
    
    
    // update
    @Test
    public void updateTest1() {
    	RevwVO review = new RevwVO().builder()
				.id(22)
				.storeId(storeId)
				.userId(userId)
				.cnts(cnts)
				.regDt(regDt)
				.rating(rating)
				.replyCnts("수정")
				.replyRegDt(replyRegDt)
				.build();
    	
    	String bf = mapper.findById(22).getReplyCnts();
    	
    	int result = mapper.update(review);
    	
    	assertTrue(result == 1);
    	
    	review = mapper.findById(22);
    	
    	assertTrue(!review.getReplyCnts().equals(bf));
    	
    	review.setReplyCnts(bf);
    	
    	result = mapper.update(review);
    	
    	assertTrue(result == 1);

    	
    }
    
    // delete
    @Test
    public void deleteTest1() {
    	
    	int result = mapper.delete(22);
    	
    	assertTrue(result == 1);
    	
    }

}
