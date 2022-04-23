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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		if(!model.containsAttribute("duplicate"))
		{
			model.addAttribute("duplicate","");
		}

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
		HttpSession session,
		RedirectAttributes ra
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		if(br.hasErrors())
		{
			return "artist_song_new";
		}
		Long artist_id=artistSong.getArtist().getId();
		Long song_id=artistSong.getSong().getId();
		if(artistSongService.Exists(artist_id,song_id))
		{
			ra.addFlashAttribute("duplicate","An association with these keys already exists.");
			return "redirect:/artist_song";
		}
		artistSongService.Create(artistSong);
		return "redirect:/artist_song";
	}
}
