package com.codingdojo.services;

import java.util.ArrayList;

import com.codingdojo.models.ArtistSong;
import com.codingdojo.repositories.ArtistSongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistSongService
{
	@Autowired
	private ArtistSongRepository artistSongRepository;

	public ArtistSongService(ArtistSongRepository artistSongRepository)
	{
		this.artistSongRepository=artistSongRepository;
	}

	public void Create(ArtistSong artistSong)
	{
		artistSongRepository.save(artistSong);
		/* insert into artist_songs(artist_id,song_id) values(2,3); */
	}

	public ArrayList<ArtistSong> ReadAll()
	{
		/*
			select * from artist_songs
			join artists on artists.id=artist_songs.artist_id
			join songs on songs.id=artist_songs.song_id
		*/
		return (ArrayList<ArtistSong>)artistSongRepository.findAll();
	}
}
