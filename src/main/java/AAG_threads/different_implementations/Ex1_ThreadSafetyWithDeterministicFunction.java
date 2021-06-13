package AAG_threads.different_implementations;

import java.math.BigInteger;

public class Ex1_ThreadSafetyWithDeterministicFunction {

	public static void main(String[] args) {
		//method factorial is deterministic
		BigInteger num=MathUtils.factorial(30); //BigInteger class is used for mathematical operation which 
		//involves very big integer calculations that are outside the limit of all available primitive data types.
		System.out.println(num);

	}

}

class MathUtils {
    
    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
