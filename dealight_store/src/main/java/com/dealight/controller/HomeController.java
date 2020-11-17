package com.dealight.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dealight.domain.UserVO;
import com.dealight.service.CallService;
import com.dealight.service.UserService;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CallService callService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		
		return "home";
	}
	
	@RequestMapping(value = "/socket", method = RequestMethod.GET)
	public ModelAndView socket(Locale locale, ModelAndView mv) {
		
		// view 화면의 이름을 구성한다.
		mv.setViewName("test");
		
		// 사용자 정보 출력(세션)
		UserVO user = userService.read("kjuioq");
		//UserVO user = (UserVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("user name : " + user.getName());
		System.out.println("normal chat page");
		
		mv.addObject("userId", user.getName());
		
		return mv;
	}

	
	@RequestMapping(value="/oauth", method = RequestMethod.GET)
	public String getOauth(Model model) {
		
		log.info("rest template get oauth..........................");
		
		String restKey = "dba6ebc24e85989c7afde75bd48c5746";
		String redirectURI = "https://localhost:8080";
		
		model.addAttribute("restKey",restKey);
		model.addAttribute("redirectURI",redirectURI);
		
		return "oauth";
	}
	
	@RequestMapping(value="/token", method = RequestMethod.GET)
	public String getToken(Model model, String code) {
		
		log.info("rest template get token..........................");
		
		log.info(code);
		
		String result = callService.getToken(code);
		
		log.info(result);

		model.addAttribute("result", result);

		return "token";
	}
	
	@RequestMapping(value="/message", method = RequestMethod.GET)
	public String test(Model model, String access_token) {
		
		log.info("rest template test..........................");
		
		String result = callService.sendMessage(access_token);
		
		log.info(result);
		
		model.addAttribute("result", result);

		
		return "test";
	}
}
