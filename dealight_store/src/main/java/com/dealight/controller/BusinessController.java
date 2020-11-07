package com.dealight.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dealight.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/business/*")
@AllArgsConstructor
public class BusinessController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/")
	public String list(Model model,HttpServletRequest request) {
		
		log.info("business store list..");
		
		HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("userId");
		
		
		
		model.addAttribute("");
		
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
