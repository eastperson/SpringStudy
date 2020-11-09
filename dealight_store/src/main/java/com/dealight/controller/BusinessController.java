package com.dealight.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.ReservationVO;
import com.dealight.domain.StoreVO;
import com.dealight.domain.UserVO;
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
		
		// �α��� ���� �ƴٰ� ����
		session.setAttribute("userId", "kjuioq");
		
		// ������ ���̵� �޴´�.
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
		
		model.addAttribute("userId",userId);
		
		return "/business/register";
	}
	
	
	@PostMapping("/register")
	public String waitingRegister(Model model,StoreVO store, BStoreVO bstore, RedirectAttributes rttr) {
		
		//log.info("business waiting register..");
		
		log.info("register bstore................... : " + bstore);
		
		store.setBstore(bstore);
		
		log.info("register store................... : "+store);
		
		storeService.registerStoreAndBStore(store);
		
		log.info("register store................... : "+store);
		
		return "redirect:/business/";
	}
	
	@GetMapping("/manage")
	public String manage(Model model, long storeId,HttpServletRequest request) {
		
		log.info("business manage..");
		
		HttpSession session = request.getSession();
		
		// ���ǿ� �ִ� userId�� �ҷ��´�.
		String userId = (String) session.getAttribute("userId");
		
		// store ������ �����´�.(Bstore ����)
		StoreVO store = storeService.findByStoreIdWithBStore(storeId);
		
		// ���� ������ ����(�ð�����)
		Date today = new Date();
		
		// ���忡 ���� �������� ���� ��������� ���� ����Ʈ�� �����´�. 
		List<ReservationVO> rsvdList = rsvdService.readTodayCurRsvdList(storeId);
		
		// ���� ������ ������ ������ ����Ʈ�� �����´�.
		List<WaitingVO> waitList = waitService.curStoreWaitList(storeId, "W");
		
		
		// ���� ���� ����� ����� �����´�.
		HashMap<String,List<Long>> todayRsvdMap = rsvdService.getRsvdByTimeMap(rsvdList);
		
		Long nextId = rsvdService.readNextRsvdId(todayRsvdMap);
		
		// �ٷ� ���� �����ڸ� �����´�.
		ReservationVO nextRsvd = rsvdService.findRsvdByRsvdId(nextId, rsvdList);
		
		// ���� ���� �հ踦 �����´�.
		int totalTodayRsvd = rsvdService.totalTodayRsvd(rsvdList);
		
		// ���� ���� �հ� �ο��� �����´�.
		int totalTodayRsvdPnum = rsvdService.totalTodayRsvdPnum(rsvdList);
		
		// ���� ���õ� �޴��� map�� �����´�.
		HashMap<String,Integer> todayFavMenuMap = rsvdService.todayFavMenu(storeId);
		
		String pattern = "yyyyMMdd";
    	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	
    	String date = simpleDateFormat.format(today);
		
		// ���� ������ �� ����Ʈ�� �����´�.
		List<UserVO> todayRsvdUserList = rsvdService.userListTodayRsvd(storeId, date);
		
		
		
		model.addAttribute("store", store);
		model.addAttribute("today", today);
		model.addAttribute("todayRsvdMap",todayRsvdMap);
		model.addAttribute("nextRsvd",nextRsvd);
		model.addAttribute("rsvdList", rsvdList);
		model.addAttribute("waitList", waitList);
		model.addAttribute("storeId",storeId);
		
		//��Ȳ��
		model.addAttribute("totalTodayRsvd",totalTodayRsvd);
		model.addAttribute("totalTodayRsvdPnum",totalTodayRsvdPnum);
		model.addAttribute("todayFavMenuMap", todayFavMenuMap);
		model.addAttribute("todayRsvdUserList", todayRsvdUserList);
		
		return "/business/manage/manage";
	}

}
