package com.coding.many2many.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.many2many.models.LoginUser;
import com.coding.many2many.models.User;
import com.coding.many2many.services.UserService;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	
	
	@GetMapping("/")
	public String login_register(Model model)
	{
		model.addAttribute("loginUser",new LoginUser());
		model.addAttribute("registerUser",new User());
		return "loginRegister";
	}
	
	@PostMapping("/login_user")
	public String user_login(
			@Valid @ModelAttribute("loginUser")LoginUser loginUser, 
			BindingResult result, 
			HttpSession session,
			Model viewModel
			) 
	{

		if(result.hasErrors()) {
			viewModel.addAttribute("registerUser", new User());
			return "loginRegister";
		}
		User db_user = userService.login(loginUser,result);
		if(db_user==null)
		{
			viewModel.addAttribute("loginUser",new LoginUser());
			return "loginRegister";
		}
		session.setAttribute("user_id",db_user.getId());
		return "redirect:/books";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		userService.Logout(session);
		return "redirect:/";
	}

	@PostMapping("/register_user")
	public String user_register
	(
		@Valid @ModelAttribute("registerUser") User registerUser,
        BindingResult result,
        HttpSession session,
        Model viewModel
	)
	{
		if(result.hasErrors()) {
			viewModel.addAttribute("loginUser", new LoginUser());
			return "loginRegister";
		}
		User errors=userService.register(registerUser,result);
		if(errors==null)
		{
			viewModel.addAttribute("loginUser", new LoginUser());
			return "loginRegister";
		}
		return "redirect:/";
	}
}; 