package com.dealight.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	final static private String ROOT_FOLDER = "C:\\Users\\kjuio\\Desktop\\ex05";
	
	// 쿼리문 1
	@GetMapping("/dealhistory")
	public String dealHistory(Model model,long storeId,HttpServletRequest request) {
		
		log.info("business manage dealhistory..");
		
		List<HtdlVO> htdlList = htdlService.readAllStoreHtdlList(storeId);
		
		model.addAttribute("htdlList",htdlList);
		
		List<HtdlVO> curList = htdlList.stream().filter(htdl -> 
			htdl.getStusCd().equals("A")
		).collect(Collectors.toList());
		
		model.addAttribute("curList", curList);
		
		return "/business/manage/dealhistory";
	}
	
	// 쿼리문 2
	@GetMapping("/reservation")
	public String reservation(Model model, long rsvdId) {
		
		// 예약 상세를 포함한 예약 정보를 가져온다.
		RsvdVO rsvd = rsvdService.findRsvdByRsvdIdWithDtls(rsvdId);
		
		log.info("rsvd.............................................................."+rsvd);
		
		List<RsvdVO> rsvdList = userService.getRsvdListStoreUser(rsvd.getStoreId(), rsvd.getUserId());
		
		model.addAttribute("rsvd",rsvd);
		model.addAttribute("rsvdList",rsvdList);
		
		return "/business/manage/reservation";
	}
	
	// 쿼리문 0
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
	
	// 쿼리문 1
	@PostMapping("/waiting/register")
	public String waitingRegister(Model model, WaitingVO wait,HttpServletRequest request,long storeId) {
		
		log.info("business waiting register..");
		
		wait.setStoreId(storeId);
		
		waitService.registerOffWaiting(wait);
		
		long id = wait.getId();
		
		return "redirect:/business/manage/?storeId="+storeId;
		//return "redirect:/business/manage/board/?storeId="+storeId;
	}
	
	// 쿼리문 1
	@GetMapping("/modify")
	public String storeModify(Model model,Long storeId, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// 세션에 있는 userId를 불러온다.
		String userId = (String) session.getAttribute("userId");
		
		log.info("business store modify get.." + storeId);
		
		if(storeId == null) {
			storeId = (Long) request.getAttribute("storeId");
		}
		
		AllStoreVO store = storeService.findAllStoreInfoByStoreId(storeId);
		
		log.info("All store......................"+store);
		
		if(store != null) {
			List<MenuVO> menuList = store.getMenuList();
			List<StoreImgVO> imgs = store.getImgs();
			List<RevwVO> revwList = store.getRevwList();
			List<StoreTagVO> tagList = store.getTagList();
			model.addAttribute("menuList",menuList);
			model.addAttribute("imgs",imgs);
			model.addAttribute("revwList",revwList);
			model.addAttribute("tagList",tagList);
			model.addAttribute("lti", store.getLt());
		}
		
		
		model.addAttribute("store", store);
		model.addAttribute("userId",userId);
		
		return "/business/manage/modify/modify";
	}
	
	// 쿼리문 2
	@PostMapping("/modify")
	public String storeModify(Model model,AllStoreVO store,RedirectAttributes rttr) {
		
		log.info("business store modify post..");
		
		rttr.addFlashAttribute("msg","수정 완료");
		
		log.info("store................" + store);
		
		
		if(!storeService.modifyStore(store)) {
			rttr.addFlashAttribute("storeId",store.getStoreId());
			rttr.addFlashAttribute("msg", "수정 오류");
			return "redirect:/business/manage/modify?storeId="+store.getStoreId();
		}
		 
		return "redirect:/business/manage/modify?storeId="+store.getStoreId();
	}
	
	@GetMapping(value = "/getStoreImgs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<StoreImgVO>> getStoreImage(long storeId) {
		
		log.info("getAttachList" + storeId);
		
		return new ResponseEntity<>(storeService.getStoreImageList(storeId), HttpStatus.OK);
	}
	
	private void deleteFiles(List<StoreImgVO> imgs) {
		if(imgs == null || imgs.size() == 0) {
			return;
		}
		
		log.info("delete imgs..................");
		log.info(imgs);
		
		imgs.forEach(img -> {
			
			try {
				Path file = Paths.get(img.getUploadPath() + "\\" + img.getUuid() + "_" + img.getFileName());
				
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get(img.getUploadPath() +"\\s_" + img.getUuid()
								+ "_" + img.getFileName());
					
					Files.delete(thumbNail);
							
				}
			} catch(Exception e) {
				log.error("delete file error" + e.getMessage());
			} // end catch
		}); // end for each
	}
	


	
	@GetMapping("/menu")
	public String menuModify(Model model, long storeId) {
		
		log.info("business menu modify..");
		
		List<MenuVO> menus = storeService.findMenuByStoreId(storeId);
		
		model.addAttribute("menus",menus);
		model.addAttribute("storeId",storeId);
		
		return "/business/manage/modify/menu";
	}
	
	@PostMapping("/menu/register")
	public String menuModify(Model model, MenuVO menu) {
		
		log.info("business menu register..");
		
		log.info("menu......" + menu);
		
		if(menu.getRecoMenu().equalsIgnoreCase("on"))
			menu.setRecoMenu("Y");
		else
			menu.setRecoMenu("N");
		
		storeService.registerMenu(menu);
		
		return "redirect:/business/manage/menu?storeId="+menu.getStoreId();
	}
	
	// 쿼리문 1
	@GetMapping("/enter")
	public String enter(Model model,long storeId,long waitId) {
		
		log.info("business menu modify..");
		
		waitService.enterWaiting(waitId);
		
		return "redirect:/business/manage?storeId="+storeId;
	}
	
	// 쿼리문 1
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

	@GetMapping("/board")
	public String getBoard(Model model, long storeId) {
		
		
		model.addAttribute("storeId", storeId);
		
		return "/board";
	}

}
