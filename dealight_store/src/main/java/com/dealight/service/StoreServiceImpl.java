package com.dealight.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.StoreVO;
import com.dealight.mapper.BStoreMapper;
import com.dealight.mapper.StoreMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

	private StoreMapper storeMapper;
	
	private BStoreMapper bStoreMapper;
	
	@Override
	public boolean changeSeatStus(long storeId,String seatStusCd) {
		
		log.info("store service changeSeatStus....");

		StoreVO store = storeMapper.findById(storeId);
		
		if(!store.getClsCd().equals("B"))
			return false;
		
		BStoreVO bstore = bStoreMapper.findByStoreId(store.getStoreId());
		
		bstore.setSeatStusCd(seatStusCd);
		
		return bStoreMapper.update(bstore) == 1;
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

	
	
}
