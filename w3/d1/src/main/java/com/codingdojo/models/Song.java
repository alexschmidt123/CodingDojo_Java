package com.codingdojo.models;

import java.util.ArrayList;
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
public class Song
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Song()
	{
		
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getSong_title()
	{
		return song_title;
	}

	public void setSong_title(String song_title)
	{
		this.song_title = song_title;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	@Size(min=1,max=255,message="Song title cannot be blank!")
	private String song_title;

	@Size(min=3,max=255,message="Genre must be between 3-255 characters!")
	private String genre;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable
	(
		name="artists_songs",
		joinColumns=@JoinColumn(name="song_id"),
		inverseJoinColumns=@JoinColumn(name="artist_id")
	)
	private List<Artist> artists;

	public void setArtists(List<Artist> artists)
	{
		this.artists=artists;
	}

	public List<Artist> getArtists()
	{
		return artists;
	}
};