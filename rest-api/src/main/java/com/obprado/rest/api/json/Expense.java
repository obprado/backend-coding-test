package com.obprado.rest.api.json;

/**
 *
 * @author omar
 */
public class Expense {
    private String amount;
    private String date;
    private String reason;

    public Expense() {        
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    
}
