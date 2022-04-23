package com.codingdojo.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RootController
{
	
	@GetMapping("/")
	public String index
	(
		Model model,
		HttpSession session
	)
	{		
		if(session.getAttribute("stories")==null)
		{
			session.setAttribute("stories",new ArrayList<String>());	
		}
		return "index";
	}
	
	@PostMapping("/madlibs")
	public String make_story
	(
		@RequestParam("verb") String verb,
		@RequestParam("adjective") String adjective,
		@RequestParam("adverb") String adverb,
		HttpSession session,
		RedirectAttributes ra
	)
	{
		Integer errors=0;
		if(verb.length()<4)
		{
			ra.addFlashAttribute("verb_err","Verb must be at least 4 characters!");
			errors++;
		}
		if(adjective.length()<4)
		{
			ra.addFlashAttribute("adj_err","Adjective must be at least 4 characters!");
			errors++;
		}
		if(adverb.length()<4)
		{
			ra.addFlashAttribute("adverb_err","Adverb must be at least 4 characters!");
			errors++;
		}
		if(errors>0) return "redirect:/";
		
		String story="They said "+adverb+" was "+adjective+" and it made me "+verb+" forever.";
		ArrayList<String> stories=(ArrayList<String>)session.getAttribute("stories");
		stories.add(story);
		session.setAttribute("stories",stories);
		return "redirect:/";
	}
};