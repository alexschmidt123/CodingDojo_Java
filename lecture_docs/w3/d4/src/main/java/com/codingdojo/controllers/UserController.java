package com.codingdojo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.services.UserService;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		return UserService.Logout(session);
	}

	@GetMapping("/register")
	public String user_register_get(Model model)
	{
		model.addAttribute("user",new User());
		return "user_register";
	}
	
	@PostMapping("/register")
	public String user_register_post
	(
		@Valid @ModelAttribute("user") User user,
		BindingResult result,
		Model model,
		HttpSession session
	)
	{
		if(result.hasErrors()) return "user_register";
		User errors=userService.Register(user,result);
		if(errors==null) return "user_register";
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String user_login_get(Model model)
	{
		model.addAttribute("user",new LoginUser());
		return "user_login";
	}
	
	@PostMapping("/login")
	public String user_login_post
	(
		@Valid @ModelAttribute("user") LoginUser user, 
		BindingResult result,
		Model model,
		HttpSession session
	)
	{
		if(result.hasErrors()) return "user_login";
		User db_user=userService.Login(user,result,session);
		if(db_user==null) return "user_login";
		return "redirect:/";
	}
};