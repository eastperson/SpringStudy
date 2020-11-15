package com.dealight.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dealight.domain.AllStoreVO;
import com.dealight.domain.BStoreVO;
import com.dealight.domain.MenuVO;
import com.dealight.domain.RevwVO;
import com.dealight.domain.StoreEvalVO;
import com.dealight.domain.StoreImgVO;
import com.dealight.domain.StoreLocVO;
import com.dealight.domain.StoreOptionVO;
import com.dealight.domain.StoreVO;
import com.dealight.mapper.AllStoreMapper;
import com.dealight.mapper.BStoreMapper;
import com.dealight.mapper.MenuMapper;
import com.dealight.mapper.NStoreMapper;
import com.dealight.mapper.RevwMapper;
import com.dealight.mapper.StoreImgMapper;
import com.dealight.mapper.StoreLocMapper;
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
	
	private AllStoreMapper allStoreMapper;
	
	private StoreImgMapper storeImgMapper;
	
	private StoreImgMapper imgMapper;
	
	private RevwMapper revwMapper;
	
	private MenuMapper menuMapper;
	
	private StoreLocMapper locMapper;
	
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
	@Transactional
	@Override
	public void registerStoreAndBStore(StoreVO store) {
		
		storeMapper.insertSelectKey(store);
		
		log.info(store);
		
		BStoreVO bstore = store.getBstore();
		
		log.info(bstore);
		
		bstore.setStoreId(store.getStoreId());

		bStoreMapper.insert(bstore);
		
		List<StoreImgVO> imgs = store.getImgs();
		
		imgs.stream().forEach(img -> {
			img.setStoreId(store.getStoreId());
		});
		
		storeImgMapper.insertAll(imgs);
		
		
	}

	
	// store update를 할 때는 
	// 포함관계인 nstore, bstore를 모두 업데이트 해줘야 한다.
	// mapper 2번
	@Override
	public boolean modifyStore(StoreVO store) {
		
		int result = storeMapper.update(store);
		BStoreVO bstore = store.getBstore(); 
		int result2 = bStoreMapper.update(bstore);
		
		List<StoreImgVO> imgs = store.getImgs();
		imgs.stream().forEach(img -> {
			img.setStoreId(store.getStoreId());
		});
		storeImgMapper.deleteAll(store.getStoreId());
		storeImgMapper.insertAll(imgs);

		return result == 1 && result2 == 1;
	}

	@Override
	public List<StoreVO> findByUserId(String userId) {
		
		return storeMapper.findByUserId(userId);
	}

	@Override
	public AllStoreVO findAllStoreInfoByStoreId(long storeId) {
		
		return allStoreMapper.findAllStoreByStoreId(storeId);
	}

	@Override
	public List<StoreImgVO> getStoreImageList(long storeId) {
		return storeImgMapper.findByStoreId(storeId);
	}

	@Override
	public void removeStoreImgAll(long storeId) {
		
		storeImgMapper.deleteAll(storeId);
		
	}

	@Transactional
	@Override
	public boolean modifyStore(AllStoreVO store) {

		StoreVO store1 = new StoreVO.Builder(store.getStoreId(), store.getStoreNm(), store.getTelno()
				).build();
		BStoreVO bstore = BStoreVO.builder()
				.storeId(store.getStoreId())
				.openTm(store.getOpenTm())
				.closeTm(store.getCloseTm())
				.breakSttm(store.getBreakSttm())
				.breakEntm(store.getBreakEntm())
				.lastOrdTm(store.getLastOrdTm())
				.n1SeatNo(store.getN1SeatNo())
				.n2SeatNo(store.getN2SeatNo())
				.n4SeatNo(store.getN4SeatNo())
				.storeIntro(store.getStoreIntro())
				.avgMealTm(store.getAvgMealTm())
				.hldy(store.getHldy())
				.acmPnum(store.getAcmPnum())
				.build();
		StoreLocVO loc = StoreLocVO.builder()
				.storeId(store.getStoreId())
				.addr(store.getAddr())
				.lt(store.getLt())
				.lo(store.getLo())
				.build();
		StoreOptionVO opt = StoreOptionVO.builder()
				.storeId(store.getStoreId())
				.park(store.getPark())
				.nokids(store.getNokids())
				.pg(store.getPg())
				.wifi(store.getWifi())
				.pet(store.getPet())
				.smoke(store.getSmoke())
				.build();
		StoreEvalVO eval = StoreEvalVO.builder()
				.storeId(store.getStoreId())
				.avgRating(store.getAvgRating())
				.revwTotNum(store.getRevwTotNum())
				.likeTotNum(store.getLikeTotNum())
				.build();
		List<RevwVO> revwList = store.getRevwList();
		List<MenuVO> menuList = store.getMenuList();
		List<StoreImgVO> imgs = store.getImgs();

		storeMapper.update(store1);
		bStoreMapper.update(bstore);
		locMapper.update(loc);
		
		if(revwList != null) {
		
		revwList.stream().forEach(revw -> {
			revw.setStoreId(store.getStoreId());
			revwMapper.update(revw);
		});
		}
		
		imgMapper.deleteAll(store.getStoreId());
		
		if(imgs != null) {			
			imgs.stream().forEach(img -> {
				img.setStoreId(store.getStoreId());
			});
			imgMapper.insertAll(imgs);
		}
		
		
		return false;
	}
}
