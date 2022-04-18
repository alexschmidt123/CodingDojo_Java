package com.codingdojo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.models.ArtistSong;
import com.codingdojo.services.ArtistService;
import com.codingdojo.services.ArtistSongService;
import com.codingdojo.services.SongService;
import com.codingdojo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArtistSongContoller
{
	@Autowired
	private ArtistSongService artistSongService;
	@Autowired
	private ArtistService artistService;
	@Autowired
	private SongService songService;

	public ArtistSongContoller
	(
		ArtistSongService artistSongService,
		ArtistService artistService,
		SongService songService
	)
	{
		this.artistSongService=artistSongService;
		this.artistService=artistService;
		this.songService=songService;
	}

	@GetMapping("/artist_song")
	public String artist_song_get(Model model,@ModelAttribute("artist_song") ArtistSong artistSong)
	{
		model.addAttribute("artist_song",new ArtistSong());
		model.addAttribute("artists_songs",artistSongService.ReadAll());
		model.addAttribute("artists",artistService.ReadAll());
		model.addAttribute("songs",songService.ReadAll());
		return "artist_song_new";
	}

	@PostMapping("/artist_song")
	public String artist_song_post
	(
		@Valid @ModelAttribute("artist_song") ArtistSong artistSong,
		BindingResult br,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		if(br.hasErrors())
		{
			return "artist_song_new";
		}
		artistSongService.Create(artistSong);
		return "redirect:/artist_song";
	}
}
