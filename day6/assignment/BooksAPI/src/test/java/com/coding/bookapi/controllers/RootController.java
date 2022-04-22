package com.coding.bookapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class RootController
{
	/* flash attribute redirect fix: */
	/* org.springframework.validation.BindingResult.model_name */

	@GetMapping("")
	public String index()
	{
		return "index";
	}
};