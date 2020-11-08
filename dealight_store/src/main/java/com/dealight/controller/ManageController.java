package com.dealight.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dealight.domain.BStoreVO;
import com.dealight.domain.HotDealVO;
import com.dealight.domain.ReservationVO;
import com.dealight.domain.StoreVO;
import com.dealight.service.HotDealService;
import com.dealight.service.ReservationService;
import com.dealight.service.StoreService;

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
		
		model.addAttribute("rsvd",rsvd);
		
		return "/business/manage/reservation";
	}
	
	@GetMapping("/waiting")
	public String waiting(Model model) {
		
		log.info("business waiting detail..");
		
		return "/business/manage/waiting/waiting";
	}
	
	@GetMapping("/waiting/register")
	public String waitingRegister(Model model,StoreVO store, BStoreVO bstore) {
		
		log.info("business waiting register..");
		
		store.setBstore(bstore);
		
		return "/business/manage/waiting/register";
	}
	
	
	@GetMapping("/modify")
	public String storeModify(Model model) {
		
		log.info("business store modify..");
		
		return "/business/manage/modify/modify";
	}
	
	@GetMapping("/modify/menu")
	public String menuModify(Model model) {
		
		log.info("business menu modify..");
		
		return "/business/manage/modify/menu";
	}

}
