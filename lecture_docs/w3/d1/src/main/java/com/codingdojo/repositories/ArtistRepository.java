package com.codingdojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,Long>
{
};