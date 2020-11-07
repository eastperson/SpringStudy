package com.dealight.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealight.domain.WaitingVO;
import com.dealight.mapper.UserMapper;
import com.dealight.mapper.WaitingMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class WaitingServiceImpl implements WaitingService {
	
	@Autowired
	private WaitingMapper waitMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public WaitingVO read(long waitingId) {

		return waitMapper.findById(waitingId);
	}

	@Override
	public long registerOnWaiting(WaitingVO waiting) {
		
		waitMapper.insertSelectKey(waiting);
		
		return waiting.getId();
	}

	@Override
	public boolean isPossibleWaitingUser(String userId) {
		
		return !isCurWaitingUser(userId) && !isCurPanaltyUser(userId);
	}

	@Override
	public boolean isCurWaitingUser(String userId) {
		
		return waitMapper.findByUserId(userId, "W").size() > 0;
	}

	@Override
	public boolean isCurPanaltyUser(String userId) {

		return userMapper.findById(userId).getPmStus().equals("P");
	}

	@Override
	public long registerOffWaiting(WaitingVO waiting) {

		waitMapper.insertSelectKey(waiting);
		
		return waiting.getId();

	}

	@Override
	public boolean cancelWaiting(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		waiting.setWaitStusCd("C");
		
		return waitMapper.update(waiting) == 1;
	}

	@Override
	public boolean enterWating(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		waiting.setWaitStusCd("E");
		
		return waitMapper.update(waiting) == 1;
	}

	@Override
	public boolean panaltyWaiting(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		waiting.setWaitStusCd("P");
		
		return waitMapper.update(waiting) == 1;
	}

	@Override
	public List<WaitingVO> allStoreWaitList(long storeId) {
		
		return waitMapper.findByStoreId(storeId);
	}

	@Override
	public List<WaitingVO> curStoreWaitList(long storeId, String waitStusCd) {
		
		return waitMapper.findByStoreIdAndStusCd(storeId, waitStusCd);
	}

	@Override
	public int calWatingOrder(List<WaitingVO> curStoreWaitiList, long waitingId) {
		
		List<WaitingVO> list = curStoreWaitiList.stream().filter(c -> c.getId() < waitingId).collect(Collectors.toList());
				
		return list.size()+1;
	}

	@Override
	public int calWaitingTime(List<WaitingVO> curStoreWaitiList, long waitingId, int avgTime) {
		
		return calWatingOrder(curStoreWaitiList, waitingId) * avgTime;
	}

}
