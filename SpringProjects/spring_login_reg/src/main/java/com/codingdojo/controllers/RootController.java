package com.codingdojo.controllers;

import javax.servlet.http.HttpServletRequest;

import com.codingdojo.models.User;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController implements ErrorController
{
	/* Looks like they want this page to be home page. */
	@GetMapping("/")
	public String root_get(Model model)
	{
		return "redirect:/register";
	}


	@GetMapping("/error")
	public String handleError(HttpServletRequest req,Model model)
	{
		return "404";
	}
};