package AAD_java8.lambda_functionalInterfaces_methoReference.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class A_constructorReference {
	
	
	public static void main(String[] args) {
		List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
		
		//create an array of Bicycle objects using Stream and constructor reference
		Bicycle [] bicycleArray = bikeBrands.stream()
				.map(Bicycle::new) //using map to create a Stream of Stream<Bicycle> -> it automatically uses all the brands as arguments for the constructor
				
				//lambda would look like this:
				//.map(brand -> new Bicycle(brand)) //taking Function Interface: Function<? super String, ? extends Bicycle> mapper, where ? super String is the brand in this case
				.toArray(Bicycle[]::new);
		
		Stream.of(bicycleArray).forEach(System.out::println);
	}

}

class Bicycle{
	
	private String brand;
	private int frameSize = 0;
	
	public Bicycle(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Bicycle [brand=" + brand + ", frameSize=" + frameSize + "]";
	}
	
	
}