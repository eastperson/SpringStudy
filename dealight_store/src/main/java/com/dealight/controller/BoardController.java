package com.dealight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealight.service.HtdlService;
import com.dealight.service.RsvdService;
import com.dealight.service.StoreService;
import com.dealight.service.UserService;
import com.dealight.service.WaitingService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/business/board/")
@AllArgsConstructor
public class BoardController {
	
	private StoreService storeService;
	
	private RsvdService rsvdService;
	
	private HtdlService htdlService;
	
	private WaitingService waitService;
	
	private UserService userService;

}
