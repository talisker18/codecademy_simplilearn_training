package AAI_data_and_database.big;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Random;

import org.junit.Test;

/**
 * 
 * It is used when integers involved are larger than the limit of long type. For example, 
 * the factorial of 50 is 30414093201713378043612608166064768844377641568960512000000000000. 
 * This value is too big for an int or long data type to handle. It can only be stored in a BigInteger variable.

It is widely used in security and cryptography applications.
 * 
 * */

public class BigIntegerDemo {

	@Test
	public void whenBigIntegerCreatedFromConstructor_thenExpectedResult() {
	    BigInteger biFromString = new BigInteger("1234567890987654321");
	    BigInteger biFromByteArray = new BigInteger(
	       new byte[] { 64, 64, 64, 64, 64, 64 }); //Translates a byte array containing the two's-complement binaryrepresentation of a BigInteger into a BigInteger
	    biFromByteArray = new BigInteger(
	 	       new byte[] { 1,1}); //257 -> 2^8+1
	    
	    System.out.println(biFromByteArray);
	    
	    biFromByteArray = new BigInteger(
		 	       new byte[] { 1,1,1}); //65793 -> 2^16+257
		    
		System.out.println(biFromByteArray);
	    
	    biFromByteArray = new BigInteger(
		 	       new byte[] { 1,1,1,1}); //16843009 -> 2^24+65793
	    
	    System.out.println(biFromByteArray);
	    
	    
	    BigInteger biFromSignMagnitude = new BigInteger(-1,
	       new byte[] { 64, 64, 64, 64, 64, 64 });

	    assertEquals("1234567890987654321", biFromString.toString());
	    assertEquals("16843009", biFromByteArray.toString());
	    assertEquals("-70644700037184", biFromSignMagnitude.toString());
	    
	    
	    //arithmetic oeprations
	    BigInteger i = new BigInteger("4");
	    BigInteger j = new BigInteger("2");

	    BigInteger sum = i.add(j);
	    BigInteger difference = i.subtract(j);
	    BigInteger quotient = i.divide(j);
	    BigInteger product = i.multiply(j);

	    assertEquals(new BigInteger("6"), sum);
	    assertEquals(new BigInteger("2"), difference);
	    assertEquals(new BigInteger("2"), quotient);
	    assertEquals(new BigInteger("8"), product);
	    
	    //It also has methods related to prime generation and primality testing:
	    i = BigInteger.probablePrime(3, new Random()); //returns a random prime number from 2 to 2^3 (=8)
	    
	    System.out.println(i);
        
	    boolean isProbablePrime = i.isProbablePrime(1000); //Returns true if this BigInteger is probably prime, false if it's definitely composite. If certainty is ≤ 0, true is returned
	    assertEquals(true, isProbablePrime);
	}
}
