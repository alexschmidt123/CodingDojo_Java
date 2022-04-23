package com.coding.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.mvc.models.Book;
import com.coding.mvc.services.BookService;

@Controller
public class BooksController {
 private final BookService bookService;
 
 public BooksController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @RequestMapping("/books")
 public String dashboard(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "dashboard.jsp";
 }
 
 @RequestMapping("/books/{id}")
 public String detail(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "show.jsp";
 }
} 
