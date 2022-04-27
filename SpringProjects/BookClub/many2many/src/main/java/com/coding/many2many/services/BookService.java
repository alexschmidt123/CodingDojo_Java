package com.coding.many2many.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.many2many.models.Book;
import com.coding.many2many.repositories.BookRepository;

@Service
public class BookService
{
	@Autowired
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository)
	{
		this.bookRepository=bookRepository;
	}

	public void Create(Book book)
	{
		bookRepository.save(book);
	}
	
	public ArrayList<Book> ReadAll()
	{
		return (ArrayList<Book>)bookRepository.findAll();
	}
	
	public Book ReadOne(Long id)
	{
		Optional<Book> book=bookRepository.findById(id);
		return book.isPresent()?book.get():null;
	}
	
	public void Update(Book book)
	{
		Create(book);
	}
	
	public void Delete(Long id)
	{
		bookRepository.deleteById(id);
	}
};