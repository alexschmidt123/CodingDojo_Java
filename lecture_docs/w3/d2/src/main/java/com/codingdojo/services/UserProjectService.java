package com.codingdojo.services;

import java.util.ArrayList;

import com.codingdojo.models.UserProject;
import com.codingdojo.repositories.UserProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProjectService
{
	@Autowired
	private UserProjectRepository userProjectRepository;

	public UserProjectService(UserProjectRepository userProjectRepository)
	{
		this.userProjectRepository=userProjectRepository;
	}

	public ArrayList<UserProject> FindByUser(Long user_id)
	{
		return (ArrayList<UserProject>)userProjectRepository.findByUser(user_id);
	}

	public ArrayList<UserProject> FindNotByUser(Long user_id)
	{
		return (ArrayList<UserProject>)userProjectRepository.findByUserNotContaining(user_id);
	}
};