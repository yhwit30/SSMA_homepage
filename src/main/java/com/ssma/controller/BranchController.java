package com.ssma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchController {
	
	@RequestMapping("/branch")
	public String defaultBranch() {
		
		
		return "content/branch/yangjae";
	}

	@RequestMapping("/branch/yangjae")
	public String yangjae() {
		
		
		return "content/branch/yangjae";
	}
	
	@RequestMapping("/branch/jamsil")
	public String jamsil() {
		
		return "content/branch/jamsil";
	}
	
	
}
