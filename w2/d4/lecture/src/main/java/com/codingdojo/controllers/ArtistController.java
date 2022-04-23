package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Artist;
import com.codingdojo.services.ArtistService;

@Controller
public class ArtistController
{
	@Autowired
	private ArtistService artistService;
	
	public ArtistController(ArtistService artistService)
	{
		this.artistService=artistService;
	}

	@GetMapping("/artist")
	public String artist_new(Model model)
	{
		model.addAttribute("artist",new Artist());
		model.addAttribute("artists",artistService.ReadAll());
		return "artist_new";
	}
	
	@PostMapping("/artist")
	public String artist_create
	(
		@Valid @ModelAttribute("artist") Artist artist,
		BindingResult br
	)
	{
		if(br.hasErrors())
		{
			return "artist_new";
		}
		artistService.Create(artist);
		return "redirect:/artist";
	}
};