package IntegrationTest;

import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author omar
 */
public class RESTfull_IT {
    private Collection<Expense> expenses;
    
    @Test
    public void shouldStoreAndRetrieveTaxes(){
        given(theCurrentExpenses());
        whenAdded(aNewExpense());
        thenThereShouldBe(oneMoreExpense(thanThereUsedToBe()));
    }

    private Collection<Expense> theCurrentExpenses() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("/expenses", Collection.class);
    }

    private void given(Collection<Expense> expenses) {
        this.expenses = expenses;
    }

    private Expense aNewExpense() {
        return new Expense("25", "2015-03-09T23:00:00Z", "very good reason");
    }

    private void whenAdded(Expense newExpense) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("/expenses", newExpense, Collection.class);
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
