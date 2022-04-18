package com.codingdojo.repositories;

import com.codingdojo.models.ArtistSong;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistSongRepository extends CrudRepository<ArtistSong,Long>
{
	
};