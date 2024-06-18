package com.ssma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssma.service.ArtistService;
import com.ssma.vo.Artist;

@Controller
public class ArtistController {


	@Autowired
	private ArtistService artistService;


	@RequestMapping("artist/detail")
	public String getArtist(Model model) { 

		
		return "content/artist/detail";
	}


	@RequestMapping("artist/list")
	public String showList(Model model) {
	List<Artist> artists = artistService.getArtists();
		
		
		model.addAttribute("artists", artists);

		return "content/artist";
	}



}
