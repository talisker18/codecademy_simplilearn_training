package AAM_input_output.reading_with_performance_tests.BufferedReading;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadingWithBufferedInputStreamReturnText {
	
	public static int numOfIterations;
	
public static long testStream3() throws IOException {
		
		long timestampBegin = System.currentTimeMillis();
	
    	StringBuilder sb = new StringBuilder();
		
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data2.txt")); //default internal buffer = 8*1024 bytes
        
        //for BufferedInputStream, we can create another, internal buffer, see next line (default is 1024*8 bytes)
        //BufferedInputStream in = new BufferedInputStream(new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data2.txt"),16*1024);
        //--> the performance is slight better than with default buffer of 8*1024 bytes...on bigger texts, there should be a bigger difference
        //-->was tested on file of 56’532’300 bytes: performance is more or less same, maybe the bigger buffer is slight faster      

        int bufferSize = 512; //external buffer...makes sense to do this, even if we already got an buffer on BufferedInputStream
        //performance tests showed that it is not necessary to put too high value in here
        
        /*
         * with size = 1 -> same performance as we would use the numOfReadBytes = in.read() method which reads only 1 byte each time (see below) -> around 3000ms
         * 8 -> 650ms
         * 16 -> 470ms
         * 32 -> 360ms
         * 64 -> about 320ms
         * 128 -> 270ms
         * 256 -> 270ms
         * 512 -> around 240 - 270ms
         * ...so 512 is good choice
         * ...it depends on file size and from where we read (network? or disk?)
         * --> depending on situation, another bufferSize could be better
         * */
  
        byte[] buffer = new byte[bufferSize]; //with InputStream, we can only read byte[], not char[] like with e.g. InputStreamReader
        
        int numOfReadBytes;
        numOfIterations=0;
        while ((numOfReadBytes = in.read(buffer, 0, buffer.length)) >0) { //fill the byte[] buffer with bytes
        	sb.append(new String(buffer,0,numOfReadBytes, StandardCharsets.UTF_8)); //convert bytes to String and append it to sb.
        	//we have to specify offset and length of array, so we dont append the empty array elements in the last iteration
        	//in each iteration we have an array with 512 places. now in last iteration, we only have left
        	//302 bytes to read...the last 210 places get filled with empty elements, and we dont want to append these empty elements
            
            numOfIterations++;
        }
        
        //we also could read only 1 byte each iteration, so without an external buffer (array bufferSize)
        //but this is much slower, because we got too many iterations...so it makes sense to do also an external buffer which can read
        //e.g. 512 bytes instead of 1 byte
        
        /*while ((numOfReadBytes = in.read()) >0) { //read each byte separately and convert it to ASCII char and then append it
        	String c = Character.toString(numOfReadBytes);
        	//System.out.println(c);
        	sb.append(c);
        	//sb.append(new String(buffer,0,numOfReadBytes, StandardCharsets.UTF_8));
            
            numOfIterations++;
        }*/

        //close inputstream
        in.close();
        
        long timestampEnd = System.currentTimeMillis();
        
        //System.out.println(sb.toString());
        
        System.out.println("size of text: "+sb.length());
        //System.out.println(sb.toString());
        
        return timestampEnd-timestampBegin;
    }

	public static void main(String[] args) throws IOException {
		testStream3();
	}

}
