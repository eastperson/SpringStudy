package com.dealight.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.BUserVO;
import com.dealight.domain.ReservationVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReservationMapperTests {
	
	// 필수입력값
    private long id = 6;
    private long storeId = 13;
    private String userId = "kjuioq";
    private int pnum = 30;
    private String time = "09:30";
    private String stusCd;
    private int totAmt = 30;
    private int totQty = 30;
    
    // 선택입력값
    private long htdlId = 10;
    private int aprvNo = 1111;
    
    @Autowired
    private ReservationMapper mapper;
    
    // create
    @Test
    public void insertTest1() {
    	ReservationVO rsvd = new ReservationVO().builder()
				.id(id)
				.storeId(storeId)
				.userId(userId)
				.htdlId(htdlId)
				.pnum(pnum)
				.time(time)
				.totAmt(totAmt)
				.totQty(totQty)
				.build();
    	
    	List<ReservationVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insert(rsvd);
    	
    	list = mapper.findAll();
    	
    	assertTrue(bf + 1 == list.size());

    	
    }
    
    // create
    @Test
    public void insertSelectKeyTest1() {
    	ReservationVO rsvd = new ReservationVO().builder()
				.id(id)
				.storeId(storeId)
				.userId(userId)
				.htdlId(htdlId)
				.pnum(pnum)
				.time(time)
				.totAmt(totAmt)
				.totQty(totQty)
				.build();
    	
    	List<ReservationVO> list = mapper.findAll();
    	
    	int bf = list.size();
    	
    	mapper.insertSelectKey(rsvd);
    	
    	list = mapper.findAll();
    	
    	assertTrue(bf + 1 == list.size());
    	
    	assertTrue(list.get(list.size()-1).getId() == rsvd.getId());

    	
    }
    
    // read
    @Test
    public void findTest1() {
    	

    	ReservationVO rsvd = mapper.findById(id);
    	
    	assertNotNull(rsvd);
    }
    
    
    // read list
    @Test
    public void findAllTest1() {
    	List<ReservationVO> list = mapper.findAll();
    	
    	log.info(list);
    	
    	assertNotNull(list);

    	
    }
    
    
    // update
    @Test
    public void updateTest1() {
    	ReservationVO rsvd = new ReservationVO().builder()
    			.id(id)
				.storeId(storeId)
				.userId(userId)
				.htdlId(htdlId)
				.pnum(pnum)
				.time("수정")
				.totAmt(totAmt)
				.totQty(totQty)
				.build();
    	
    	String bf = mapper.findById(id).getTime();

    	int result = mapper.update(rsvd);
    	
    	assertTrue(result == 1);
    	
    	rsvd = mapper.findById(id);
    	
    	assertTrue(!bf.equals(rsvd.getTime()));
    	
    	rsvd.setTime(bf);
    	
    	result = mapper.update(rsvd);
    	
    	assertTrue(result == 1);
    }
    
    // delete
    @Test
    public void deleteTest1() {
    	
    	int result = mapper.delete(id);
    	
    	assertTrue(result == 1);
    	
    }

}
