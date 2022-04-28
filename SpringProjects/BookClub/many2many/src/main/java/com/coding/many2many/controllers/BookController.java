package com.coding.many2many.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.many2many.models.Book;
import com.coding.many2many.models.User;
import com.coding.many2many.services.BookService;
import com.coding.many2many.services.UserService;

@Controller
public class BookController
{
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService us;
	
	public BookController
	(
		BookService bookService,
		UserService userService
	)
	{
		this.bookService=bookService;
		this.us=userService;
	}
	@GetMapping("/books")
	public String dashboard(Model model,HttpSession session)
	{
		if(!us.IsLoggedIn(session)) return "redirect:/";
		model.addAttribute("books",bookService.ReadAll());
		Long userId = (Long) session.getAttribute("user_id");
		User loginUser = us.FindById(userId);
		model.addAttribute("loginUser",loginUser);
//		model.addAttribute("user", us.ReadAll());
		return "dashboard";
	}
	
	@GetMapping("/books/new")
	public String book_new(Model model,HttpSession session)
	{
		if(!us.IsLoggedIn(session)) return "redirect:/";
		model.addAttribute("book",new Book());
		model.addAttribute("books",bookService.ReadAll());
		return "addBook";
	}
	
	@PostMapping("/books/new")
	public String book_create
	(
		@Valid @ModelAttribute("book") Book book,
		BindingResult res,
		Model model,
		HttpSession session
	)
	{
		if(!us.IsLoggedIn(session)) return "redirect:/";
		if(res.hasErrors())
		{
			model.addAttribute("books",bookService.ReadAll());
			return "addBook";	
		}
		Long userId = (Long) session.getAttribute("user_id");
		User loginUser = us.FindById(userId);
		book.setUser(loginUser);
		bookService.Create(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
	public String book_show
	(
		@PathVariable("id") Long id,
		Model model,
		HttpSession session
	)
	{
		if(!us.IsLoggedIn(session)) return "redirect:/";		
		model.addAttribute("book",bookService.ReadOne(id));
		return "showBook";
	}
	
	@GetMapping("/books/edit/{id}")
	public String book_edit
	(
		@PathVariable("id") Long id,
		Model model,
		HttpSession session
	)
	{
		if(!us.IsLoggedIn(session)) return "redirect:/";		
		Book book=bookService.ReadOne(id);
		if(book==null) return "redirect:/books";
		model.addAttribute("book",bookService.ReadOne(id));
		return "editBook";
	}	
	
	@PostMapping("/books/update/{id}")
	public String song_update
	(
		@Valid @ModelAttribute("book") Book book,
		BindingResult res,
		Model model,
		@PathVariable("id") Long id,
		HttpSession session
	)
	{		
		if(!us.IsLoggedIn(session)) return "redirect:/";		
		if(res.hasErrors())
		{
			System.out.println("HAS ERRORS");
			return "editBook";
		}
		bookService.Update(book);
		return "redirect:/books";
	}	
	
	@GetMapping("/books/delete/{id}")
	public String book_delete
	(
		@PathVariable("id") Long id,
		HttpSession session
	)
	{
		if(!us.IsLoggedIn(session)) return "redirect:/";		
		bookService.Delete(id);
		return "redirect:/books";
	}
};