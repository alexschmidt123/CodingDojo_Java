package com.codingdojo.repositories;

import java.util.List;

import com.codingdojo.models.Project;
import com.codingdojo.models.User;
import com.codingdojo.models.UserProject;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectRepository extends CrudRepository<UserProject,Long>
{
	List<UserProject> findByUserId(Long user_id);
	/*
		select * from users_projects join users_projects.user_id=users.id join users_projects.project_id=projects.id where users.id=1
	*/

	List<UserProject> findByUserIdNot(Long user_id);
	/*
		select * from users_projects
		join  users_projects.user_id=users.id
		join users_projects.project_id=projects.id
		where users.id != ?
	*/

	// void deleteByProjectAndUser(Project project,User user);
	// @Modifying
	// void deleteByProjectIdAndUserId(Long project_id,Long user_id);
	/*
		delete from users_projects
		where users_projects.project_id=?1
		and users_projects.user_id=?2
	*/
};