package com.codingdojo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Artist
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="Name must be between 1-255 characters")
	private String name;

	@Size(min=1,max=255,message="Nationality must be between 1-255 characters")
	private String nationality;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable
	(
		name="artists_songs",
		joinColumns=@JoinColumn(name="artist_id"),
		inverseJoinColumns=@JoinColumn(name="song_id")
	)
	private List<Song> songs;
	
	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Artist()
	{
		
	}
	
	public Artist(String name)
	{
		this.name=name;
	}
};