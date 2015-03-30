package com.obprado.model;

import java.math.BigDecimal;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omar
 */
public class ExpenseTest {

    @Test
    public void shouldRecognizeEqualObjects(){
        assertTrue("The expense should know when another object is equal", 
                new Expense(BigDecimal.ZERO, new Date(115, 02, 29), "some reason").
                        equals(new Expense(BigDecimal.ZERO, new Date(115, 2, 29), "some reason")));
    }
    
}
