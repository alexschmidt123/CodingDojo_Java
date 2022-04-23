package com.codingdojo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController
{

	@GetMapping("/expenses")
	public String index()
	{
		return "expenses";
	}
};