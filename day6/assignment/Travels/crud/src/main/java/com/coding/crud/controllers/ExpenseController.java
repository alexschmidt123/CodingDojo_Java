package com.coding.crud.controllers;


import java.util.ArrayList;

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

import com.coding.crud.models.Expense;
import com.coding.crud.services.ExpenseService;

@Controller
public class ExpenseController {
	
	 private final ExpenseService expenseService;
	 
	 public ExpenseController(ExpenseService expenseService) {
	     this.expenseService = expenseService;
	 }
	
	@GetMapping("/")
	public String index_0() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(Model model) {
		 ArrayList<Expense> expenses = expenseService.FindAll();
	     model.addAttribute("expenses", expenses);
		 return "expenses";
	}
	@RequestMapping("/expenses/{id}")
	 public String detail(@PathVariable("id") Long id, Model model) {
	     Expense expense = expenseService.Find(id);
	     model.addAttribute("expense", expense);
	     return "expenses_show";
	 }

	
	@GetMapping("/create") 
	public String newExpense(@ModelAttribute("expense")Expense expense) {
		return "expenses_new"; 
	}
		  
		 @PostMapping("/create") 
		 public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult
		 result) { 
			 if (result.hasErrors()) { 
				 return "expenses_new"; 
			 } else {
				 expenseService.Create(expense); 
				 return "redirect:/expenses";
			 } 
		 }
	
	 
	 //update
	 @RequestMapping("expenses/edit/{id}")
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Expense expense = expenseService.Find(id);
	     model.addAttribute("expense",expense);
	     return "expenses_edit";
	 }
	 
	 @RequestMapping(value="expenses/edit/{id}", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	     if (result.hasErrors()) {
	         return "expenses_edit";
	     } else {
	         expenseService.Update(expense);
	         return "redirect:/expenses";
	     }
	 }

	 
	 @DeleteMapping("/expenses/delete/{id}")
	 public String destroy(@PathVariable("id") Long id) {
	     expenseService.Delete(id);
	     return "redirect:/expenses";
	 }
}
