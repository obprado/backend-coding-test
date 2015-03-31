package com.obprado.relational.persistence;

import com.obprado.model.Expense;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author omar
 */
public class HibernateExpense {
    private String amount;
    private Date date;
    private String reason;

    public HibernateExpense() {
    }
    
    public HibernateExpense(Expense expense) {
        this.amount = expense.getAmount().toString();
        this.date = expense.getDate();
        this.reason = expense.getReason();
    }

    HibernateExpense(String amount, Date date, String reason) {
        this.amount = amount;
        this.date = date;
        this.reason = reason;
    }

    public String getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    Expense toExpense() {
        return new Expense(new BigDecimal(amount), date, reason);
    }

    @Override
    public boolean equals(Object obj) {
        HibernateExpense theOther = (HibernateExpense)obj;
        return amount.equals(theOther.amount) &&
                date.equals(theOther.date) &&
                reason.equals(theOther.reason);
    }
    
    
}
