package com.dealight.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealight.domain.ReservationDetailVO;
import com.dealight.domain.ReservationVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReservationServiceTests {

	@Autowired
	private ReservationService reservationService;
	
	long storeId = 13;
	long rsvdId = 9;
	
	//ReservationDetailVO readDetail(long rsvdId);
	//List<ReservationVO> readAllRsvdList(long storeId);
	//List<ReservationVO> readCurRsvdList(long storeId);
	//List<ReservationVO> readTodayCurRsvdList(long storeId);
	//boolean isReserveThisTimeStore(List<ReservationVO> readTodayCurRsvdList);
	//ReservationVO readNextRsvd(List<ReservationVO> readTodayCurRsvdList);
	//boolean isHtdl(ReservationVO rsvd);
	
	//int totalTodayRsvd(List<ReservationVO> readTodayCurRsvdList);
	//int totalTodayRsvdPnum(List<ReservationVO> readTodayCurRsvdList);
	//int todayFavMenu(List<ReservationVO> readTodayCurRsvdList);
	//List<UserVO> userListTodayRsvd(List<ReservationVO> readTodayCurRsvdList);
	
	@Test
	public void readByRsvdIdTest1() {
		
		ReservationVO rsvd = reservationService.read(rsvdId);
		
		assertNotNull(rsvd);
		
		log.info(rsvd);
		
	}
	
	@Test
	public void readDetailByRsvdIdTest1() {
		
		List<ReservationDetailVO> list = reservationService.readDetail(rsvdId);
		
		assertNotNull(list);
		
		list.forEach((rsvdDtls) -> {
			
			assertTrue(rsvdDtls.getRsvdId() == rsvdId);
			
		});
		
		log.info(list);
	}
	
	@Test
	public void readListReservationByStoreIdTest1() {
		
		List<ReservationVO> list = reservationService.readAllRsvdList(storeId);
		
		assertNotNull(list);
		
		list.forEach((rsvd) -> {
			
			assertTrue(rsvd.getStoreId() == storeId);
			
		});
		
		log.info(list);
	}
	
	@Test
	public void readListCurReservationByStoreIdTest1() {
		
		List<ReservationVO> list = reservationService.readCurRsvdList(storeId);
		
		assertNotNull(list);
		
		list.forEach((rsvd) -> {
			
			assertTrue(rsvd.getStusCd().equals("C"));
			
		});
		
		log.info(list);
	}
	
	
	
	@Test
	public void readRsvdTodayTest1() {
		
		List<ReservationVO> list = reservationService.readTodayCurRsvdList(storeId);
		
		assertNotNull(list);
		
		String pattern = "yyyy-MM-dd";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Date date = new Date();
		
		list.forEach((rsvd) -> {
			
			assertTrue(simpleDateFormat.format(rsvd.getInDate()).equals(simpleDateFormat.format(date)));
			
		});
		
		log.info(list);
		
	}
	
	@Test
	public void getRsvdListByDateTest1() {
		
		String date = "20201107";
		
		List<ReservationVO> list = reservationService.getListByDate(storeId, date);
		
		assertNotNull(list);
		
		String pattern = "yyyyMMdd";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		list.forEach((rsvd) -> {
			
			assertTrue(rsvd.getStoreId() == storeId);
			assertTrue(simpleDateFormat.format(rsvd.getInDate()).equals(date));
			
		});
		
		log.info(list);

	}
	
	
	@Test
	public void getTimeTest1() {
		
		List<ReservationVO> list = reservationService.readTodayCurRsvdList(storeId);
		
		list.forEach((rsvd) -> {
			log.info(reservationService.getTime(rsvd.getInDate()));
		});
		
	}
	
	@Test
	public void calTimeMinutesTest1() {
		
		List<ReservationVO> list = reservationService.readTodayCurRsvdList(storeId);
		
		list.forEach((rsvd) -> {
			String time = reservationService.getTime(rsvd.getInDate());
			log.info(time + ":::::::::::::" + reservationService.calTimeMinutes(time));
		});
		
	}
	
	@Test
	public void toRsvdByTimeFormatTest1() {
		
		String time = "14:59";
		
		time = reservationService.toRsvdByTimeFormat(time);
		
		log.info(time);
		
		//assertTrue(time.equals("11:30"));
		
	}
	
	@Test
	public void getRsvdByTimeMapTest1() {
		
		String date = "20201107";
		
		List<ReservationVO> list = reservationService.getListByDate(storeId, date);
		
		log.info(list);
		
		HashMap<String, Integer> map = reservationService.getRsvdByTimeMap(list);
		
		log.info(map);
		
	};

	
	@Test
	public void isReserveThisTimeStoreTest1() {
		
		// 2020년 11월 7일 11시 47분 30초
		//Date date = new Date(120,10,7,11,47,30);
		
		// 2020년 11월 7일 12시 12분 30초
		Date date = new Date(120,10,7,12,12,30);

		int acm = 5;
		
		log.info(date);
		
		List<ReservationVO> list = reservationService.getListByDate(storeId, "20201107");
		
		log.info(list);
		
		log.info(reservationService.getRsvdByTimeMap(list));
		
		assertTrue(reservationService.isReserveThisTimeStore(storeId, date, acm));
		
		
	}
	
	@Test
	public void readNextRsvdTest1() {
		
		List<ReservationVO> list = reservationService.readTodayCurRsvdList(storeId);
	
		ReservationVO rsvd = reservationService.readNextRsvd(list);
		
		assertNotNull(rsvd);
		
		log.info(rsvd);
		
		assertTrue(list.get(0).equals(rsvd));
		
	}
	
	@Test
	public void isHtdlTest1() {
		
		ReservationVO rsvd = reservationService.read(50);
		
		assertTrue(reservationService.isHtdl(rsvd));
		
	}
	
	@Test
	public void totalTodayRsvdTest() {
		
		List<ReservationVO> readTodayCurRsvdList = reservationService.readTodayCurRsvdList(storeId);
		
		log.info(reservationService.totalTodayRsvd(readTodayCurRsvdList));
	}
	
	@Test
	public void totalTodayRsvdPnumTest() {
		
		List<ReservationVO> readTodayCurRsvdList = reservationService.readTodayCurRsvdList(storeId);
		
		log.info(reservationService.totalTodayRsvdPnum(readTodayCurRsvdList));
	}
	
	@Test
	public void userListTodayRsvdTest() {
		
		String date = "20201107";
		
		reservationService.userListTodayRsvd(storeId, date);
	}
	
}
