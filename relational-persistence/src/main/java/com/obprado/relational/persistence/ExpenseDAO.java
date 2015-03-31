package com.obprado.relational.persistence;

import java.util.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omar
 */
@Repository
public class ExpenseDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ExpenseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(HibernateExpense expense) {
        Session session = sessionFactory.openSession();
        session.save(expense);
        session.flush();
    }

    public Collection<HibernateExpense> list() {
        return sessionFactory.
                openSession().
                createCriteria(HibernateExpense.class).
                list();
    }

}
