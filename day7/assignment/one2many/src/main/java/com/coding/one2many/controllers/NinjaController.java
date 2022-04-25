package com.coding.one2many.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.one2many.models.Ninja;
import com.coding.one2many.services.DojoService;
import com.coding.one2many.services.NinjaService;

@Controller
public class NinjaController
{
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	public NinjaController
	(
		NinjaService ninjaService,
		DojoService dojoService
	)
	{
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	
	@GetMapping("/ninjas")
	public String ninja_list(Model model)
	{
		model.addAttribute("ninjas",ninjaService.ReadAll());
		return "ninja_list";
	}
	
	
	@GetMapping("/ninjas/new")
	public String ninja_new(Model model,HttpSession session)
	{
		model.addAttribute("ninja",new Ninja());
		model.addAttribute("dojos",dojoService.ReadAll());
		return "ninja_new";
	}
	
	@PostMapping("/ninjas/new")
	public String ninja_create
	(
		@Valid @ModelAttribute("ninja") Ninja ninja,
		BindingResult res,
		Model model,
		HttpSession session
	)
	{
		if(res.hasErrors())
		{
			model.addAttribute("ninjas",ninjaService.ReadAll());
			return "ninja_new";	
		}
		ninjaService.Create(ninja);
		return "redirect:/ninjas";
	}
	
	@GetMapping("/ninjas/{id}")
	public String song_show
	(
		@PathVariable("id") Long id,
		Model model,
		HttpSession session
	)
	{	
		model.addAttribute("ninja",ninjaService.ReadOne(id));
		return "ninja_detail";
	}
	
	@GetMapping("/ninjas/edit/{id}")
	public String ninja_edit
	(
		@PathVariable("id") Long id,
		Model model,
		HttpSession session
	)
	{	
		Ninja ninja=ninjaService.ReadOne(id);
		if(ninja==null) return "redirect:/ninjas";
		model.addAttribute("ninja",ninjaService.ReadOne(id));
		model.addAttribute("dojos",dojoService.ReadAll());
		return "ninja_edit";
	}	
	
	@PostMapping("/ninjas/edit/{id}")
	public String ninja_update
	(
		@Valid @ModelAttribute("ninja") Ninja ninja,
		BindingResult res,
		Model model,
		@PathVariable("id") Long id,
		HttpSession session
	)
	{		
//		if(!us.IsLoggedIn(session)) return "redirect:/login";		
		if(res.hasErrors())
		{
			System.out.println("HAS ERRORS");
			return "ninja_edit";
		}
		ninjaService.Update(ninja);
		return "redirect:/ninjas";
	}	
	
	@GetMapping("/ninjas/delete/{id}")
	public String ninja_delete
	(
		@PathVariable("id") Long id,
		HttpSession session
	)
	{
//		if(!us.IsLoggedIn(session)) return "redirect:/login";		
		ninjaService.Delete(id);
		return "redirect:/ninjas";
	}
};
