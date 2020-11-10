package com.dealight.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.NStoreVO;
import com.dealight.domain.StoreVO;
import com.dealight.mapper.BStoreMapper;
import com.dealight.mapper.NStoreMapper;
import com.dealight.mapper.StoreMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

	private StoreMapper storeMapper;
	
	private BStoreMapper bStoreMapper;
	
	private NStoreMapper nStoreMapper;
	
	@Override
	public boolean changeSeatStus(long storeId,String seatStusCd) {
		
		log.info("store service changeSeatStus....");
		
		return bStoreMapper.changeSeatStus(storeId, seatStusCd) == 1;
	}

	@Override
	public Date getCurTime() {
		
		log.info("store service curTime....");
		
		return new Date();
	}

	@Override
	public String getCurSeatStus(long storeId) {
		
		log.info("store service getCurSeatStus....");
		
		StoreVO store = storeMapper.findById(storeId);

		if(!store.getClsCd().equals("B"))
			return "사업자로 등록된 매장이 아닙니다.";
		
		BStoreVO bstore = bStoreMapper.findByStoreId(store.getStoreId());
		
		return bstore.getSeatStusCd();
	}

	@Override
	public StoreVO getStore(long storeId) {
		
		return storeMapper.findById(storeId);
	}

	@Override
	public BStoreVO getBStore(long storeId) {
		
		return bStoreMapper.findByStoreId(storeId);
	}

	@Override
	public List<StoreVO> getStoreListByUserId(String userId) {
		
		return storeMapper.findByUserIdJoinBStore(userId);
	}

	@Override
	public StoreVO findByStoreIdWithBStore(long storeId) {
		
		return storeMapper.findByIdJoinBStore(storeId);
	}

	// mapper 2번
	@Override
	public void registerStoreAndBStore(StoreVO store) {
		
		storeMapper.insertSelectKey(store);
		
		log.info(store);
		
		BStoreVO bstore = store.getBstore();
		
		log.info(bstore);
		
		bstore.setStoreId(store.getStoreId());
		
		bStoreMapper.insert(bstore);
	}

	
	// store update를 할 때는 
	// 포함관계인 nstore, bstore를 모두 업데이트 해줘야 한다.
	// mapper 2번
	@Override
	public boolean modifyStore(StoreVO store) {
		
		int result = storeMapper.update(store);
		BStoreVO bstore = store.getBstore(); 
		int result2 = bStoreMapper.update(bstore);

		return result == 1 && result2 == 1;
	}

	@Override
	public List<StoreVO> findByUserId(String userId) {
		
		return storeMapper.findByUserId(userId);
	}
}
