package com.obprado.model;

import java.math.*;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omar
 */
public class ExpenseTest {
    private Expense expense;

    @Test
    public void shouldRecognizeEqualObjects(){
        assertEquals("The expense should know when another object is equal", 
                aSimpleExpense(),
                aSimpleExpense());                     
    }
    
    @Test
    public void shouldCalculateVAT(){
        VATfor(aSimpleExpense(oneHundredPounds())).shouldBe("16.67");              
        VATfor(aSimpleExpense(0)).shouldBe("0.00");                   
        VATfor(aSimpleExpense(200)).shouldBe("33.34");                   
        VATfor(aSimpleExpense(1000)).shouldBe("166.67");                   
        VATfor(aSimpleExpense("432.23")).shouldBe("72.04");                                     
    }

    private String someReason() {
        return new String("some reason");
    }

    private Date someDate() {
        return new Date(115, 02, 29);
    }

    private BigDecimal zero() {
        return BigDecimal.ZERO;
    }

    private Expense aSimpleExpense() {
        return new Expense(zero(), someDate(), someReason());                        
    }

    private Expense aSimpleExpense(int amount) {
        return new Expense(new BigDecimal(amount), someDate(), someReason());
    }
    
    private Expense aSimpleExpense(String amount) {
        return new Expense(new BigDecimal(amount), someDate(), someReason());
    }

    private int oneHundredPounds() {
        return 100;
    }

    private ExpenseTest VATfor(Expense expense) {
        this.expense = expense;
        return this;
    }

    private void shouldBe(String expectedVAT) {
        assertEquals("The expense should know when another object is equal", 
                new BigDecimal(expectedVAT), expense.getVAT());
    }
    
}
