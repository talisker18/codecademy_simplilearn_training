package AAM_input_output.scanner_apps.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CalculatorDemo calc = new CalculatorDemo();
		
		final Scanner scan = new Scanner(System.in);
		
		boolean abort = false;
		
		while(!abort) {
			
			final List<Integer> list = new ArrayList<Integer>();
			
			while(list.size() < 2) {
				System.out.println("input your "+(list.size()+1)+". number or abort program by input of a letter");
				
				try {
					int num = scan.nextInt();
					list.add(num);
					
				}catch(Exception e) {
					abort=true;
					break;
				}
			}
			
			
			if(!abort) {
				System.out.println("calculations will be done");
				
				calc.addition(list.get(0), list.get(1));
				calc.division(list.get(0), list.get(1));
				calc.substraction(list.get(0), list.get(1));
				calc.multiplication(list.get(0), list.get(1));
			}
			
		}
		
		System.out.println("program was aborted");
		
		scan.close();

	}

}
