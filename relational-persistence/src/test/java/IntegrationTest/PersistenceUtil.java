package IntegrationTest;

import com.obprado.relational.persistence.*;
import java.time.Instant;
import java.util.Date;
import org.hibernate.SessionFactory;
import static org.junit.Assert.assertTrue;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author omar
 */
public class PersistenceUtil {
    
    public static void thenNoExceptionShouldBeRaised() {
        assertTrue(true);
    }

    public static ExpenseDAO aPersistence() {
        SessionFactory factory = (SessionFactory) 
                new ClassPathXmlApplicationContext("persistence-context.xml").
                getBean("sessionFactory");
        return new ExpenseDAO(factory);
    }
  
    public static HibernateExpense aHibernateExpense() {
        HibernateExpense expense = new HibernateExpense();
        expense.setAmount("3.25");
        expense.setDate(Date.from(Instant.EPOCH));
        expense.setReason("a very good reason");
        return expense;
    }
}
