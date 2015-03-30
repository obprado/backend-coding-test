package com.obprado.rest.api.json;

import com.obprado.model.Expense;
import java.math.BigDecimal;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omar
 */
public class JsonExpenseTest {

    @Test
    public void shouldParseIntoModel() {
        assertTrue("The JsonExpense should know how to parse into a Expense",
                aExpense(    BigDecimal.ZERO, new Date(115, 2, 29, 23, 0, 0), "some reason").equals(
                aJsonExpense("0",             "2015-03-29T23:00:00.000Z",     "some reason")
                        .toExpense()));
    }

    @Test
    public void shouldMarshallFromModel() {
        assertEquals("The JsonExpense should know how to marshall a Expense", 
               aJsonExpense(         "0",             "2015-03-29T23:00:00.000Z",     "some reason"),
                aJsonExpense(aExpense(BigDecimal.ZERO, new Date(115, 2, 29, 23, 0, 0), "some reason"))
                );
    }
    
    @Test
    public void shouldRecognizeEqualExpenses(){
        assertEquals("The JsonExpense should recognize a similar object", 
                aJsonExpense(new String("0"),
                        new String("2015-03-29T23:00:00.000Z"),
                        new String("some reason")),
                aJsonExpense("0","2015-03-29T23:00:00.000Z","some reason"));
    }
    
    @Test
    public void shouldRecognizeDifferentExpenses(){
        assertNotEquals("The JsonExpense should recognize a different object", 
                aJsonExpense("1","2015-03-29T23:00:00.000Z","some reason"),
                aJsonExpense("0","2015-03-29T23:00:00.000Z","some reason"));
        
        assertNotEquals("The JsonExpense should recognize a different object", 
                aJsonExpense("0","2014-03-29T23:00:00.000Z","some reason"),
                aJsonExpense("0","2015-03-29T23:00:00.000Z","some reason"));
        
        assertNotEquals("The JsonExpense should recognize a different object", 
                aJsonExpense("0","2015-03-29T23:00:00.000Z","another reason"),
                aJsonExpense("0","2015-03-29T23:00:00.000Z","some reason"));
    }

    private JsonExpense aJsonExpense(String amount, String date, String reason) {
        return new JsonExpense(amount, date, reason);
    }

    private Expense aExpense(BigDecimal amount, Date date, String reason) {
        return new Expense(amount, date, reason);
    }

    private JsonExpense aJsonExpense(Expense expense) {
        return new JsonExpense(expense);
    }
}
