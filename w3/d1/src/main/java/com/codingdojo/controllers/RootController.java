package com.codingdojo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController implements ErrorController
{
	@GetMapping("")
	public String Root()
	{
		return "redirect:/song";
	}

	@GetMapping("/error")
	public String handleError(HttpServletRequest req,Model model)
	{
		return "404";
	}
};