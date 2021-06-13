package AAE_packages.java_io.BufferedReading;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadingWithBufferedReaderReturnText {
	
	public static int numOfIterations;

	public static void main(String[] args) throws IOException {
		testStream();

	}
	
	public static long testStream() throws IOException {
		long timestampBegin = System.currentTimeMillis();
		
        StringBuilder sb = new StringBuilder();
        //InputStream in = new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data2.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        
        
        // ----> ODER direkt
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data2.txt")
                )
        );
        
        
        

        String line;
        numOfIterations=0;
        while ((line = br.readLine()) != null) {
            sb.append(line + System.lineSeparator());
            //System.out.println(line);
            numOfIterations++;
        }

        //System.out.println("num of iterations: "+numOfIterations); //will print 760 iterations
        
        br.close();
        
        
        
        long timestampEnd = System.currentTimeMillis();
        
        System.out.println("size of text: "+sb.length());
        
        return timestampEnd-timestampBegin;
    }


}
