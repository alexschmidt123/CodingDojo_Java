package com.codingdojo.repositories;

import com.codingdojo.models.Project;
import com.codingdojo.models.Task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long>
{
};