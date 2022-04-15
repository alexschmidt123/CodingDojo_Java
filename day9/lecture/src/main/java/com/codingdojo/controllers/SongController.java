package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Song;
import com.codingdojo.services.ArtistService;
import com.codingdojo.services.SongService;

@Controller
public class SongController
{
	@Autowired
	private SongService songService;
	@Autowired
	private ArtistService artistService;
	
	public SongController
	(
		SongService songService,
		ArtistService artistService
	)
	{
		this.songService=songService;
		this.artistService=artistService;
	}
	
	@GetMapping("/song")
	public String song_new(Model model)
	{
		model.addAttribute("song",new Song());
		model.addAttribute("songs",songService.ReadAll());
		model.addAttribute("artists",artistService.ReadAll());
		return "song_new";
	}
	
	@PostMapping("/song")
	public String song_create
	(
		@Valid @ModelAttribute("song") Song song,
		BindingResult res,
		Model model
	)
	{
		if(res.hasErrors())
		{
			model.addAttribute("songs",songService.ReadAll());
			return "song_new";	
		}
		songService.Create(song);
		return "redirect:/song";
	}
	
	@GetMapping("/song/{id}")
	public String song_show
	(
		@PathVariable("id") Long id,
		Model model
	)
	{
		model.addAttribute("song",songService.ReadOne(id));
		return "song_show";
	}
	
	@GetMapping("/song/{id}/edit")
	public String song_edit
	(
		@PathVariable("id") Long id,
		Model model
	)
	{
		Song song=songService.ReadOne(id);
		if(song==null) return "redirect:/song";
		model.addAttribute("song",songService.ReadOne(id));
		return "song_edit";
	}	
	
	@PostMapping("/song/{id}/update")
	public String song_update
	(
		@Valid @ModelAttribute("song") Song song,
		BindingResult res,
		Model model,
		@PathVariable("id") Long id
	)
	{		
		if(res.hasErrors())
		{
			System.out.println("HAS ERRORS");
			return "song_edit";
		}
		songService.Update(song);
		return "redirect:/song";
	}	
	
	@PostMapping("/song/{id}/delete")
	public String song_delete
	(
		@PathVariable("id") Long id
	)
	{
		songService.Delete(id);
		return "redirect:/song";
	}
};