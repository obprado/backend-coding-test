package com.obprado.usecase;

import com.obprado.model.*;

/**
 *
 * @author omar
 */
public class AddExpense {
    private final ExpenseRepository repository;

    public AddExpense(ExpenseRepository repository) {
        this.repository = repository;
    }
    
    public void add(Expense expense){
        repository.save(expense);
    }
    
}
