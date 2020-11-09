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
		
		// ��ϵ� ������ ��ȣ�� ��ȯ�Ѵ�.
		return waiting.getId();
	}

	@Override
	public boolean isPossibleWaitingUser(String userId) {
		
		// �ش� ���ڰ� �������� �ص� �Ǵ���(�г�Ƽ, ������ �ߺ�) �Ǻ��Ѵ�.
		return !isCurWaitingUser(userId) && !isCurPanaltyUser(userId);
	}

	@Override
	public boolean isCurWaitingUser(String userId) {
		
		// �ش� ������ ������ �������� Ȯ���Ѵ�.
		return waitMapper.findByUserId(userId, "W").size() > 0;
	}

	@Override
	public boolean isCurPanaltyUser(String userId) {

		// �ش� ������ �г�Ƽ ������ �Ǻ��Ѵ�.
		return userMapper.findById(userId).getPmStus().equals("P");
	}

	@Override
	public long registerOffWaiting(WaitingVO waiting) {

		waitMapper.insertSelectKey(waiting);
		
		// ��ϵ� �������� id�� ��ȯ�Ѵ�.
		return waiting.getId();

	}

	@Override
	public boolean cancelWaiting(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		// ������ ���¸� C(���)�� �ٲ���´�.
		waiting.setWaitStusCd("C");
		
		return waitMapper.update(waiting) == 1;
	}

	@Override
	public boolean enterWating(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		// ������ ���¸� E(����)�� �ٲ���´�.
		waiting.setWaitStusCd("E");
		
		return waitMapper.update(waiting) == 1;
	}

	@Override
	public boolean panaltyWaiting(long waitingId) {
		
		WaitingVO waiting = waitMapper.findById(waitingId);
		
		// ������ ���¸� P(�г�Ƽ)�� �ٲ���´�.
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
				
		// ���� ������ ����Ʈ �߿��� �ش� ������ ��ȣ���� ������ ��ȣ�� ���� �������� ���� + 1
		return curStoreWaitiList.stream().filter(c -> c.getId() < waitingId).collect(Collectors.toList()).size()+1;
	}

	@Override
	public int calWaitingTime(List<WaitingVO> curStoreWaitiList, long waitingId, int avgTime) {
		
		// �ش� ������ * avgTime
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
		
		// ���� store ������ ����Ʈ���� ���� ������ �����̰� ���� ���� ��������(������ �Ϸù�ȣ�� ����) ������ ��������
		return curStoreWaitiList.stream().filter(w -> w.getWaitStusCd().equals("W")).sorted(
				(w1, w2) -> (int) (w1.getId() - w2.getId())).collect(Collectors.toList()).get(0);
	}

}
