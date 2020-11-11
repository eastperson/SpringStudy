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

import com.dealight.domain.AllStoreVO;
import com.dealight.domain.BStoreVO;
import com.dealight.domain.HtdlVO;
import com.dealight.domain.MenuVO;
import com.dealight.domain.RsvdVO;
import com.dealight.domain.RevwVO;
import com.dealight.domain.StoreImgVO;
import com.dealight.domain.StoreTagVO;
import com.dealight.domain.StoreVO;
import com.dealight.domain.UserWithRsvdDTO;
import com.dealight.domain.WaitingVO;
import com.dealight.service.HtdlService;
import com.dealight.service.RsvdService;
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
	private RsvdService rsvdService;
	
	@Setter(onMethod_ = @Autowired)
	private HtdlService htdlService;
	
	@Setter(onMethod_ = @Autowired)
	private WaitingService waitService;
	
	@Setter(onMethod_ = @Autowired)
	private UserService userService;
	
	// ������ 1
	@GetMapping("/dealhistory")
	public String dealHistory(Model model,long storeId,HttpServletRequest request) {
		
		log.info("business manage..");
		
		List<HtdlVO> htdlList = htdlService.readAllStoreHtdlList(storeId);
		
		model.addAttribute("htdlList",htdlList);
		
		return "/business/manage/dealhistory";
	}
	
	// ������ 2
	@GetMapping("/reservation")
	public String reservation(Model model, long rsvdId) {
		
		// ���� �󼼸� ������ ���� ������ �����´�.
		RsvdVO rsvd = rsvdService.findRsvdByRsvdIdWithDtls(rsvdId);
		
		log.info("rsvd.............................................................."+rsvd);
		
		List<RsvdVO> rsvdList = userService.getRsvdListStoreUser(rsvd.getStoreId(), rsvd.getUserId());
		
		model.addAttribute("rsvd",rsvd);
		model.addAttribute("rsvdList",rsvdList);
		
		return "/business/manage/reservation";
	}
	
	// ������ ��
	// ������ 1
	@GetMapping("/waiting")
	public String waiting(Model model, long waitId) {
		
		log.info("business waiting detail..");
		
		WaitingVO wait = waitService.read(waitId);
		
		log.info(wait);
		
		// �ش� ���忡 ���� ���°� W�� ����Ʈ�� �����´�.
		List<WaitingVO> curStoreWaitiList = waitService.curStoreWaitList(wait.getStoreId(), "W");
		
		// �ش� ������ ��ȣ�� ���� ��� ������ �����ش�.
		int order = waitService.calWatingOrder(curStoreWaitiList, wait.getId());
		
		// �ش� ������ ��ȣ�� ���� ���� ��� �ð��� �����ش�.
		// ���ð��� �ϴ� ���Ƿ� 15�� �����ߴ�.
		int waitTime = waitService.calWaitingTime(curStoreWaitiList, wait.getId(), 15);
		
		model.addAttribute("wait",wait);
		model.addAttribute("order",order);
		model.addAttribute("waitTime", waitTime);
		
		return "/business/manage/waiting/waiting";
	}
	
	// ������ 0
	@GetMapping("/waiting/register")
	public String waitingRegister(Model model, long storeId) {
		
		log.info("business waiting register..");
		
		Date curTime = new Date();
		
		List<WaitingVO> waitList = waitService.curStoreWaitList(storeId, "W");
		
		int curWaitNum = waitList.size();
		int curWaitTime = curWaitNum * 15;
		
		model.addAttribute("curWaitNum",curWaitNum);
		model.addAttribute("curWaitTime",curWaitTime);
		
		
		model.addAttribute("curTime", curTime);
		model.addAttribute("storeId", storeId);
		
		return "/business/manage/waiting/register";
	}
	
	// ������ 1
	@PostMapping("/waiting/register")
	public String waitingRegister(Model model, WaitingVO wait,HttpServletRequest request,long storeId) {
		
		log.info("business waiting register..");
		
		wait.setStoreId(storeId);
		
		waitService.registerOffWaiting(wait);
		
		
		long id = wait.getId();
		
		return "redirect:/business/manage/?storeId="+storeId;
	}
	
	// ������ 1
	@GetMapping("/modify")
	public String storeModify(Model model,Long storeId, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// ���ǿ� �ִ� userId�� �ҷ��´�.
		String userId = (String) session.getAttribute("userId");
		
		log.info("business store modify get..");
		
		if(storeId == null) {
			storeId = (Long) request.getAttribute("storeId");
		}
		
		AllStoreVO store = storeService.findAllStoreInfoByStoreId(storeId);
		
		log.info("All store......................"+store);
		
		if(store != null) {
			List<MenuVO> menuList = store.getMenuList();
			List<StoreImgVO> imgList = store.getImgList();
			List<RevwVO> revwList = store.getRevwList();
			List<StoreTagVO> tagList = store.getTagList();
			model.addAttribute("menuList",menuList);
			model.addAttribute("imgList",imgList);
			model.addAttribute("revwList",revwList);
			model.addAttribute("tagList",tagList);
			model.addAttribute("lti", store.getLt());
		}
		
		
		model.addAttribute("store", store);
		model.addAttribute("userId",userId);
		
		return "/business/manage/modify/modify";
	}
	
	// ������ 2
	@PostMapping("/modify")
	public String storeModify(Model model,StoreVO store,BStoreVO bstore,RedirectAttributes rttr) {
		
		log.info("business store modify post..");
		
		rttr.addFlashAttribute("msg","���� �Ϸ�");
		
		//log.info("store................" + store);
		
		//log.info("bstore................" + bstore);
		
		store.setBstore(bstore);
		
		if(!storeService.modifyStore(store)) {
			rttr.addFlashAttribute("storeId",store.getStoreId());
			rttr.addFlashAttribute("msg", "���� ����");
			return "redirect:/business/manage/modify?storeId="+store.getStoreId();
		}

		return "redirect:/business/manage/modify?storeId="+store.getStoreId();
	}
	
	@GetMapping("/modify/menu")
	public String menuModify(Model model) {
		
		log.info("business menu modify..");
		
		return "/business/manage/modify/menu";
	}
	
	// ������ 1
	@GetMapping("/enter")
	public String enter(Model model,long storeId,long waitId) {
		
		log.info("business menu modify..");
		
		waitService.enterWaiting(waitId);
		
		return "redirect:/business/manage?storeId="+storeId;
	}
	
	// ������ 1
	@GetMapping("/noshow")
	public String noshow(Model model,long storeId,long waitId) {
		
		log.info("business menu modify..");
		
		waitService.panaltyWaiting(waitId);	
		
		return "redirect:/business/manage?storeId="+storeId;
	}
	
	@PostMapping("/seat")
	public String seatStus(Model model,long storeId, String seatStusColor) {
		
		storeService.changeSeatStus(storeId, seatStusColor);
		
		return "redirect:/business/manage?storeId="+storeId;
	}


}
