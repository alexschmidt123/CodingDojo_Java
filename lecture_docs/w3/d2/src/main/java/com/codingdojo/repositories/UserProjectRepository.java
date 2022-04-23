package com.codingdojo.repositories;

import java.util.List;

import com.codingdojo.models.UserProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectRepository extends CrudRepository<UserProject,Long>
{
	List<UserProject> findByUser(Long user_id);
	/*
		select * from users_projects
		join  users_projects.user_id=users.id
		join users_projecst.project_id=projects.id
		where users.id=?
	*/

	List<UserProject> findByUserNotContaining(Long user_id);
	/*
		select * from users_projects
		join  users_projects.user_id=users.id
		join users_projecst.project_id=projects.id
		where users.id != ?
	*/
};