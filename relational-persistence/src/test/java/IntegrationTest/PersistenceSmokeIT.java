package IntegrationTest;

import com.obprado.relational.persistence.*;
import static IntegrationTest.PersistenceUtil.*;
import org.junit.Test;

/**
 *
 * @author omar
 */
public class PersistenceSmokeIT {
    private ExpenseDAO dao;
    
    @Test
    public void shouldWorkWithTheDatabase(){
        given(aPersistence());
        whenItSaves(aHibernateExpense());
        thenNoExceptionShouldBeRaised();
    }
    
    private void given(ExpenseDAO dao) {
        this.dao = dao;
    }

    private void whenItSaves(HibernateExpense aHibernateExpense) {
        dao.save(aHibernateExpense);
    }
       
}
