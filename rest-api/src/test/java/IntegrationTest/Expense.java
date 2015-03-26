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
    
}