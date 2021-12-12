package AAK_builder.random_builder;

import java.util.Random;

public class RandomBuilder {
	
	public Object pickRandomFromArray(Object [] arr) {
		int rand = new Random().nextInt(arr.length);
		
		return arr[rand];
	}

}
