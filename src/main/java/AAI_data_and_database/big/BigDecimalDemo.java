package AAI_data_and_database.big;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

import org.junit.Test;

/**
 * BigDecimal represents an immutable arbitrary-precision signed decimal number. It consists of two parts:

    Unscaled value – an arbitrary precision integer
    Scale – a 32-bit integer representing the number of digits to the right of the decimal point

For example, the BigDecimal 3.14 has the unscaled value of 314 and the scale of 2.

We use BigDecimal for high-precision arithmetic. We also use it for calculations requiring control over scale 
and rounding off behavior.  One such example is calculations involving financial transactions.
 * 
 * */

public class BigDecimalDemo {

	//We can create a BigDecimal object from String, character array, int, long, and BigInteger:
	
	@Test
	public void whenBigDecimalCreated_thenValueMatches() {
	    BigDecimal bdFromString = new BigDecimal("0.1");
	    BigDecimal bdFromCharArray = new BigDecimal(new char[] {'3','.','1','6','1','5'});
	    BigDecimal bdlFromInt = new BigDecimal(42);
	    BigDecimal bdFromLong = new BigDecimal(123412345678901L);
	    BigInteger bigInteger = BigInteger.probablePrime(100, new Random());
	    BigDecimal bdFromBigInteger = new BigDecimal(bigInteger);
	        
	    assertEquals("0.1",bdFromString.toString());
	    assertEquals("3.1615",bdFromCharArray.toString());
	    assertEquals("42",bdlFromInt.toString());
	    assertEquals("123412345678901",bdFromLong.toString());
	    assertEquals(bigInteger.toString(),bdFromBigInteger.toString());
	    
	    //In addition, we can convert double and long to BigDecimal using the valueOf static method:
	    
	    BigDecimal bdFromLong1 = BigDecimal.valueOf(123412345678901L);
	    BigDecimal bdFromLong2 = BigDecimal.valueOf(123412345678901L, 2);
	    System.out.println(bdFromLong2); //use 2 decimal places, output = 1234123456789.01
	    BigDecimal bdFromDouble = BigDecimal.valueOf(0.1d);

	    assertEquals("123412345678901", bdFromLong1.toString());
	    assertEquals("1234123456789.01", bdFromLong2.toString());
	    assertEquals("0.1", bdFromDouble.toString());
	    
	    //operations
	    BigDecimal bd = new BigDecimal("-12345.6789");
	    BigDecimal bd_2 = new BigDecimal("-12.67");
        
	    assertEquals(9, bd.precision()); //number of numbers
	    System.out.println("using precision()");
	    System.out.println(bd_2.precision()); //4
	    assertEquals(4, bd.scale()); //number of decimal places
	    assertEquals(-1, bd.signum()); //-1 if value is negative
	    
	    //comparing values. ignoring the scale, so bd1 and bd2 are same
	    BigDecimal bd1 = new BigDecimal("1.0");
	    BigDecimal bd2 = new BigDecimal("1.00");
	    BigDecimal bd3 = new BigDecimal("2.0");
	    BigDecimal bd4 = new BigDecimal("2.03");

	    assertTrue(bd1.compareTo(bd3) < 0);
	    assertTrue(bd3.compareTo(bd1) > 0);
	    assertTrue(bd1.compareTo(bd2) == 0);
	    assertTrue(bd1.compareTo(bd3) <= 0);
	    assertTrue(bd1.compareTo(bd2) >= 0);
	    assertTrue(bd1.compareTo(bd3) != 0);
	    
	    assertTrue(bd3.compareTo(bd4) < 0);
	    
	    //to consider also the scale, e.g. 1.0 != 1.00
	    bd1 = new BigDecimal("1.0");
	    bd2 = new BigDecimal("1.00");
	        
	    assertFalse(bd1.equals(bd2));
	    
	    //arithmetic operations
	    bd1 = new BigDecimal("4.0");
	    bd2 = new BigDecimal("2.0");

	    BigDecimal sum = bd1.add(bd2);
	    BigDecimal difference = bd1.subtract(bd2);
	    BigDecimal quotient = bd1.divide(bd2);
	    BigDecimal product = bd1.multiply(bd2);

	    assertTrue(sum.compareTo(new BigDecimal("6.0")) == 0);
	    assertTrue(difference.compareTo(new BigDecimal("2.0")) == 0);
	    assertTrue(quotient.compareTo(new BigDecimal("2.0")) == 0);
	    assertTrue(product.compareTo(new BigDecimal("8.0")) == 0);
	    
	    //rounding...there are further rounding enums, like CEILING,FLOOR...
	    bd = new BigDecimal("2.5");
	    // Round to 1 digit using HALF_EVEN
	    BigDecimal rounded = bd
	        .round(new MathContext(1, RoundingMode.HALF_EVEN)); //bankers rounding
	    
	    assertEquals("2", rounded.toString());
	    
	    bd = new BigDecimal("2.6");
	    
	    rounded = bd
		        .round(new MathContext(1, RoundingMode.HALF_EVEN));

	    assertEquals("3", rounded.toString()); //bankers rounding
	    
	    bd = new BigDecimal("2.6567");
	    
	    rounded = bd
		        .round(new MathContext(3, RoundingMode.HALF_EVEN)); //round it to 2 decimal places
	    
	    System.out.println("initial value = "+bd+", rounded value with 2 decimal places and bankers rounding = "+rounded);
	    
	    
	}
}
