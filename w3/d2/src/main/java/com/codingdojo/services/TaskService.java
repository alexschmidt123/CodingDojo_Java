package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.codingdojo.models.Task;
import com.codingdojo.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService
{
	@Autowired
	private TaskRepository taskRepository;

	public TaskService
	(
		TaskRepository taskRepository
	)
	{
		this.taskRepository=taskRepository;
	}

	public void Create(Task task)
	{
		taskRepository.save(task);
	}

	public Task ReadOne(Long task_id)
	{
		Optional<Task> task=taskRepository.findById(task_id);
		return task.isPresent()?task.get():null;
	}

	public ArrayList<Task> ReadAll()
	{
		return (ArrayList<Task>)taskRepository.findAll();
	}

	public void Delete(Long task_id)
	{
		taskRepository.deleteById(task_id);
	}
}
