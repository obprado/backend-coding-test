package IntegrationTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.*;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author omar
 */
public class RESTfull_IT {
    private Collection<Expense> expenses;
    private static final String EXPENSES_URI = "http://localhost:8080/expenses";
    private final RestTemplate restTemplate = new RestTemplate();
    
    @Before
    public void setup(){
        //restTemplate.
    }
    
    @Test
    public void shouldStoreAndRetrieveTaxes(){
        given(theCurrentExpenses());
        whenAdded(aNewExpense());
        thenThereShouldBe(oneMoreExpense(thanThereUsedToBe()));
    }

    private Collection<Expense> theCurrentExpenses() {
        return Arrays.asList(restTemplate.getForObject(EXPENSES_URI, Expense[].class));
    }

    private void given(Collection<Expense> expenses) {
        this.expenses = expenses;
    }

    private Expense aNewExpense() {
        return new Expense("25", "2015-03-09T23:00:00Z", "very good reason");
    }

    private void whenAdded(Expense newExpense) {
        restTemplate.postForObject(EXPENSES_URI, newExpense, Collection.class);
    }

    private int thanThereUsedToBe() {
        return expenses.size();
    }

    private int oneMoreExpense(int i) {
        return i + 1;
    }

    private void thenThereShouldBe(int expectedExpenses) {
        assertEquals("The expense should have been added", 
                expectedExpenses, 
                theCurrentExpenses().size());
    }
    
}
