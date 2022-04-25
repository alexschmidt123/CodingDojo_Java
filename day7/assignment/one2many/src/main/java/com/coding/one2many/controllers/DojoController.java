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

import com.coding.one2many.models.Dojo;
import com.coding.one2many.models.Ninja;
import com.coding.one2many.services.DojoService;
import com.coding.one2many.services.NinjaService;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	public DojoController(DojoService dojoService, NinjaService ninjaService)
	{
		this.dojoService=dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/dojos")
	public String dojo_list(Model model)
	{
		model.addAttribute("dojos",dojoService.ReadAll());
		return "dojo_list";
	}
	
	
	@GetMapping("/dojos/new")
	public String dojo_new(Model model)
	{
		model.addAttribute("dojo",new Dojo());
		return "dojo_new";
	}
	
	@PostMapping("/dojos/new")
	public String dojo_create
	(
		@Valid @ModelAttribute("dojo") Dojo dojo,
		BindingResult br
	)
	{	
		if(br.hasErrors())
		{
			return "dojo_new";
		}
		dojoService.Create(dojo);
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos/delete/{id}")
	public String dojo_delete
	(
		@PathVariable("id") Long id
	)
	{
//		if(!us.IsLoggedIn(session)) return "redirect:/login";		
		dojoService.Delete(id);
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos/ninjas/{id}")
	public String dojo_ninja(@PathVariable("id") Long id,Model model)
	{
		model.addAttribute("dojo",dojoService.ReadOne(id));
		return "ninja_at_dojo";
	}
}
