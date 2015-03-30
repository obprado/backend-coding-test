package third.party;

import java.math.BigDecimal;
import java.math.BigInteger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omar
 */
public class BigDecimalTest {
    
    @Test
    public void shouldConvertToString(){
        assertEquals("The big decimal should be represented with 2 decimal digits by default", 
                "400.35", new BigDecimal("400.35").toString());
    }
    
    @Test
    public void shouldDetectInvalidNumbers(){
        try {
            new BigDecimal("invalid value");
            fail();
        } catch (NumberFormatException exception){
            
        }
    }
    
    @Test
    public void shouldAcceptForcedScale(){
        assertEquals("The big decimal should be able to change the scale", 
                "40.0", new BigDecimal(400).movePointLeft(1).toString());
        assertEquals("The big decimal should be able to change the scale", 
                "4.00", new BigDecimal(400).movePointLeft(2).toString());
    }
    
}
