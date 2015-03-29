package com.obprado.usecase;

import com.obprado.model.*;
import java.util.Collection;

/**
 *
 * @author omar
 */
public class ListExpenses {
    private final ExpenseRepository repository;

    public ListExpenses(ExpenseRepository repository) {
        this.repository = repository;
    }
    
    public Collection<Expense> fetch(){
        return repository.list();
    }
    
}
