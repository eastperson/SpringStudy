package com.dealight.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealight.domain.RsvdVO;
import com.dealight.domain.StoreVO;
import com.dealight.domain.WaitingVO;
import com.dealight.service.HtdlService;
import com.dealight.service.RsvdService;
import com.dealight.service.StoreService;
import com.dealight.service.UserService;
import com.dealight.service.WaitingService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/business/manage/*")
@AllArgsConstructor
public class BoardController {
	
	private StoreService storeService;
	
	private RsvdService rsvdService;
	
	private HtdlService htdlService;
	
	private WaitingService waitService;
	
	private UserService userService;
	


	// store 정보를 가져온다
	@GetMapping(value = "/board/store/{storeId}", produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})	
	public ResponseEntity<StoreVO> getStore(@PathVariable("storeId") long storeId) {
		
		log.info("get store...........");
		
		return new ResponseEntity<>(storeService.findByStoreIdWithBStore(storeId), HttpStatus.OK);
	}
	
	// 웨이팅 현황(웨이팅 리스트)를 가져온다.
	@GetMapping(value = "/board/waiting/{storeId}", produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})	
	public ResponseEntity<List<WaitingVO>> getWaitList(@PathVariable("storeId") long storeId) {
		
		log.info("get wait list...........");
		
		return new ResponseEntity<>(waitService.curStoreWaitList(storeId, "W"), HttpStatus.OK);
	}

	// 예약 리스트를 가져온다
	@GetMapping(value = "/board/reservation/{storeId}", produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public ResponseEntity<List<RsvdVO>> getRsvdList(@PathVariable("storeId") long storeId) {
		
		log.info("get rsvd list...........");
		
		// store 정보를 가져온다.(Bstore 조인)		
		return new ResponseEntity<>(rsvdService.readTodayCurRsvdList(storeId), HttpStatus.OK);
	}
	
	// 금일 예약 현황 map을 가져온다.
	@GetMapping(value = "/board/reservation/map", 
			consumes = "application/json",
			produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public ResponseEntity<HashMap<String,List<Long>>> getTodayRsvdMap(@RequestBody List<RsvdVO> rsvdList) {
		
		log.info("get today rsvd map...........");
		
		log.info("today rsvdList................."+rsvdList);
		
		return new ResponseEntity<>(rsvdService.getRsvdByTimeMap(rsvdList), HttpStatus.OK);
	}
	
	@PutMapping(value = "/board/waiting/cancel/{waitId}", 
			consumes = "application/json",
			produces = {
			MediaType.TEXT_PLAIN_VALUE
	})
	public ResponseEntity<String> putCancelWaiting(@PathVariable("waitId") long waitId) {
		
		log.info("put cancel waiting...........");
		
		return waitService.cancelWaiting(waitId)
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/board/waiting/noshow/{waitId}", 
			consumes = "application/json",
			produces = {
			MediaType.TEXT_PLAIN_VALUE
	})
	public ResponseEntity<String> putNoshowWaiting(@PathVariable("waitId") long waitId) {
		
		log.info("put noshow waiting...........");
		
		return waitService.panaltyWaiting(waitId)
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/board/waiting/enter/{waitId}", 
			consumes = "application/json",
			produces = {
			MediaType.TEXT_PLAIN_VALUE
	})
	public ResponseEntity<String> putEnterWaiting(@PathVariable("waitId") long waitId) {
		
		log.info("put enter waiting...........");
		
		return waitService.enterWaiting(waitId)
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/board/waiting/new",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> registerOffWait(@RequestBody WaitingVO wait) {
		
		log.info("register wait.............");
		
		log.info("WaitingVO ............" + wait);
		
		long waitNo = waitService.registerOffWaiting(wait);
		
		log.info("wait no................" + waitNo);
		
		return waitNo > 0
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
			
			

	// 등록된 핫딜 정보를 가져온다.
//	@GetMapping(value = "/board/hotdeal/{storeId}", produces = {
//			MediaType.APPLICATION_JSON_UTF8_VALUE,
//			MediaType.APPLICATION_XML_VALUE
//	})
//	public ResponseEntity<WaitingVO> getNextWait(@PathVariable("storeId") long storeId) {
//		
//		log.info("get store...........");
//		
//		return new ResponseEntity<>(storeService.findByStoreIdWithBStore(storeId), HttpStatus.OK);
//	}
}
