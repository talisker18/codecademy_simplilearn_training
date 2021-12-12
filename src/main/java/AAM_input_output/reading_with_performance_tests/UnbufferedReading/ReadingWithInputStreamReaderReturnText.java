package AAM_input_output.reading_with_performance_tests.UnbufferedReading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class ReadingWithInputStreamReaderReturnText {
	
	public static int numOfIterations;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		testStream2();
		testStream3();

	}
	
	public static void testStream2() throws IOException {
        StringBuilder sb = new StringBuilder();
        //BufferedInputStream in = new BufferedInputStream(new FileIn-putStream("src/test/resources/test.txt"));
        InputStream in = new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data.txt");
        InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);

        int bufferSize = 512;
        char[] buffer = new char[bufferSize]; //instead of byte, use char to get directly text...this is possible for StreamReader, but not for Stream...for Stream we have to use byte[]

        int numRead;
        numOfIterations=0;
        while ((numRead = isr.read(buffer,0,buffer.length)) > 0) { // read(char[] cbuf, int offset, int length) -> Reads characters into a portion of an array.
        	//isr.read returns the int value which corresponds to the number of bytes which have been read. in the mean time, the char[] buffer gets filled with the read data
        	//for the text Hsdfdsfdfsvdsdsf, only one iteration is needed because we have a buffer size of 512 bytes and the file is only 16 bytes
        	//therefore, numRead will be printed once and has the value of 16, because filesize is 16 bytes
        	
            System.out.println(numRead); //prints the number of bytes which have been read in current iteration
            sb.append(buffer, 0, numRead);
            //System.out.println(sb.toString());
            System.out.println("iteration DONE ------------------------");
            numOfIterations++;
        }

        //close inputstream
        in.close();
        isr.close();

        //System.out.println(sb.toString());
    }
	
	public static long testStream3() throws IOException {
		long timestampBegin = System.currentTimeMillis();
		
        StringBuilder sb = new StringBuilder();
        //BufferedInputStream in = new BufferedInputStream(new FileIn-putStream("src/test/resources/test.txt"));
        InputStream in = new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data2.txt");
        InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);

        int bufferSize = 512;
        char[] buffer = new char[bufferSize]; //instead of byte, use char to get directly text

        int numRead;
        numOfIterations=0;
        while ((numRead = isr.read(buffer,0,buffer.length)) > 0) { // read(char[] cbuf, int offset, int length) -> Reads characters into a portion of an array.
        	//isr.read returns the int value which corresponds to the number of bytes which have been read. in the mean time, the char[] buffer gets filled with the read data
        	//for the text in some_data2.txt, 335 iterations are needed to read whole file. each read iteration can read 512 bytes, last iterations reads 302 bytes
        	//so the file size is 334*512 + 302 bytes
        	
            //System.out.println(numRead); //prints the number of bytes which have been read in current iteration
            sb.append(buffer, 0, numRead);
            //System.out.println(sb.toString());
            //System.out.println("iteration DONE ------------------------");
            numOfIterations++;
        }

        //close inputstream
        in.close();
        isr.close();
        
        long timestampEnd = System.currentTimeMillis();
        
        System.out.println("size of text: "+sb.length());
        
        return timestampEnd-timestampBegin;
    }


}
