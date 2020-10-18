package org.ep.controller;

import org.ep.domain.BoardVO;
import org.ep.domain.Criteria;
import org.ep.domain.PageDTO;
import org.ep.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	// 게시판 서비스 로직을 이용하기 위해 선언을 해준다.
	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		
//		log.info("list");
//		model.addAttribute("list", service.getList());
//	}
	
	// get방식으로 '/list'에 접근하면  다음과 같은 로직이 진행된다.
	// 
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		// model.addAttribute("pageMaker", new PageDTO(cri, 123));
		
		int total = service.getTotal(cri);
		
		log.info("total : " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("register : " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	//
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("/get or modif	y");
		model.addAttribute("board", service.get(bno));
	}
	
	//
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("modify:" + board);
		
		if(service.modify(board))
			rttr.addFlashAttribute("result", "success");
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addFlashAttribute("type", cri.getType());
//		rttr.addFlashAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list" + cri.getListLink();
		
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("remove..." + bno);
		
		if(service.remove(bno))
			rttr.addFlashAttribute("result", "success");
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addFlashAttribute("type", cri.getType());
//		rttr.addFlashAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list" + cri.getListLink();
	}
}