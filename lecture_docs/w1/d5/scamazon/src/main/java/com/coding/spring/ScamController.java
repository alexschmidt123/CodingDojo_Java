package com.coding.spring;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.spring.models.Item;

@Controller
public class ScamController
{
	
	@RequestMapping("")
	public String index(Model model)
	{
		Item i1=new Item("Fake Watch","It's Real!",50000.00);
		Item i2=new Item("One Shoe","Hole where the big is. Other sold separately.",300.00);
		Item i3=new Item("Real Watch","It's fake",30.00);
		
		ArrayList<Item> scam_items=new ArrayList<Item>();
		scam_items.add(i1);
		scam_items.add(i2);
		scam_items.add(i3);
		
		model.addAttribute("scam_items",scam_items);
		
		return "index";
	}
	
	
};