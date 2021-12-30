package ZAB_apps.scanner_apps;

import java.util.Scanner;

public class TypeCastingDemo {

	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		
		boolean abort = false;
		
		while(!abort) {
			System.out.println("input some number, it will be converted to double value. or input any other symbol than a number to abort program");
			
			try {
				final String input = scan.nextLine();
				final int inputAsInt = Integer.parseInt(input);
				
				System.out.println("converted input is: "+inputAsInt);
				
			}catch (Exception e) {
				abort = true;
			}
		}
		
		System.out.println("program was aborted");
		
		scan.close();
	}
}
