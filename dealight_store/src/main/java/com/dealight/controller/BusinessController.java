package com.dealight.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dealight.domain.ReservationVO;
import com.dealight.domain.StoreVO;
import com.dealight.domain.WaitingVO;
import com.dealight.service.HotDealService;
import com.dealight.service.ReservationService;
import com.dealight.service.StoreService;
import com.dealight.service.WaitingService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/business/*")
public class BusinessController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ReservationService rsvdService;
	
	@Autowired
	private WaitingService waitService;
	
	@Autowired
	private HotDealService htdlService;
	
	@GetMapping("/")
	public String list(Model model,HttpServletRequest request) {
		
		log.info("business store list..");
		
		HttpSession session = request.getSession();
		
		// 로그인 세션 됐다고 가정
		session.setAttribute("userId", "kjuioq");
		
		// 세션의 아이디를 받는다.
		String userId = (String) session.getAttribute("userId");
		
		model.addAttribute("userId", userId);
		List<StoreVO> list = storeService.getStoreListByUserId(userId);
		model.addAttribute("storeList", list);
		
		return "/business/list";
	}
	
	@GetMapping("/register")
	public String storeRegister(Model model,HttpServletRequest request) {
		
		log.info("business store register..");
		
		HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("userId");
		
		return "/business/register";
	}
	
	@GetMapping("/manage")
	public String manage(Model model, long storeId,HttpServletRequest request) {
		
		log.info("business manage..");
		
		HttpSession session = request.getSession();
		
		// 세션에 있는 userId를 불러온다.
		String userId = (String) session.getAttribute("userId");
		
		// store 정보를 가져온다.(Bstore 조인)
		StoreVO store = storeService.findByStoreIdWithBStore(storeId);
		
		// 매장에 오늘 기준으로 현재 예약상태인 예약 리스트를 가져온다. 
		List<ReservationVO> rsvdList = rsvdService.readTodayCurRsvdList(storeId);
		
		// 현재 웨이팅 상태인 웨이팅 리스트를 가져온다.
		List<WaitingVO> waitList = waitService.curStoreWaitList(storeId, "W");
		
		// 오늘 예약 대기자 명단을 가져온다.
		HashMap<String,List<Long>> todayRsvdMap = rsvdService.getRsvdByTimeMap(rsvdList);
		
		long nextId = rsvdService.readNextRsvdId(todayRsvdMap);
		
		// 바로 다음 예약자를 가져온다.
		ReservationVO nextRsvd = rsvdService.findRsvdByRsvdId(nextId, rsvdList);
		
		int totalTodayRsvd = rsvdService.totalTodayRsvd(rsvdList);
		int totalTodayRsvdPnum = rsvdService.totalTodayRsvdPnum(rsvdList);
		HashMap<String,Integer> todayFavMenuMap = rsvdService.todayFavMenu(storeId);
		
		Date today = new Date();
		
		model.addAttribute("store", store);
		model.addAttribute("today", today);
		model.addAttribute("todayRsvdMap",todayRsvdMap);
		model.addAttribute("nextRsvd",nextRsvd);
		model.addAttribute("rsvdList", rsvdList);
		model.addAttribute("waitList", waitList);
		
		//현황판
		model.addAttribute("totalTodayRsvd",totalTodayRsvd);
		model.addAttribute("totalTodayRsvdPnum",totalTodayRsvdPnum);
		model.addAttribute("todayFavMenuMap", todayFavMenuMap);
		
		return "/business/manage/manage";
	}

}
