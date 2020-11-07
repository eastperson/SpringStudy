package com.dealight.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealight.domain.ReservationDetailVO;
import com.dealight.domain.ReservationVO;
import com.dealight.domain.UserVO;
import com.dealight.mapper.ReservationDetailMapper;
import com.dealight.mapper.ReservationMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationMapper rsvdMapper;
	
	@Autowired
	private ReservationDetailMapper rsvdDtlsMapper;
	
	
	
	@Override
	public ReservationVO read(long rsvdId) {
		
		return rsvdMapper.findById(rsvdId);
	}

	@Override
	public List<ReservationDetailVO> readDetail(long rsvdId) {
		
		return rsvdDtlsMapper.findByRsvdId(rsvdId);

	}

	@Override
	public List<ReservationVO> readAllRsvdList(long storeId) {
		
		return rsvdMapper.findByStoreId(storeId);
	}

	@Override
	public List<ReservationVO> readCurRsvdList(long storeId) {
		
		return rsvdMapper.findByStoreIdAndCurStus(storeId,"C");
	}

	@Override
	public List<ReservationVO> readTodayCurRsvdList(long storeId) {
		
    	LocalDate currentDate = LocalDate.now();
    	
    	DateTimeFormatter dateTimeForMatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    	
    	String today = currentDate.format(dateTimeForMatter);
		
		return rsvdMapper.findByStoreIdToday(storeId, today);
	}
	
	@Override
	public List<ReservationVO> getListByDate(long storeId, String date) {
		
		return rsvdMapper.findByStoreIdAndDate(storeId, date);
	}
	
	@Override
	public String getTime(Date date) {
		
		String pattern = "HH:mm";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String time = simpleDateFormat.format(date);
		
		return time;
	}
	
	@Override
	public int calTimeMinutes(String time) {
		
		String[] toMinutes = time.split(":");
		
		int minutes = Integer.valueOf(toMinutes[0]) * 60+ Integer.valueOf(toMinutes[1]);
		
		return minutes;
	}
	
	// time = "yyyyMMdd"
	@Override
	public String toRsvdByTimeFormat(String time) {
		
		String[] times = time.split(":");
		
		String strHour = times[0];
		int minute = Integer.valueOf(times[1]);
		int result = 0;
		String strMinute ="";
		
		if(minute < 60)
			result = 45;
		if(minute < 45)
			result = 30;
		if(minute < 30)
			result = 15;
		if(minute < 15)
			result = 0;
		
		strMinute = Integer.toString(result);
		
		if(result == 0)
			strMinute = "0" + Integer.toString(result);
		
		
		return strHour+":"+strMinute;
	}
	
	@Override
	public HashMap<String, Integer> getRsvdByTimeMap(List<ReservationVO> listByDate) {
		
		HashMap<String,Integer> map = new HashMap<>();
		
		listByDate.stream().forEach((rsvd) -> {
			
			// C여야 된다.
			if(!rsvd.getStusCd().equalsIgnoreCase("C"))
				return;
			
			int cnt = 1;
			
			String time = getTime(rsvd.getInDate());
			String fomatedTime = toRsvdByTimeFormat(time);
			if(map.get(fomatedTime) != null)
				cnt = map.get(fomatedTime) + 1;
				
			map.put(fomatedTime, cnt);
			
		});
		
		return map;
	}
	

	@Override
	public boolean isReserveThisTimeStore(long storeId, Date date,int acm) {
		
		//log.info("test..................date" + date);
		
		String time = getTime(date);
		
		//log.info("test..................time" + time);
		
		String pattern = "yyyyMMdd";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		//log.info("test.....................date"+simpleDateFormat.format(date));
		
		List<ReservationVO> list = getListByDate(storeId, simpleDateFormat.format(date));
		
		//log.info("test..................list" + list);
		
		HashMap<String,Integer> map = getRsvdByTimeMap(list);
		
		//log.info("test..................map" + map);
		
		time = toRsvdByTimeFormat(time);
		
		//log.info("test..................time" + time);
		
		//log.info("test..................map.get(time) : " + map.get(time));
		
		//return false;
		
		return map.get(time) == null ? true : map.get(time) < acm ? true : false;
	}

	@Override
	public ReservationVO readNextRsvd(List<ReservationVO> readTodayCurRsvdList) {
		
		return readTodayCurRsvdList.get(0);
	}

	@Override
	public boolean isHtdl(ReservationVO rsvd) {
		
		return rsvd.getHtdlId() > 0;
	}

	@Override
	public int totalTodayRsvd(List<ReservationVO> readTodayCurRsvdList) {

		AtomicInteger cnt = new AtomicInteger();
		
		readTodayCurRsvdList.stream().forEach((rsvd)->{
			
			// C여야 한다.
			if(rsvd.getStusCd().equalsIgnoreCase("C"))
				cnt.incrementAndGet();
				
		});
		
		return cnt.getAcquire();
	}

	@Override
	public int totalTodayRsvdPnum(List<ReservationVO> readTodayCurRsvdList) {
		
		AtomicInteger cnt = new AtomicInteger();
		
		readTodayCurRsvdList.stream().forEach((rsvd)->{
			
			// C여야 한다.
			if(rsvd.getStusCd().equalsIgnoreCase("P")) {
				
				cnt.addAndGet(rsvd.getPnum());
				
			}
		});
		
		return cnt.getAcquire();
		
	}

	@Override
	public HashMap<String,Integer> todayFavMenu(long storeId) {
		
		LocalDate currentDate = LocalDate.now();
    	
    	DateTimeFormatter dateTimeForMatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    	
    	String date = currentDate.format(dateTimeForMatter);

		return rsvdMapper.findMenuCntByStoreIdAndDate(storeId, date);
	}



	@Override
	public List<UserVO> userListTodayRsvd(long storeId, String date) {

		return rsvdMapper.findUserByStoreIdAndDateAndStus(storeId, date);
	}

}
