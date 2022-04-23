package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Size(min=1,max=255,message="Song title cannot be blank!")
	private String song_title;

	@Size(min=3,max=255,message="Genre must be between 3-255 characters!")
	private String genre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="not_artist_id")
	private Artist artist;
};