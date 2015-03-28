package com.obprado.relational.persistence;

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
    
    
}
