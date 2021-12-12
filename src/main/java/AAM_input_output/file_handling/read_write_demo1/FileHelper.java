package AAM_input_output.file_handling.read_write_demo1;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class FileHelper {
	
	//for reading
	private static final byte [] buffer = new byte [512];
	private static BufferedInputStream in;
	private static int bytesRead;
	
	//for writing
	private static BufferedWriter out;
	
	private FileHelper() {
		
	}
	
	public static void readFileAndPrintContentToConsole(String pathOfFile) {	
		try {
			in = new BufferedInputStream(new FileInputStream(pathOfFile));
			System.out.println("content of the file will be printed after and before ----------: ");
			System.out.println("------------");
			
			while((bytesRead = in.read(buffer,0,buffer.length)) > 0) {
				System.out.println(new String(buffer,0,bytesRead,StandardCharsets.UTF_8));
			}
			
			System.out.println("------------");
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, the file you want to read is not found. Please check if the path of the file is correct.");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void createNewFileAndWrite(String path, String text) {
		try {
			out = new BufferedWriter(new FileWriter(path));
			out.write(text);
			System.out.println();
			System.out.println("successfully created new file with text: "+text);
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void appendTextToFile(String path, String text) {
		try {
			out = new BufferedWriter(new FileWriter(path, true));
			out.append(text);
			System.out.println();
			System.out.println("successfully appended text: "+text);
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
