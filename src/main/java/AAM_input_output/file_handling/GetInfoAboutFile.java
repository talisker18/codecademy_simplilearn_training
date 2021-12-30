package AAM_input_output.file_handling;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class GetInfoAboutFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("D:\\OneDrive\\joel\\learn.docx");
		
		System.out.println("name of file: "+file.getName());
		
        Path filePath = file.toPath();

		BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);

		
		//print timestamps in UTC
		System.out.println("creationTime: " + attr.creationTime());
		System.out.println("lastAccessTime: " + attr.lastAccessTime());
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
		
		
		System.out.println("creationTime: " + attr.creationTime().toMillis());
		System.out.println("lastAccessTime: " + attr.lastAccessTime().toMillis());
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime().toMillis());

	}

}
