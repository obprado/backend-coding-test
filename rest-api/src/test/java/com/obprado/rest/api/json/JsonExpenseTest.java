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

    private Expense expense;

    @Test
    public void shouldParseIntoModel() {
        expect(new Expense(BigDecimal.ZERO, someDate(), "some reason")).
                toParseInto(aJsonExpense("0", rawDate(), "some reason"));
        expect(new Expense(BigDecimal.valueOf(12.54), someDate(), "a different reason")).
                toParseInto(aJsonExpense("12.54", rawDate(), "a different reason"));
    }        

    @Test
    public void shouldMarshallFromModel() {
        assertEquals("The JsonExpense should know how to marshall a Expense",
                aJsonExpense("0", "2015-03-29T23:00:00.000Z", "some reason"),
                aJsonExpense(aExpense(BigDecimal.ZERO, new Date(115, 2, 29, 23, 0, 0), "some reason"))
        );
    }

    @Test
    public void shouldRecognizeEqualExpenses() {
        assertEquals("The JsonExpense should recognize a similar object",
                aJsonExpense(new String("0"),
                        new String("2015-03-29T23:00:00.000Z"),
                        new String("some reason")),
                aJsonExpense("0", "2015-03-29T23:00:00.000Z", "some reason"));
    }

    @Test
    public void shouldRecognizeDifferentExpenses() {
        assertNotEquals("The JsonExpense should recognize a different object",
                aJsonExpense("1", "2015-03-29T23:00:00.000Z", "some reason"),
                aJsonExpense("0", "2015-03-29T23:00:00.000Z", "some reason"));

        assertNotEquals("The JsonExpense should recognize a different object",
                aJsonExpense("0", "2014-03-29T23:00:00.000Z", "some reason"),
                aJsonExpense("0", "2015-03-29T23:00:00.000Z", "some reason"));

        assertNotEquals("The JsonExpense should recognize a different object",
                aJsonExpense("0", "2015-03-29T23:00:00.000Z", "another reason"),
                aJsonExpense("0", "2015-03-29T23:00:00.000Z", "some reason"));
    }
    
    @Test
    public void shouldParseVAT(){
        expect(aExpenseOf(hundredPounds())).toParseWithVAT("16.67");
    }

    private JsonExpense aJsonExpense(String amount, String date, String reason) {
        return new JsonExpense(amount, date, reason, "16.67");
    }

    private Expense aExpense(BigDecimal amount, Date date, String reason) {
        return new Expense(amount, date, reason);
    }

    private JsonExpense aJsonExpense(Expense expense) {
        return new JsonExpense(expense);
    }

    private JsonExpenseTest expect(Expense expense) {
        this.expense = expense;
        return this;
    }

    private void toParseInto(JsonExpense expected) {
        assertEquals("The JsonExpense should know how to parse into a Expense",
                expected.toExpense(), expense);
    }

    private Date someDate() {
        return new Date(115, 2, 29, 23, 0, 0);
    }

    private String rawDate() {
        return new String("2015-03-29T23:00:00.000Z");
    }

    private BigDecimal hundredPounds() {
        return new BigDecimal(100);
    }

    private Expense aExpenseOf(BigDecimal amount) {
        return new Expense(amount, someDate(), someReason());
    }

    private String someReason() {
        return new String("some reason");
    }

    private void toParseWithVAT(String expectedVAT) {        
        assertEquals("The VAT should be properly parse into JsonExpense", 
                expectedVAT, new JsonExpense(expense).getVAT());
    }
}
