package com.dealight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealight.domain.WaitVO;
import com.dealight.mapper.UserMapper;
import com.dealight.mapper.WaitMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class WaitingServiceImpl implements WaitingService {
	
	@Autowired
	private WaitMapper waitMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public WaitVO read(long waitingId) {

		WaitVO wait = waitMapper.findById(waitingId);
		
		//UserVO user = userMapper.findById(wait.getUserId());
		
		//wait.setCustTelno(user.getTelno());
		
		//wait.setCustNm(user.getName());
		
		return wait;
	}

	@Override
	public long registerOnWaiting(WaitVO waiting) {
		
		String userId = waiting.getUserId();
		
		// user�� �������� �������� �ʴٸ�?
		if(!isPossibleWaitingUser(userId))
			return -1;
		
		waitMapper.insertSelectKey(waiting);
		
		// ��ϵ� ������ ��ȣ�� ��ȯ�Ѵ�.
		return waiting.getWaitId();
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
	public long registerOffWaiting(WaitVO waiting) {

		waitMapper.insertSelectKey(waiting);
		
		// ��ϵ� �������� id�� ��ȯ�Ѵ�.
		return waiting.getWaitId();

	}

	@Override
	public boolean cancelWaiting(long waitingId) {
		
		// ������ ���¸� C(����)�� �ٲ���´�.
		return waitMapper.changeWaitStusCd(waitingId, "C") == 1;
	}

	@Override
	public boolean enterWaiting(long waitingId) {

		// ������ ���¸� E(����)�� �ٲ���´�.
		return waitMapper.changeWaitStusCd(waitingId, "E") == 1;
	}

	@Override
	public boolean panaltyWaiting(long waitingId) {

		// ������ ���¸� P(�г�Ƽ)�� �ٲ���´�.	
		return waitMapper.changeWaitStusCd(waitingId, "P") == 1;
	}

	@Override
	public List<WaitVO> allStoreWaitList(long storeId) {
		
		return waitMapper.findByStoreId(storeId);
	}

	@Override
	public List<WaitVO> curStoreWaitList(long storeId, String waitStusCd) {
		
		return waitMapper.findByStoreIdAndStusCd(storeId, waitStusCd);
	}

	@Override
	public int calWatingOrder(List<WaitVO> curStoreWaitiList, long waitingId) {
				
		// ���� ������ ����Ʈ �߿��� �ش� ������ ��ȣ���� ������ ��ȣ�� ���� �������� ���� + 1
		return curStoreWaitiList.stream().filter(c -> c.getWaitId() < waitingId).collect(Collectors.toList()).size()+1;
	}

	@Override
	public int calWaitingTime(List<WaitVO> curStoreWaitiList, long waitingId, int avgTime) {
		
		// �ش� ������ * avgTime
		return calWatingOrder(curStoreWaitiList, waitingId) * avgTime;
	}

	@Override
	public WaitVO readNextWait(List<WaitVO> curStoreWaitiList) {
		
		// null check
		if(curStoreWaitiList == null)
			return null;
		if(curStoreWaitiList.size() == 0)
			return null;
		if(curStoreWaitiList.stream().filter(w -> w.getWaitStusCd().equals("W")).collect(Collectors.toList()).size() ==0)
			return null;
		
		// ���� store ������ ����Ʈ���� ���� ������ �����̰� ���� ���� ��������(������ �Ϸù�ȣ�� ����) ������ ��������
		return curStoreWaitiList.stream().filter(w -> w.getWaitStusCd().equals("W")).sorted(
				(w1, w2) -> (int) (w1.getWaitId() - w2.getWaitId())).collect(Collectors.toList()).get(0);
	}

}
