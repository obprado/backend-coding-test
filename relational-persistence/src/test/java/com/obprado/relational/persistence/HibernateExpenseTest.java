package com.obprado.relational.persistence;

import com.obprado.model.Expense;
import java.math.BigDecimal;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omar
 */
public class HibernateExpenseTest {
    private Expense expectedExpense;
    private HibernateExpense expectedHibernateExpense;
    
    @Test
    public void shouldParseIntoModel(){
        expect(aExpense(      BigDecimal.ZERO, someDate(), someReason())).
                toEqual(aHibernateExpense("0", someDate(), someReason()).toExpense());          
    }     
    
    @Test
    public void shouldParseDecimalAmounts(){
        expect(aExpense(BigDecimal.valueOf(534.23), someDate(), someReason())).
                toEqual(aHibernateExpense("534.23", someDate(), someReason()).toExpense()); 
    }
    
    @Test
    public void shouldParseNegativeAmounts(){
        expect(aExpense(BigDecimal.valueOf(-534.23), someDate(), someReason())).
                toEqual(aHibernateExpense("-534.23", someDate(), someReason()).toExpense()); 
    }
    
    @Test
    public void shouldCompareWithOtherObjects(){
        assertEquals("The HibernateExpense should compare itself with other objects", 
                aHibernateExpense(new String("0"), someDate(), someReason()), 
                aHibernateExpense(new String("0"), someDate(), someReason()));
    }
    
    @Test
    public void shouldMarshallExpenses(){
        expect(aHibernateExpense(aExpense(BigDecimal.ZERO, someDate(), someReason()))).
                toEqual(aHibernateExpense("0",             someDate(), someReason()));
    }

    private Date someDate() {
        return new Date(115, 2, 29, 23, 0, 0);
    }

    private String someReason() {
        return new String("some reason");
    }

    private Expense aExpense(BigDecimal amount, Date date, String reason) {
        return new Expense(amount, date, reason);
    }

    private HibernateExpenseTest expect(Expense expense) {
        this.expectedExpense = expense;
        return this;
    }
    
    private HibernateExpenseTest expect(HibernateExpense expense) {
        this.expectedHibernateExpense = expense;
        return this;
    }

    private HibernateExpense aHibernateExpense(String amount, Date date, String reason) {
        return new HibernateExpense(amount, date, reason);
    }

    private void toEqual(Expense actualExpense) {
        assertEquals("The HibernateExpense should know how to parse into a Expense", 
                expectedExpense, actualExpense);
    }
    
    private void toEqual(HibernateExpense actualExpense) {
        assertEquals("The HibernateExpense should know how to instantiate from a Expense", 
                expectedHibernateExpense, actualExpense);
    }

    private HibernateExpense aHibernateExpense(Expense expense) {
        return new HibernateExpense(expense);
    }
    
}
