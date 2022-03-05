package ZAA_misc;

import java.util.Random;

public class RandomNumberGenerator {
	
	public static void main(String[] args) {
		Random rand = new Random();
		int randomNumber = rand.nextInt(10-0) +0; //random number from 0 (=min) till 10 (= max)
		System.out.println(randomNumber);
	}

}
