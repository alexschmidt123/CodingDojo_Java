package com.codingdojo.repositories;

import com.codingdojo.models.ArtistSong;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistSongRepository extends CrudRepository<ArtistSong,Long>
{
	ArtistSong findByArtistIdAndSongId(Long artist_id,Long song_id);
	/* 
		select * from artist_songs 
		where artist_songs.song_id=song_id
		and artist_songs.artist_id=artist_id
	*/
};