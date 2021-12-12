package AAM_input_output.reading_with_performance_tests.BufferedReading;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//is this really buffered reading?

public class ReadingWithBufferedInputStreamReturnByte {
	
	public static int numOfIterations;

	public static void main(String[] args) throws IOException {
		//testStream2();
		testStream3();

	}
	
	//this should be faster than InputStream...do performance test with big text file
	//still, 16 iterations are needed because file has 16 bytes...like with the normal InputStream 
	//(why? bufferedInputStream should have better performance...)
	
	/*
	 * --> answer:
	 * BufferedInputStream is a kind of inputStream that reads data from a stream and uses a 
	 * buffer to optimize speed access to data. data is basicaly read ahead of time and this 
	 * reduces disk or network access.
	 * 
	 * --> answer2:
	 * 
	 * BufferedInputStream is not abstract, so you can actually create an instance. 
	 * Its read() method still returns one byte at a time but it reads ahead internally to fill a buffer. That way, most calls to read() are non-blocking. 
	 * The byte is already in the buffer and is immediately returned to the caller.
	 * 
	 * */
	public static void testStream2() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data.txt"));

        int chunk;
        int numOfIterations=0;
        while ((chunk = in.read()) != -1) {
            //System.out.println(chunk);
            numOfIterations++;
        }

        //close inputstream
        in.close();
        System.out.println("number of iterations: "+numOfIterations);
    }
	
	
	//use this method to test bigger text file...then do same with inputStream and make comparison!!
	public static long testStream3() throws IOException {
		
		long timestampBegin = System.currentTimeMillis();
		
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data2.txt"));

        int chunk;
        numOfIterations=0;
        while ((chunk = in.read()) != -1) {
            //System.out.println(chunk);
            numOfIterations++;
        }

        //close inputstream
        in.close();
        
        long timestampEnd = System.currentTimeMillis();

        return timestampEnd-timestampBegin;
    }


}
