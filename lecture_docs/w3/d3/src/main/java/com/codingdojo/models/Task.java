package com.codingdojo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public void setId(Long id)
	{
		this.id=id;
	}

	public Long getId()
	{
		return id;
	}

	@Size(min=1,max=255,message="Description must not be blank.")
	private String description;

	public void setDescription(String description)
	{
		this.description=description;
	}

	public String getDescription()
	{
		return description;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt=createdAt;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	public void setUpdatedAt(Date updatedAt)
	{
		this.updatedAt=updatedAt;
	}
	public Date getUpdatedAt()
	{
		return updatedAt;
	}


	// the poster / creator of the task
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	};

	// the project the task belongs to
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	};

	@PrePersist
	public void OnCreate()
	{
		createdAt=new Date();
		updatedAt=new Date();
	}

	@PreUpdate
	public void OnUpdate()
	{
		updatedAt=new Date();
	}

	public Task()
	{

	}
};