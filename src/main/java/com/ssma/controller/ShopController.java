package com.ssma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {



	@RequestMapping("shop")
	public String contact(Model model) { 

		
		return "content/shop";
	}





}
