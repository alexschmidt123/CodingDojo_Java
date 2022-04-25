package com.coding.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.mvc.models.Book;
import com.coding.mvc.services.BookService;

@Controller
public class BooksController {
 private final BookService bookService;
 
 public BooksController(BookService bookService) {
     this.bookService = bookService;
 }
 @RequestMapping("/")
 public String toDashboard() {
	 return "redirect:/books";
 }
 @RequestMapping("/books")
 public String dashboard(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "dashboard";
 }
 
 @RequestMapping("/books/{id}")
 public String detail(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "show";
 }

 @GetMapping("/create")
 public String newBook(@ModelAttribute("book") Book book) {
     return "new";
 }
 @PostMapping("/create")
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "new";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }
 }
 
 //update
 @RequestMapping("books/edit/{id}")
 public String edit(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "edit";
 }
 
 @RequestMapping(value="books/edit/{id}", method=RequestMethod.PUT)
 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "edit";
     } else {
         bookService.updateBook(book);
         return "redirect:/books";
     }
 }

 
 @DeleteMapping("/books/{id}/delete")
 public String destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
     return "redirect:/books";
 }
} 
