package AAM_input_output.reading_with_performance_tests.UnbufferedReading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadingWithInputStreamAndReturnByte {
	
	public static int numOfIterations; //needs to be public because class PerformanceTest is not in package UnbufferedReading

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//testStream2();
		testStream3();

	}
	
	//reads only 1byte (meaning: 1 character) per iteration
	public static void testStream2() throws IOException {
        InputStream in = new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data.txt");
        int chunk;
        while ((chunk = in.read()) != -1) { //read() -> reads only 1 byte in each iteration. each iteration makes request to the file on
        	//the OS, so its very slow
            //System.out.println(chunk); //printing the byte
        }
        
        //close inputstream
        in.close();
    }
	
	public static long testStream3() throws IOException {
		long timestampBegin = System.currentTimeMillis();
		
        InputStream in = new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data2.txt");
        int chunk;
        numOfIterations=0;
        while ((chunk = in.read()) != -1) { //read() -> reads only 1 byte in each iteration. each iteration makes request to the file on
        	//the OS, so its very slow
            //System.out.println(chunk); //printing the byte
            numOfIterations++;
        }
        
        //close inputstream
        in.close();
        
        long timestampEnd = System.currentTimeMillis();

        return timestampEnd-timestampBegin;
    }

}
