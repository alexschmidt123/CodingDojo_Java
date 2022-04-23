package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="artists_songs")
public class ArtistSong
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="artist_id")
	private Artist artist;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="song_id")
	private Song song;

	public ArtistSong()
	{

	}

	public void setArtist(Artist artist)
	{
		this.artist=artist;
	}

	public Artist getArtist()
	{
		return this.artist;
	}

	public void setSong(Song song)
	{
		this.song=song;
	}

	public Song getSong()
	{
		return song;
	}

	public void setId(Long id)
	{
		this.id=id;
	}

	public Long getId()
	{
		return id;
	}
};