package AAH_testing.ParameterizedTesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Numbers {
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
    
    @Test
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    public void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        Assert.assertEquals(true, isOdd(number));
    }
}
