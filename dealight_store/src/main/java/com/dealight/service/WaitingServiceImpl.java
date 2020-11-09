package com.dealight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealight.domain.UserVO;
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

		WaitingVO wait = waitMapper.findById(waitingId);
		
		//UserVO user = userMapper.findById(wait.getUserId());
		
		//wait.setCustTelno(user.getTelno());
		
		//wait.setCustNm(user.getName());
		
		return wait;
	}

	@Override
	public long registerOnWaiting(WaitingVO waiting) {
		
		waitMapper.insertSelectKey(waiting);
		
		// 등록된 웨이팅 번호를 반환한다.
		return waiting.getId();
	}

	@Override
	public boolean isPossibleWaitingUser(String userId) {
		
		// 해당 유자가 웨이팅을 해도 되는지(패널티, 웨이팅 중복) 판별한다.
		return !isCurWaitingUser(userId) && !isCurPanaltyUser(userId);
	}

	@Override
	public boolean isCurWaitingUser(String userId) {
		
		// 해당 유저가 웨이팅 상태인지 확인한다.
		return waitMapper.findByUserId(userId, "W").size() > 0;
	}

	@Override
	public boolean isCurPanaltyUser(String userId) {

		// 해당 유저가 패널티 고객인지 판별한다.
		return userMapper.findById(userId).getPmStus().equals("P");
	}

	@Override
	public long registerOffWaiting(WaitingVO waiting) {

		waitMapper.insertSelectKey(waiting);
		
		// 등록된 웨이팅의 id를 반환한다.
		return waiting.getId();

	}

	@Override
	public boolean cancelWaiting(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		// 웨이팅 상태를 C(취소)로 바꿔놓는다.
		waiting.setWaitStusCd("C");
		
		return waitMapper.update(waiting) == 1;
	}

	@Override
	public boolean enterWating(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		// 웨이팅 상태를 E(입장)로 바꿔놓는다.
		waiting.setWaitStusCd("E");
		
		return waitMapper.update(waiting) == 1;
	}

	@Override
	public boolean panaltyWaiting(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		// 웨이팅 상태를 P(패널티)로 바꿔놓는다.
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
				
		// 현재 웨이팅 리스트 중에서 해당 웨이팅 번호보다 웨이팅 번호가 낮은 웨이팅의 숫자 + 1
		return curStoreWaitiList.stream().filter(c -> c.getId() < waitingId).collect(Collectors.toList()).size()+1;
	}

	@Override
	public int calWaitingTime(List<WaitingVO> curStoreWaitiList, long waitingId, int avgTime) {
		
		// 해당 대기순위 * avgTime
		return calWatingOrder(curStoreWaitiList, waitingId) * avgTime;
	}

	@Override
	public WaitingVO readNextWait(List<WaitingVO> curStoreWaitiList) {
		
		// null check
		if(curStoreWaitiList == null)
			return null;
		if(curStoreWaitiList.size() == 0)
			return null;
		if(curStoreWaitiList.stream().filter(w -> w.getWaitStusCd().equals("W")).collect(Collectors.toList()).size() ==0)
			return null;
		
		// 현재 store 웨이팅 리스트에서 현재 웨이팅 상태이고 가장 먼저 웨이팅한(웨이팅 일련번호가 낮은) 웨이팅 꺼내오기
		return curStoreWaitiList.stream().filter(w -> w.getWaitStusCd().equals("W")).sorted(
				(w1, w2) -> (int) (w1.getId() - w2.getId())).collect(Collectors.toList()).get(0);
	}

}
