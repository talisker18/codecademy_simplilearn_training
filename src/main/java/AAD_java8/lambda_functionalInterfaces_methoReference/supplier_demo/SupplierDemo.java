package AAD_java8.lambda_functionalInterfaces_methoReference.supplier_demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/**
 * 
 * In Java 8, Supplier is a functional interface; it takes no arguments and returns a result.
 * 
 * @FunctionalInterface
	public interface Supplier<T> {
	    T get();
	}
 * 
 * */


//see also: src/main/java/AAD_java8/optional/OptionalDemo.java

public class SupplierDemo {
	
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);

    }
}
