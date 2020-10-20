package com.ep.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.ep.domain.Grade;
import com.ep.domain.UserVO;
import com.ep.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users/test")
	public String test() {
		
		System.out.println("test");
		
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String register() {
		
		System.out.println("/users/registerForm get...");
		
		return "registerForm";
	}
	
	
	@PostMapping("/register")
	public String register(Model model,HttpSession session, String id, String pw, String name
			,String email, String phoneNum, String dateOfBirth, Grade grade,String prePath) {
		
		System.out.println("/users/register post...");
		Date date = new Date();
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		UserVO user = new UserVO(id,pw,name,email,phoneNum,date,grade);
		
		userService.register(user);
		
		session.setAttribute("id", user.getId());
		
		return "redirect:/";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, String id, String pw, String prePath, HttpServletRequest request,RedirectAttributes rttr) {
		
		System.out.println("/users/login post...");
		
		UserVO user = userService.login(id, pw);
		
		if(user == null) {
			rttr.addFlashAttribute("msg", "로그인 오류");
			return "redirect:/";
		}
			
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", user.getId());
		
		return "redirect:"+"/";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		System.out.println("/users/login get...");
	
		return "redirect:"+"/";
	}
	
	@GetMapping("/mypage")
	public String myPage(Model model, HttpServletRequest request, String id) {
		
		System.out.println("/users/mypage get....");
		
		UserVO user;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("id") != null) {
			user = userService.get((String) session.getAttribute("id"));
			model.addAttribute("user", user);
			
			if(id != null)
				model.addAttribute("modify", "true");
			
			return "myPage";
		}
		
		model.addAttribute("msg","mypage를 보기위해서 로그인을 해주세요.");
		
		return "index";
		
	}
	
	@PostMapping("/mypage")
	public String myPage(Model model,String id,String pw, String name, String email, String phoneNum) {
		
		System.out.println("/users/mypage post....");
		
		UserVO user = userService.get(id);
		user.setPw(pw);
		user.setName(name);
		user.setEmail(email);
		user.setPhoneNum(phoneNum);
		
		if(userService.isValidModifyUser(user)) {
			userService.modify(user);
			return "redirect:mypage";
		}
		
		
		return "myPage";
	}
	
	@GetMapping("/list")
	public String userList(Model model) {
		
		System.out.println("/users/list get....");
		
		List<UserVO> userList = userService.getList();
		
		model.addAttribute("userList", userList);
		
		return "userList";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		
		System.out.println("/users/logout get....");
		
		userService.logout(session);
		
		return "redirect:/";
	}
	
	@GetMapping("/withdraw")
	public String widthdraw(Model model, HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		
		System.out.println("/users/withdraw get....");
		
		userService.remove(id);
		
		userService.logout(session);
		
		return "redirect:/";
	}

}
