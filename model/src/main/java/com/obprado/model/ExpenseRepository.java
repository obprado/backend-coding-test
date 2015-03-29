package com.obprado.model;

import java.util.Collection;

/**
 *
 * @author omar
 */
public interface ExpenseRepository {

    public void save(Expense expense);
    public Collection<Expense> list();
    
}
