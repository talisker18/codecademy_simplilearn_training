package AAQ_algorithms.other;

import java.util.Scanner;

//frequently asked in java interviews
public class ArmstrongDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//armstrong number e.g. 153 -> 1^3 + 5^3 + 3^3 --> where the ^n is the number of digits
		
		Scanner scan = new Scanner(System.in);
		
		boolean abort = false;
		
		while(!abort) {
			int number = scan.nextInt();
			
			if(numberIsArmstrong(number)) {
				System.out.println("your number, "+number+" is armstrong");
			}else {
				System.out.println("your number, "+number+" is not armstrong");
			}
		}

	}
	
	
	static boolean numberIsArmstrong(int number) {
		String numberAsString = Integer.toString(number);
		
		int lengthOfStr = numberAsString.length();
		System.out.println("lenght of number: "+lengthOfStr);
		int sum = 0;
		
		for(int i = 0; i<numberAsString.length(); i++) {
			int current = Character.getNumericValue(numberAsString.charAt(i));
			sum = (int) (sum + (Math.pow(current, lengthOfStr)));
			System.out.println("current digit: "+current);
			System.out.println("sum: "+sum);
		}
		
		if(sum == number) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
