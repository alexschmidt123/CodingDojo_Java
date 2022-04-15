package com.codingdojo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.models.Song;

public interface SongRepository extends CrudRepository<Song,Long>
{

};