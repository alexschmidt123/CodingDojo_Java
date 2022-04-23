package com.codingdojo.repositories;

import java.util.List;

import com.codingdojo.models.Project;
import com.codingdojo.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>
{
	// List<Project> findByOwner(User owner);
	/*
		select * from projects
		where projects.owner_id=owner.id
	*/
	// List<Project> findAllByUsersList(Long user_id);

	// @Query(value="SELECT * FROM project LEFT JOIN user on user.id=project.user_id WHERE user.id=?1",nativeQuery=true)
	// List<Project> findByOwner(Long id);

	// List<Project> findByUserIdNot();
}