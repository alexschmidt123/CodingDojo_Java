package com.codingdojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Long>
{

};