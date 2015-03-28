package com.obprado.relational.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author omar
 */
public class ExpenseDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ExpenseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(HibernateExpense expense) {
        sessionFactory.openSession().save(expense);
    }

}
