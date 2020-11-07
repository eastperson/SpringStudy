package com.dealight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/business/manage/*")
@AllArgsConstructor
public class ManageController {
	
	@GetMapping("/dealhistory")
	public String dealHistory(Model model) {
		
		log.info("business manage..");
		
		return "/business/manage/dealhistory";
	}
	
	@GetMapping("/reservation")
	public String reservation(Model model) {
		
		log.info("business reservation..");
		
		return "/business/manage/reservation";
	}
	
	@GetMapping("/waiting")
	public String waiting(Model model) {
		
		log.info("business waiting detail..");
		
		return "/business/manage/waiting/waiting";
	}
	
	@GetMapping("/waiting/register")
	public String waitingRegister(Model model) {
		
		log.info("business waiting register..");
		
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
