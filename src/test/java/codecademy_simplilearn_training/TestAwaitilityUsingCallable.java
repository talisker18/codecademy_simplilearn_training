package codecademy_simplilearn_training;

import static org.awaitility.Awaitility.*;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestAwaitilityUsingCallable {
	
	private int i = 5;
	
	@Test
	public void testCreateCallableWithLambda() {
		
		await()
        .atMost(10, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS)
        .until( () ->
                this.testCondition());
	}
	
	@Test
	public void testCreateCallableWithAnonymousClass() {
		
		await()
        .atMost(10, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS)
        .until(new Callable<Boolean>() {
			
			@Override
			public Boolean call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("polled (every 500ms)");
				return testCondition();
			}
		});
	}
	
	
	public boolean testCondition() {
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(10-0) +0; //random number from 0 (=min) till 10 (= max)
		System.out.println("random number = "+randomNumber);
		return randomNumber == this.i;
	}

}
