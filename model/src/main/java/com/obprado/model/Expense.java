package com.obprado.model;

import java.io.Serializable;
import java.math.*;
import java.util.*;

/**
 *
 * @author omar
 */
public class Expense implements Serializable{
    private final BigDecimal amount;
    private final Date date;
    private final String reason;

    public Expense(BigDecimal amount, Date date, String reason) {
        this.amount = amount;
        this.date = date;
        this.reason = reason;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object obj) {
        Expense other = (Expense)obj;
        return this.amount.equals(other.amount) &&
                this.date.equals(other.date) &&
                this.reason.equals(other.reason);
    }

    public BigDecimal getVAT() {
        return amount.subtract(
                amount.divide(new BigDecimal(1.2), 2, RoundingMode.DOWN));
    }
    
}
