package AAD_java8.lambda_functionalInterfaces_methoReference.consumer_demo;

import java.util.function.Consumer;

/**
 * In Java 8, Consumer is a functional interface; it takes an argument and returns nothing.
 * 
 * 
 * @FunctionalInterface
	public interface Consumer<T> {
	  void accept(T t);
	}
 * 
 * */


/*
 * see also: src/main/java/AAD_java8/optional/OptionalDemo.java
 * 
 * */

public class ConsumerDemo {
	
	public static void main(String[] args) {

        Consumer<String> print = x -> System.out.println(x);
        print.accept("java");   // java

    }

}
