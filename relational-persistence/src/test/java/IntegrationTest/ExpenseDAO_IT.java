package IntegrationTest;

import com.obprado.relational.persistence.*;
import org.junit.Test;
import static IntegrationTest.PersistenceUtil.*;
import static org.junit.Assert.*;

/**
 *
 * @author omar
 */
public class ExpenseDAO_IT {

    private ExpenseDAO dao;

    @Test
    public void shouldInsertExpenses() {
        given(aPersistence());
        theDatabaseShouldBeEmpty();
        whenItSaves(aHibernateExpense());
        thenTheDatabaseShouldHave(oneExpense());
    }

    private void given(ExpenseDAO dao) {
        this.dao = dao;
    }

    private void whenItSaves(HibernateExpense expense) {
        dao.save(expense);
    }

    private void theDatabaseShouldBeEmpty() {
        assertTrue("The database should start being empty", dao.list().isEmpty());
    }

    private int oneExpense() {
        return 1;
    }

    private void thenTheDatabaseShouldHave(int expectedExpenses) {
        assertEquals("The database should contain the expected number of expenses",
                expectedExpenses, 
                dao.list().size());
    }

}
