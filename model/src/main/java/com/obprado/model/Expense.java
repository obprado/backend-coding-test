package com.obprado.model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author omar
 */
public class Expense implements Serializable{
    private final Currency amount;
    private final Date date;
    private final String reason;

    public Expense(Currency amount, Date date, String reason) {
        this.amount = amount;
        this.date = date;
        this.reason = reason;
    }

    public Currency getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }
    
}
