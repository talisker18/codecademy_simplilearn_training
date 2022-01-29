package AAM_input_output.file_handling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReplaceFileContent {

	public static void main(String[] args) {
		
		//first read the file
		BufferedReader reader = null;
		FileWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\chgix\\eclipse-workspace-main\\codecademy_simplilearn_training\\src\\main\\java\\AAM_input_output\\file_handling\\someText.txt"));
			String line;
			StringBuilder sb = new StringBuilder();
			
			while ((line = reader.readLine()) != null) {
	            sb.append(line + System.lineSeparator());
	        }
			
			System.out.println(sb.toString());
			
			writer = new FileWriter("C:\\Users\\chgix\\eclipse-workspace-main\\codecademy_simplilearn_training\\src\\main\\java\\AAM_input_output\\file_handling\\someText.txt");
			String content = sb.toString();
			content = content.replaceAll(content, "hello world");
			writer.write(content);
			System.out.println("new content: "+content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
