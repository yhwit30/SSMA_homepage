package com.ssma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistController {



	@RequestMapping("/artist/detail")
	public String getArtist(Model model) { 

		
		return "content/artist/detail";
	}


	@RequestMapping("/artist/list")
	public String showList() {

		return "content/artist";
	}



}
