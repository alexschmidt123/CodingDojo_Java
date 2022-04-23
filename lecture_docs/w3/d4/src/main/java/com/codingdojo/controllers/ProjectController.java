package com.codingdojo.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.models.Project;
import com.codingdojo.models.Task;
import com.codingdojo.models.User;
import com.codingdojo.models.UserProject;
import com.codingdojo.services.ProjectService;
import com.codingdojo.services.TaskService;
import com.codingdojo.services.UserProjectService;
import com.codingdojo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController
{
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserProjectService userProjectService;
	@Autowired
	private TaskService taskService;

	public ProjectController
	(
		ProjectService projectService,
		UserService userService,
		UserProjectService userProjectService,
		TaskService taskService
	)
	{
		this.projectService=projectService;
		this.userProjectService=userProjectService;
		this.userService=userService;
		this.taskService=taskService;
	}

	@GetMapping("/projects/new")
	public String ProjectNewGet
	(
		Model model,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		model.addAttribute("project",new Project());
		return "project_new";
	}

	@PostMapping("/projects")
	public String ProjectNewPost
	(
		@Valid @ModelAttribute("project") Project project,
		BindingResult br,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		
		if(br.hasErrors())
		{
			Date due_date=project.getDue_date();
			if(due_date!=null)
			{
				if(due_date.before(new Date()))
				{
					br.rejectValue("due_date","past_date","Date must be in the future.");
				}
			}
			return "project_new";
		}
		User user=UserService.GetSession(session);
		project.setOwner(user);
		projectService.Create(project);

		UserProject userProject=new UserProject();
		userProject.setProject(project);
		userProject.setUser(user);
		userProjectService.Create(userProject);
		return "redirect:/dashboard";
	}

	@GetMapping("/projects/edit/{id}")
	public String ProjectUpdateGet
	(
		@PathVariable("id") Long id,
		Model model,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		Project project=projectService.ReadOne(id);
		if(project==null) return "redirect:/projects";
		model.addAttribute("project",project);
		return "project_edit";
	}

	@PostMapping("/projects/update/{id}")
	public String ProjectUpdatePost
	(
		@Valid @ModelAttribute("project") Project project,
		BindingResult br,
		@PathVariable("id") Long id,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		User user=UserService.GetSession(session);
		User project_owner=project.getOwner();
		if(project_owner.getId()!=user.getId())
		{
			for(int i=0;i<100;i++ ) System.out.println("YOU NO DELET");
			return "redirect:/dashboard";
		}
		if(br.hasErrors())
		{
			Date due_date=project.getDue_date();
			if(due_date!=null)
			{
				if(due_date.before(new Date()))
				{
					br.rejectValue("due_date","past_date","Date must be in the future.");
				}
			}
			return "project_edit";
		}
		project.setOwner(user);
		projectService.Create(project);
		return "redirect:/dashboard";
	}

	@GetMapping("/projects/{id}")
	public String ProjectShowGet
	(
		@PathVariable("id") Long id,
		Model model,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		Project project=projectService.ReadOne(id);
		if(project==null) return "redirect:/dashboard";
		model.addAttribute("project",project);
		return "project_show";
	}

	@GetMapping("/projects/delete/{id}")
	public String ProjectDeletePost
	(
		@PathVariable("id") Long id,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		Project project=projectService.ReadOne(id);
		if(project==null) return "redirect:/dashboard";
		User user=UserService.GetSession(session);
		if(project.getOwner().getId()!=user.getId())
		{
			return "redirect:/dashboard";
		}
		projectService.Delete(id);
		return "redirect:/dashboard";
	}

	@GetMapping("/projects/{id}/join")
	public String ProjectJoin
	(
		@PathVariable("id") Long id,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		User user=UserService.GetSession(session);
		Project project=projectService.ReadOne(id);
		if(project==null) return "redirect:/dashboard";
		UserProject userProject=new UserProject();
		userProject.setProject(project);
		userProject.setUser(user);
		userProjectService.Create(userProject);
		return "redirect:/dashboard";
	}

	@GetMapping("/projects/{id}/leave")
	public String ProjectLeave
	(
		@PathVariable("id") Long user_project_id,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		userProjectService.DeleteById(user_project_id);
		return "redirect:/dashboard";
	}

	@GetMapping("/projects/{id}/tasks")
	public String ProjectTaskShowGet
	(
		@PathVariable("id") Long id,
		Model model,
		HttpSession session
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		model.addAttribute("task",new Task());
		Project project=projectService.ReadOne(id);
		if(project==null) return "redirect:/dashboard";
		model.addAttribute("project",project);
		return "task_new";
	}

	@PostMapping("/projects/{id}/tasks")
	public String ProjectTaskShowPost
	(
		@Valid @ModelAttribute("task") Task task,
		BindingResult br,
		@PathVariable("id") Long project_id,
		HttpSession session,
		Model model
	)
	{
		if(!UserService.IsLoggedIn(session)) return UserService.Deny();
		User user=UserService.GetSession(session);
		Project project=projectService.ReadOne(project_id);
		if(project==null) return "redirect:/dashboard";
		if(br.hasErrors())
		{
			model.addAttribute("project",project);
			return "task_new";
		}
		task.setUser(user);
		task.setProject(project);
		taskService.Create(task);
		return "redirect:/projects/"+project_id+"/tasks";
	}
}
