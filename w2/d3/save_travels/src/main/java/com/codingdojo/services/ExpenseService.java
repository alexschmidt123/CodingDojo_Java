package com.codingdojo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Expense;
import com.codingdojo.repositories.ExpenseRepository;

@Service
public class ExpenseService
{
	private ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository)
	{
		this.expenseRepository=expenseRepository;
	}
	
	public void Create(Expense expense)
	{
		expenseRepository.save(expense);
	}
	
	public ArrayList<Expense> FindAll()
	{
		return (ArrayList<Expense>)expenseRepository.findAll();
	}
};