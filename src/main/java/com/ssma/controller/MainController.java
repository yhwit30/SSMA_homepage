package com.ssma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main")
	public String goHome(Model model) {
		
		model.addAttribute("te", 123);
		
		return "content/main";
	}
	
	@RequestMapping(value = "/")
	public String defaultHome() {
		return "redirect:/main";
	}
	
	
}
