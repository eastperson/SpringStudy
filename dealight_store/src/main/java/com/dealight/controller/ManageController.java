package com.dealight.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.HotDealVO;
import com.dealight.domain.ReservationVO;
import com.dealight.domain.StoreVO;
import com.dealight.domain.WaitingVO;
import com.dealight.service.HotDealService;
import com.dealight.service.ReservationService;
import com.dealight.service.StoreService;
import com.dealight.service.UserService;
import com.dealight.service.WaitingService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/business/manage/*")
public class ManageController {
	
	@Setter(onMethod_ = @Autowired)
	private StoreService storeService;
	
	@Setter(onMethod_ = @Autowired)
	private ReservationService rsvdService;
	
	@Setter(onMethod_ = @Autowired)
	private HotDealService htdlService;
	
	@Setter(onMethod_ = @Autowired)
	private WaitingService waitService;
	
	@Setter(onMethod_ = @Autowired)
	private UserService userService;
	
	@GetMapping("/dealhistory")
	public String dealHistory(Model model,long storeId,HttpServletRequest request) {
		
		log.info("business manage..");
		
		List<HotDealVO> htdlList = htdlService.readAllStoreHtdlList(storeId);
		
		model.addAttribute("htdlList",htdlList);
		
		return "/business/manage/dealhistory";
	}
	
	@GetMapping("/reservation")
	public String reservation(Model model, long rsvdId) {
		
		// 예약 상세를 포함한 예약 정보를 가져온다.
		ReservationVO rsvd = rsvdService.findRsvdByRsvdIdWithDtls(rsvdId);
		
		List<ReservationVO> rsvdList = userService.getRsvdListStoreUser(rsvd.getStoreId(), rsvd.getUserId());
		
		model.addAttribute("rsvd",rsvd);
		model.addAttribute("rsvdList",rsvdList);
		
		return "/business/manage/reservation";
	}
	
	// 웨이팅 상세
	@GetMapping("/waiting")
	public String waiting(Model model, long waitId) {
		
		log.info("business waiting detail..");
		
		WaitingVO wait = waitService.read(waitId);
		
		log.info(wait);
		
		model.addAttribute("wait",wait);
		
		return "/business/manage/waiting/waiting";
	}
	
	@GetMapping("/waiting/register")
	public String waitingRegister(Model model, long storeId) {
		
		log.info("business waiting register..");
		
		Date curTime = new Date();
		
		model.addAttribute("curTime", curTime);
		model.addAttribute("storeId", storeId);
		
		return "/business/manage/waiting/register";
	}
	
	@PostMapping("/waiting/register")
	public String waitingRegister(Model model, WaitingVO wait,HttpServletRequest request,long storeId) {
		
		log.info("business waiting register..");
		
		wait.setStoreId(storeId);
		
		waitService.registerOffWaiting(wait);
		
		long id = wait.getId();
		
		return "redirect:/business/manage/?storeId="+storeId;
	}
	
	
	@GetMapping("/modify")
	public String storeModify(Model model,Long storeId, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// 세션에 있는 userId를 불러온다.
		String userId = (String) session.getAttribute("userId");
		
		log.info("business store modify..");
		
		if(storeId == null) {
			storeId = (Long) request.getAttribute("storeId");
		}
		
		StoreVO store = storeService.findByStoreIdWithBStore(storeId);
		
		model.addAttribute("store", store);
		model.addAttribute("userId",userId);
		
		return "/business/manage/modify/modify";
	}
	
	@PostMapping("/modify")
	public String storeModify(Model model,StoreVO store,BStoreVO bstore,RedirectAttributes rttr) {
		
		log.info("business store modify..");
		
		rttr.addFlashAttribute("msg","수정 완료");
		
		if(!storeService.modifyBStore(store)) {
			rttr.addFlashAttribute("storeId",store.getStoreId());
			rttr.addFlashAttribute("msg", "수정 오류");
			return "redirect:/business/manage/modify?storeId="+store.getStoreId();
		}

		return "redirect:/business/manage/modify?storeId="+store.getStoreId();
	}
	
	@GetMapping("/modify/menu")
	public String menuModify(Model model) {
		
		log.info("business menu modify..");
		
		return "/business/manage/modify/menu";
	}
	
	@GetMapping("/enter")
	public String enter(Model model,long storeId,long waitId) {
		
		log.info("business menu modify..");
		
		waitService.enterWating(waitId);
		
		return "redirect:/business/manage?storeId="+storeId;
	}
	
	@GetMapping("/noshow")
	public String noshow(Model model,long storeId,long waitId) {
		
		log.info("business menu modify..");
		
		waitService.panaltyWaiting(waitId);	
		
		return "redirect:/business/manage?storeId="+storeId;
	}


}
