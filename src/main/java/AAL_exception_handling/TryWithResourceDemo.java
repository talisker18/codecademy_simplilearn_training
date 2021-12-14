package AAL_exception_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResourceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Replacing try–catch-finally With try-with-resources
		
		
		/*
		 * Support for try-with-resources — introduced in Java 7 — allows us to declare resources to be used in a try block with the assurance that the resources will be closed after the execution of that block.
			The resources declared need to implement the AutoCloseable interface.
		 * 
		 * 
		 * */
		
		//so here we do not have to close the scanner object manually in a final block
		try (Scanner scanner = new Scanner(new File("test.txt"))) {
		    while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		} catch (FileNotFoundException fnfe) {
		    fnfe.printStackTrace();
		}

	}

}
