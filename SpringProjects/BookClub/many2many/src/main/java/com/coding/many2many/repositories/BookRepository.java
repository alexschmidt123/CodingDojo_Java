package com.coding.many2many.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.many2many.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>
{

};