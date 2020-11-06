package com.dealight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/business/*")
public class BusinessController {
	
	@GetMapping("/")
	public String list(Model model) {
		
		log.info("business store list..");
		
		return "/business/list";
	}
	
	@GetMapping("/register")
	public String storeRegister(Model model) {
		
		log.info("business store register..");
		
		return "/business/register";
	}
	
	@GetMapping("/manage")
	public String manage(Model model) {
		
		log.info("business manage..");
		
		return "/business/manage/manage";
	}

}
