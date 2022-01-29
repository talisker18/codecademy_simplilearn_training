package AAM_input_output.file_handling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * compile the files and read via CLASSPATH
 * see: /codecademy_simplilearn_training/src/main/java/AAA_core/classpath_demo/ClassPathDemo.java
 * 
 * or see below
 * 
 * */

public class HowToReadFileFromSrcFolder {
	
	public static void main(String[] args) throws IOException {
		
		//read file when it is saved in root dir /codecademy_simplilearn_training/someText.txt
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("someText.txt")));
		StringBuilder sb = new StringBuilder();
		
		String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + System.lineSeparator());
        }
        
        System.out.println(sb.toString());
        
        br.close();
        
        sb = new StringBuilder();
        
        //read file from /codecademy_simplilearn_training/src/main/java/AAM_input_output/file_handling/someText.txt
        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/AAM_input_output/file_handling/someText2.txt")));
        
        while ((line = br.readLine()) != null) {
            sb.append(line + System.lineSeparator());
        }
        
        System.out.println(sb.toString());
        
        br.close();
	}
}
