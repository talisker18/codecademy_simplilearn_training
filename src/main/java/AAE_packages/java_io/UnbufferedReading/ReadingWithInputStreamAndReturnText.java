package AAE_packages.java_io.UnbufferedReading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadingWithInputStreamAndReturnText {

	public static void main(String[] args) throws IOException {
		testStream2();

	}
	
	public static void testStream2() throws IOException {
        InputStream in = new FileInputStream("src\\main\\java\\AAE_packages\\java_io\\some_data.txt");
        int chunk;
        List <Byte> byteList = new ArrayList<Byte>();
        
        while ((chunk = in.read()) != -1) { //read() -> reads only 1 byte in each iteration. each iteration makes request to the file on
        	//the OS, so its very slow
            System.out.println(chunk); //printing the byte
            byte b = (byte) chunk;
            byteList.add(b);
        }
        
        //close inputstream
        in.close();
        
        //convert arraylist to byte[] so we can convert the bytes to text
        byte[] byteArr = new byte[byteList.size()];
        
        for(int i=0; i<byteList.size();i++) {
        	byteArr[i] = byteList.get(i).byteValue(); //fill the byte [] with the bytes
        }
        
        String s = new String(byteArr, StandardCharsets.UTF_8);
        System.out.println(s);
    }

}
