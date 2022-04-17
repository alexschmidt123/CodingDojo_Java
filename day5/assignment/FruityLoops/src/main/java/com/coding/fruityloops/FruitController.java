package com.coding.fruityloops;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController{
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("fruit","banana");
		return "index.jsp";
	}
}