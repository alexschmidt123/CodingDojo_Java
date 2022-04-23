package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Artist;
import com.codingdojo.repositories.ArtistRepository;

@Service
public class ArtistService
{
	@Autowired
	private ArtistRepository artistRepository;
	
	public ArtistService(ArtistRepository artistRepository)
	{
		this.artistRepository=artistRepository;
	}

	public void Create(Artist artist)
	{
		artistRepository.save(artist);
	}
	
	public ArrayList<Artist> ReadAll()
	{
		return (ArrayList<Artist>)artistRepository.findAll();
	}
	
	public Artist ReadOne(Long id)
	{
		Optional<Artist> artist=artistRepository.findById(id);
		return artist.isPresent()?artist.get():null;
	}
	
	public void Update(Artist artist)
	{
		Create(artist);
	}
	
	public void Delete(Long id)
	{
		artistRepository.deleteById(id);
	}
};