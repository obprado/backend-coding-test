package com.obprado.relational.persistence;

import com.obprado.model.*;
import java.util.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omar
 */
@Repository
public class ExpenseDAO implements ExpenseRepository{
    private final SessionFactory sessionFactory;
    
    @Override
    public void save(Expense expense) {
        save(new HibernateExpense(expense));
    }

    @Override
    public Collection<Expense> list() {
        Collection<Expense> expenses = new ArrayList();
        Collection<HibernateExpense> hibernateExpenses = listRows();
        for (HibernateExpense hibernateExpense : hibernateExpenses)
            expenses.add(hibernateExpense.toExpense());
        return expenses;
    }


    @Autowired
    public ExpenseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(HibernateExpense expense) {
        Session session = sessionFactory.openSession();
        session.save(expense);
        session.flush();
    }

    public Collection<HibernateExpense> listRows() {
        return sessionFactory.
                openSession().
                createCriteria(HibernateExpense.class).
                list();
    }

}
