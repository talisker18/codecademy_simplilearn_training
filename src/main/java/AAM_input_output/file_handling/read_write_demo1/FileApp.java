package AAM_input_output.file_handling.read_write_demo1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FileApp {

	public static void main(String[] args) {
		System.out.println("Hello. What do you want to do?");
		
		Scanner scan = new Scanner(System.in);
		
		boolean exitProgram = false;
		
		while(!exitProgram) {
			System.out.println("1 - Read a file      2 - write to a file (with overriding)    3 - exit program");
			
			try {
				final int choice = scan.nextInt();
				String path;
				String text;
				
				System.out.println("");
				
				switch (choice) {
				case 1:
					System.out.println("please insert the absolute path of the file you want to read");
					path = scan.next();
					FileHelper.readFileAndPrintContentToConsole(path);
					break;
				case 2:
					System.out.println("What do you want to do?    1 - create new file    2 - open existing file and append text    3 - exit program");
					final int choiceSecond = scan.nextInt();
					switch (choiceSecond) {
					case 1:
						System.out.println("type the path of the file with name (e.g. C:/Users/manfr/test.txt)");
						path = scan.next();
						System.out.println("type the text you want to write to the new file");
						text = scan.next();
						FileHelper.createNewFileAndWrite(path, text);
						break;
					case 2:
						System.out.println("type the path of the file with name (e.g. C:/Users/manfr/test.txt)");
						path = scan.next();
						System.out.println("type the text you want to append to the existing file");
						text = scan.next();
						FileHelper.appendTextToFile(path, text);
						break;
					case 3:
						exitProgram = true;
						break;
					}
					
					break;
				case 3:
					exitProgram = true;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("your input was not valid.");
				System.out.println();

				//after the exception is caught, the wrong input stays in the buffer of scanner object
				//we have to consume the invalid input. If not, the exception will be thrown with infinite loop
				String consumer = scan.nextLine();
				//create fresh Scanner object
				scan = new Scanner(System.in);
			}
			
		}
		
		System.out.println("Thanks for using this program. See you!");

	}

}
