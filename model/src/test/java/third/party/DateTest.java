package third.party;

import java.text.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omar
 */
public class DateTest {

    @Test
    public void shouldParseTheDate() throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");        
        Date date = df.parse("2015-03-29T23:00:00.000Z");
        //Beware the -1900 year offset!
        assertEquals("The year should be parsed correctly", 2015 - 1900, date.getYear());
        //Beware the -1 month offset!
        assertEquals("The month should be parsed correctly", 2, date.getMonth());
        assertEquals("The day should be parsed correctly", 29, date.getDate());
        assertEquals("The hour should be parsed correctly", 23, date.getHours());
        assertEquals("The minute should be parsed correctly", 0, date.getMinutes());
        assertEquals("The second should be parsed correctly", 0, date.getSeconds());
    }
    
    @Test
    public void shouldFormatTheDate(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");        
        Date date = new Date(115, 02, 29, 23, 0, 0);
        assertEquals("The date should be marsalled with the right format",           
                "2015-03-29T23:00:00.000Z", df.format(date));                
    }
    
}
