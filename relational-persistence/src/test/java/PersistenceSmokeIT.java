import com.obprado.relational.persistence.*;
import java.time.Instant;
import java.util.Date;
import org.hibernate.SessionFactory;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author omar
 */
public class PersistenceSmokeIT {
    private ExpenseDAO dao;
    
    @Test
    public void shouldWorkWithTheDatabase(){
        given(aPersistence());
        whenItSaves(aExpense());
        thenNoExceptionShouldBeRaised();
    }
    
    private void given(ExpenseDAO dao) {
        this.dao = dao;
    }

    private void whenItSaves(HibernateExpense expense) {        
        dao.save(expense);
    }

    private void thenNoExceptionShouldBeRaised() {
        assertTrue(true);
    }

    private ExpenseDAO aPersistence() {
        SessionFactory factory = (SessionFactory) new ClassPathXmlApplicationContext("persistence-context.xml").getBean("sessionFactory");
        return new ExpenseDAO(factory);
    }

    private HibernateExpense aExpense() {
        HibernateExpense expense = new HibernateExpense();
        expense.setAmount("some expense");
        expense.setDate(Date.from(Instant.EPOCH));
        expense.setReason("a very good reason");
        return expense;
    }
    
}
