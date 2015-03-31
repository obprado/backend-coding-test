package IntegrationTest;

import com.obprado.rest.api.json.JsonExpense;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author omar
 */
public class RESTfull_IT {
    private Collection<JsonExpense> expenses;
    private static final String EXPENSES_URI = "http://localhost:8080/expenses";
    private final RestTemplate restTemplate = new RestTemplate();
    
    @Test
    public void shouldStoreAndRetrieveTaxes(){
        given(theCurrentExpenses());
        whenAdded(aNewExpense());
        thenThereShouldBe(oneMoreExpense(thanThereUsedToBe()));
    }

    private Collection<JsonExpense> theCurrentExpenses() {
        return Arrays.asList(restTemplate.getForObject(EXPENSES_URI, JsonExpense[].class));
    }

    private void given(Collection<JsonExpense> expenses) {
        this.expenses = expenses;
    }

    private JsonExpense aNewExpense() {
        return new JsonExpense("25", "2015-03-09T23:00:00.000Z", "very good reason");
    }

    private void whenAdded(JsonExpense newExpense) {
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
