package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.codingdojo.models.Project;
import com.codingdojo.repositories.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService
{
	@Autowired
	private ProjectRepository projectRepository;

	public ProjectService
	(
		ProjectRepository projectRepository
	)
	{
		this.projectRepository=projectRepository;
	}

	public void Create(Project project)
	{
		projectRepository.save(project);
	}

	public Project ReadOne(Long project_id)
	{
		Optional<Project> project=projectRepository.findById(project_id);
		return project.isPresent()?project.get():null;
	}

	public ArrayList<Project> ReadAll()
	{
		return (ArrayList<Project>)projectRepository.findAll();
	}

	public void Delete(Long project_id)
	{
		projectRepository.deleteById(project_id);
	}
}
