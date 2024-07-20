package com.ssma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {



	@RequestMapping("/location")
	public String showLocation(Model model) { 

		
		return "content/location";
	}



}
