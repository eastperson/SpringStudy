package com.ep.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ep.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping(value = "/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
	@GetMapping("/")
	public String index(Model model,RedirectAttributes rttr) {
		
		log.info("index model : " + model);
		
		Map map = rttr.getFlashAttributes();
		if(map.get("msg") != null)
			model.addAttribute("msg",(String) map.get("msg"));
		
		return "index";
	}
	
	
	@GetMapping("/test1")
	public String test(Model model, RedirectAttributes rttr) {
		
//		model.addAttribute("modelTest", "test1 success");
//		rttr.addFlashAttribute("flashTest","test1 success");
		
		System.out.println("/test1");
		
		return "test";
	}
	
	@GetMapping("/test2")
	public String test2(Model model, RedirectAttributes rttr) {
		
		model.addAttribute("modelTest", "test2 success");
		rttr.addFlashAttribute("flashTest","test2 success");
		
		System.out.println("/test2");
		
		return "redirect:/test1";
	}
	
	
	
	
}
