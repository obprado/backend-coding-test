package IntegrationTest;

/**
 *
 * @author omar
 */
public class Expense {
    public String amount;
    public String date;
    public String reason;

    public Expense(String amount, String date, String reason) {
        this.amount = amount;
        this.date = date;
        this.reason = reason;
    }
    
    public Expense(){
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}