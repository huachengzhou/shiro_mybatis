package com.blake.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private Logger log = Logger.getLogger(getClass());
	
	@RequestMapping("/main_forward")
	public String home(){
		log.info("main page");
		return "main";
	}
}
