package com.codingdojo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.codingdojo.models.User;
import com.codingdojo.services.ProjectService;
import com.codingdojo.services.UserProjectService;
import com.codingdojo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController implements ErrorController
{
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserProjectService userProjectService;

	public RootController
	(
		ProjectService projectService,
		UserProjectService userProjectService
	)
	{
		this.projectService=projectService;
		this.userProjectService=userProjectService;
	}

	/* Looks like they want this page to be home page. */
	@GetMapping("/")
	public String root_get(Model model)
	{
		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard
	(
		Model model,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		User user=(User)session.getAttribute("user_id");
		/* all projects */
		model.addAttribute
		(
			"all_projects",
			userProjectService.FindNotByUser(user.getId())
		);

		/* your projects */
		model.addAttribute
		(
			"your_projects",
			userProjectService.FindByUser(user.getId())
		);
		
		return "dashboard";
	}


	@GetMapping("/error")
	public String handleError(HttpServletRequest req,Model model)
	{
		return "404";
	}
};