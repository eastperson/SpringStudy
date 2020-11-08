package com.dealight.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;

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
    
    // read
    @Test
    public void findByUserIdTest1() {
    	

    	List<ReservationVO> list = mapper.findByUserId(userId);
    	
    	assertNotNull(list);
    }
    
    
    // read list
    @Test
    public void findAllTest1() {
    	List<ReservationVO> list = mapper.findAll();
    	
    	log.info(list);
    	
    	assertNotNull(list);

    	
    }
    
    // read list
    // find by store
    @Test
    public void findRsvdListByStoreTest1() {
    	List<ReservationVO> list = mapper.findByStoreId(storeId);
    	
    	log.info(list);
    	
    	assertNotNull(list);
    	
    	list.forEach((rsvd) -> {
    		assertTrue(rsvd.getStoreId() == storeId);
    	});

    	
    }
    
    // read list
    // find by store and stus_cd
    @Test
    public void findRsvdListByStoreAndStusCdTest1() {
    	
    	String curStus = "P";
    	
    	List<ReservationVO> list = mapper.findByStoreIdAndCurStus(storeId, curStus);
    	
    	log.info(list);
    	
    	assertNotNull(list);
    	
    	list.forEach((rsvd) -> {
    		assertTrue(rsvd.getStoreId() == storeId);
    		assertTrue(rsvd.getStusCd().equals(curStus));
    	});

    	
    }
    
    // read list
    // find by store and today
    @Test
    public void findRsvdListByStoreTodayTest1() {

    	
    	LocalDate currentDate = LocalDate.now();
    	
    	log.info(currentDate);
    	
    	DateTimeFormatter dateTimeForMatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    	
    	String today = currentDate.format(dateTimeForMatter);
    	
    	log.info("today............................." + today);
    	
    	List<ReservationVO> list = mapper.findByStoreIdToday(storeId, today);
    	

    	log.info(list);
    	
    	assertNotNull(list);
    	
		String pattern = "yyyyMMdd";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	
    	list.forEach((rsvd) -> {
    		assertTrue(rsvd.getStoreId() == storeId);
    		assertTrue(simpleDateFormat.format(rsvd.getInDate()).equals(today));
    	});
    	 
    	
    }
    
    // read list
    // find by store and date
    @Test
    public void findRsvdListByStoreAndDateTest1() {
    	
    	String date = "20201107";
    	
    	List<ReservationVO> list = mapper.findByStoreIdToday(storeId, date);

    	log.info(list);
    	
    	assertNotNull(list);
    	
		String pattern = "yyyyMMdd";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	
    	list.forEach((rsvd) -> {
    		assertTrue(rsvd.getStoreId() == storeId);
    		assertTrue(simpleDateFormat.format(rsvd.getInDate()).equals(date));
    	});
    	 
    	
    }
    
    // read list
    // find by store and user
    @Test
    public void findRsvdListByStoreAndUserTest1() {
    	List<ReservationVO> list = mapper.findByStoreIdAndUserId(13, "kjuioq");
    	
    	log.info(list);
    	
    	assertNotNull(list);

    }
    
    // read list
    // find menu cnt by store and date 
    @Test
    public void findMenuCntByStoreIdAndDateTest() {
    	
    	HashMap<String,Integer> map =  mapper.findMenuCntByStoreIdAndDate(storeId, "20201107");
    	
    	log.info(map);
    	
    }
    
    // read list
    // find menu cnt by store and date 
    @Test
    public void findUserByStoreIdAndDateAndStusTest1() {
    	
    	List<UserVO> map =  mapper.findUserByStoreIdAndDateAndStus(storeId, "20201107");
    	
    	log.info(map);
    	
    }
    
    // update
    @Test
    public void updateTest1() {
    	
    	id = 24;
    	
    	ReservationVO rsvd = new ReservationVO().builder()
    			.id(id)
				.storeId(storeId)
				.userId(userId)
				.htdlId(htdlId)
				.pnum(pnum)
				.time("수정")
				.totAmt(totAmt)
				.totQty(totQty)
				.stusCd("C")
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
    
    @Test
    public void findRsvdByRsvdIdWithDtlsTest1() {
    	
    	long rsvdId = 9;
    	
    	ReservationVO rsvd = mapper.findRsvdByRsvdIdWithDtls(rsvdId);
    	
    	assertNotNull(rsvd);
    	
    	log.info(rsvd);
    }

}
