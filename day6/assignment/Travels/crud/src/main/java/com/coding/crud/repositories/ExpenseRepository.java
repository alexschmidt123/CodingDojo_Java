package com.coding.crud.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.crud.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Long> {
	  	ArrayList<Expense> findAll();
	    ArrayList<Expense> findByDescriptionContaining(String search);
	    Long countByNameContaining(String search);
	    Long deleteByNameStartingWith(String search);
};
