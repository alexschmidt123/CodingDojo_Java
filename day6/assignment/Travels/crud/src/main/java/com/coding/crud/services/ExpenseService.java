package com.coding.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.crud.models.Expense;
import com.coding.crud.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	public ArrayList<Expense> FindAll(){
		return expenseRepository.findAll();
	}
	public Expense Create(Expense expense) {
		return expenseRepository.save(expense);
	}
	public Expense Find(Long id) {
	    Optional<Expense> optionalExpense = expenseRepository.findById(id);
	    if(optionalExpense.isPresent()) {
	    	return optionalExpense.get();
	    } else {
	        return null;
	    }
	} 
	public void Delete(Long id) {
		expenseRepository.deleteById(id);
	}
	public Expense Update(Expense expense) {
		 return expenseRepository.save(expense);
	}
}
