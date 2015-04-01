package com.obprado.rest.api.json;

import com.obprado.model.Expense;
import java.math.BigDecimal;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar
 */
public class JsonExpense {
    private String amount;
    private String date;
    private String reason;
    private String VAT;

    public JsonExpense() {        
    }
    
    public JsonExpense(Expense expense) {        
        this.amount = expense.getAmount().toString();
        this.date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(expense.getDate());
        this.reason = expense.getReason();
        this.VAT = expense.getVAT().toString();
    }

    public JsonExpense(String amount, String date, String reason, String VAT) {
        this.amount = amount;
        this.date = date;
        this.reason = reason;
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

    public Expense toExpense() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");            
            Expense expense = new Expense(new BigDecimal(amount), df.parse(date), reason);
            return expense;
        } catch (ParseException ex) {
            Logger.getLogger(JsonExpense.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Couldn't parse date: " + ex.getMessage(), ex);
        }
    }

    @Override
    public boolean equals(Object obj) {
        JsonExpense other = (JsonExpense)obj;
        return amount.equals(other.amount) &&
                date.equals(other.date) &&
                reason.equals(other.reason);
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }
    
    
}
