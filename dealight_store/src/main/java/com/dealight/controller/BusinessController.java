package com.dealight.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.RsvdVO;
import com.dealight.domain.StoreVO;
import com.dealight.domain.UserWithRsvdDTO;
import com.dealight.domain.WaitingVO;
import com.dealight.service.HtdlService;
import com.dealight.service.RsvdService;
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
	private RsvdService rsvdService;
	
	@Autowired
	private WaitingService waitService;
	
	@Autowired
	private HtdlService htdlService;
	
	// 쿼리문 1
	@GetMapping("/")
	public String list(Model model,HttpServletRequest request) {
		
		log.info("business store list..");
		
		
		HttpSession session = request.getSession();
		
		// 로그인 세션 됐다고 가정
		session.setAttribute("userId", "lim");
		
		// 세션의 아이디를 받는다.
		String userId = (String) session.getAttribute("userId");
		
		model.addAttribute("userId", userId);
		
		List<StoreVO> list = storeService.getStoreListByUserId(userId);
		list.stream().forEach((store)->{
			long id = store.getStoreId();
			store.setCurWaitNum(waitService.curStoreWaitList(id, "W").size());
			store.setCurRsvdNum(rsvdService.readTodayCurRsvdList(id).size());
		});
		
		model.addAttribute("storeList", list);
		
		return "/business/list";
	}
	
	// 쿼리문 0
	@GetMapping("/register")
	public String storeRegister(Model model,HttpServletRequest request) {
		
		log.info("business store register..");
		
		HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("userId");
		
		model.addAttribute("userId",userId);
		
		return "/business/register";
	}
	
	@PostMapping("/register")
	public String waitingRegister(Model model,StoreVO store,BStoreVO bstore, RedirectAttributes rttr) {
		
		//log.info("business waiting register..");
		
		log.info("register bstore................... : "+bstore);
		
		store.setBstore(bstore);
		
		log.info("register store................... : "+store);

		storeService.registerStoreAndBStore(store);
		
		
		return "redirect:/business/";
	}
	
	// 쿼리문 4 -> 페이지 분리하면 각 2개
	@GetMapping("/manage")
	public String manage(Model model, long storeId,HttpServletRequest request) {
		
		log.info("business manage..");
		
		HttpSession session = request.getSession();
		
		// 세션에 있는 userId를 불러온다.
		String userId = (String) session.getAttribute("userId");
		
		// store 정보를 가져온다.(Bstore 조인)
		//StoreVO store = storeService.findByStoreIdWithBStore(storeId);
		
		// 라스트 오더 시간 정보를 가져온다.
		//String lastOrder = store.getBstore().getLastOrdTm();
		
		// 현재 데이터 생성(시간포함)
		//Date today = new Date();
		
		// 매장에 오늘 기준으로 현재 예약상태인 예약 리스트를 가져온다. 
		// 쿼리
		//List<RsvdVO> rsvdList = rsvdService.readTodayCurRsvdList(storeId);

		// 현재 웨이팅 상태인 웨이팅 리스트를 가져온다.
		// 쿼리
		//List<WaitingVO> waitList = waitService.curStoreWaitList(storeId, "W");
		
		// 바로 다음 웨이팅을 가져온다.
		//WaitingVO nextWait = waitService.readNextWait(waitList);
		
		// 오늘 예약 대기자 명단을 가져온다.
		//HashMap<String,List<Long>> todayRsvdMap = rsvdService.getRsvdByTimeMap(rsvdList);
		
		// 다음 예약자 id를 가져온다.
		//Long nextId = rsvdService.readNextRsvdId(todayRsvdMap);
		
		// 바로 다음 예약자를 가져온다.
		//RsvdVO nextRsvd = rsvdService.findRsvdByRsvdId(nextId, rsvdList);
		
		// 오늘 예약 합계를 가져온다.
		//int totalTodayRsvd = rsvdService.totalTodayRsvd(rsvdList);
		
		// 오늘 예약 합계 인원을 가져온다.
		//int totalTodayRsvdPnum = rsvdService.totalTodayRsvdPnum(rsvdList);
		
		// 오늘 선택된 메뉴의 map을 가져온다.
		// 쿼리
		//HashMap<String,Integer> todayFavMenuMap = rsvdService.todayFavMenu(storeId);
		
		//String pattern = "yyyyMMdd";
    	
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	
    	//String date = simpleDateFormat.format(today);
		
		// 오늘 예약한 고객 리스트를 가져온다.
    	// 쿼리
		List<UserWithRsvdDTO> todayRsvdUserList = rsvdService.userListTodayRsvd(storeId);
		
		// 현재 착성상태를 가져온다.
		//String curSeatStus = store.getBstore().getSeatStusCd();
		
		
		model.addAttribute("storeId", storeId);
		//model.addAttribute("store", store);
		//model.addAttribute("today", today);
		//model.addAttribute("todayRsvdMap",todayRsvdMap);
		//model.addAttribute("nextRsvd",nextRsvd);
		//model.addAttribute("rsvdList", rsvdList);
		//model.addAttribute("waitList", waitList);
		//model.addAttribute("storeId",storeId);
		//model.addAttribute("nextWait",nextWait);
		//model.addAttribute("lastOrder",lastOrder);
		//model.addAttribute("curSeatStus",curSeatStus);
		
		//현황판
		//model.addAttribute("totalTodayRsvd",totalTodayRsvd);
		//model.addAttribute("totalTodayRsvdPnum",totalTodayRsvdPnum);
		//model.addAttribute("todayFavMenuMap", todayFavMenuMap);
		model.addAttribute("todayRsvdUserList", todayRsvdUserList);
		
		return "/business/manage/manage";
	}
	
	// 웨이팅 상세
		// 쿼리문 1
		@GetMapping("/waiting/{waitId}")
		public String waiting(Model model, @PathVariable("waitId") long waitId) {
			
			log.info("business waiting detail..");
			
			WaitingVO wait = waitService.read(waitId);
			
			log.info(wait);
			
			// 해당 매장에 현재 상태가 W인 리스트를 가져온다.
			List<WaitingVO> curStoreWaitiList = waitService.curStoreWaitList(wait.getStoreId(), "W");
			
			// 해당 웨이팅 번호의 현재 대기 순서를 보여준다.
			int order = waitService.calWatingOrder(curStoreWaitiList, wait.getId());
			
			// 해당 웨이팅 번호의 현대 예상 대기 시간을 보여준다.
			// 대기시간은 일단 임의로 15로 지정했다.
			int waitTime = waitService.calWaitingTime(curStoreWaitiList, wait.getId(), 15);
			
			model.addAttribute("wait",wait);
			model.addAttribute("order",order);
			model.addAttribute("waitTime", waitTime);
			
			return "/business/manage/waiting/waiting";
		}
}
