package com.ssma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistController {

	@RequestMapping("/artist/허원경")
	public String showArtist1() {

		return "content/artist허원경";
	}

	@RequestMapping("/artist/허대욱")
	public String showArtist2() {

		return "content/artist허대욱";
	}

	@RequestMapping("/artist/임재민")
	public String showArtist3() {

		return "content/artist임재민";
	}

	@RequestMapping("/artist/허병훈")
	public String showArtist4() {

		return "content/artist허병훈";
	}

}
