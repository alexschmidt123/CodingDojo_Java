package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Song;
import com.codingdojo.repositories.SongRepository;

@Service
public class SongService
{
	@Autowired
	private SongRepository songRepository;

	public SongService(SongRepository songRepository)
	{
		this.songRepository=songRepository;
	}
	
	// C	
	public void Create(Song song)
	{
		songRepository.save(song);
	}
	
	// R
	public Song ReadOne(Long id)
	{
		Optional<Song> song=songRepository.findById(id);		
		return song.isPresent()?song.get():null;
	}
	
	// R
	public ArrayList<Song> ReadAll()
	{
		return (ArrayList<Song>)songRepository.findAll();
	}
	
	//	U.
	public void Update(Song song)
	{
		Create(song);
	}
	
	// D.	
	public void Delete(Long id)
	{
		songRepository.deleteById(id);
	}
};