package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.models.Song;
import com.codingdojo.services.SongService;

@Controller
public class SongController
{
	@Autowired
	private SongService songService;
	
	public SongController(SongService songService)
	{
		this.songService=songService;
	}
	
	@GetMapping("/song")
	public String song_new(Model model)
	{
		model.addAttribute("song",new Song());
		return "song_new";
	}
	
	@PostMapping("/song")
	public String song_create(@Valid @ModelAttribute("song") Song song,BindingResult res)
	{
		if(res.hasErrors()) return "song_new";
		songService.Create(song);
		return "redirect:/song";
	}
};