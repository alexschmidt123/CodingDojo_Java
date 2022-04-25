package com.coding.crud.controllers;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.crud.models.Expense;
import com.coding.crud.services.ExpenseService;
@RestController
public class ExpensesApi {
    private final ExpenseService expenseService;
    public ExpensesApi(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    @RequestMapping("/api/expenses")
    public ArrayList<Expense> index() {
        return expenseService.FindAll();
    }
    
    @RequestMapping(value="/api/expenses", method=RequestMethod.POST)
    public Expense create(@RequestParam(value="name") String name, @RequestParam(value="vendor") String vendor, @RequestParam(value="price") Double price, @RequestParam(value="description") String description) {
        Expense expense = new Expense(name,vendor, price,description);
        return expenseService.Create(expense);
    }
    
    @RequestMapping("/api/expenses/{id}")
    public Expense show(@PathVariable("id") Long id) {
        Expense expense = expenseService.Find(id);
        return expense;
    }
    
    @RequestMapping(value="/api/expenses/{id}", method=RequestMethod.PUT)
    public Expense update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="name") String name, 			@RequestParam(value="vendor") String vendor, 
    		@RequestParam(value="price") Double price,
    		@RequestParam(value="description") String description) {
    	Expense expense = new Expense(name,vendor, price,description);
    	expense.setId(id);
        expenseService.Update(expense);
        return expense;
    }
    
    @RequestMapping(value="/api/expenses/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        expenseService.Delete(id);
    }  
}