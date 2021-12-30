package ZAB_apps.file_app.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import ZAB_apps.file_app.CustomFile;
import ZAB_apps.file_app.comparators.FileNameComparator;
import ZAB_apps.file_app.helper.SortingHelper;

public class TestFileApp {
	
	private List<CustomFile> listWithAllFiles = new ArrayList<CustomFile>();
	
	@Test
	public void testSorting() throws IOException {
		
		//create an empty folder on desktop (please change your path)
		String dirPath = "C:\\Users\\chgix\\Desktop\\test_file_app";
		new File(dirPath).mkdirs();
		
		//create 100 txt files with UUIDs
		for(int i = 0; i<100;i++) {
			UUID uuid = UUID.randomUUID();
			File file = new File(dirPath+"\\"+uuid+".txt");
			file.createNewFile();
		}
		
		File folder = new File(dirPath);
		listFilesForFolder(folder);
		
		CustomFile [] randomPicks = new CustomFile[10];
		
		for(int i = 0; i<randomPicks.length;i++) {
			int rand = new Random().nextInt(this.listWithAllFiles.size());
			CustomFile randPick = this.listWithAllFiles.get(rand);
			randomPicks[i] = randPick;
		}
		
		System.out.println("print unordered list -------------------");
		
		for(CustomFile file: randomPicks) {
			System.out.println(file.getFileName());
		}
		
		System.out.println("print ordered list, ordered by name ----------------------");
		FileNameComparator c1 = new FileNameComparator();
		SortingHelper s1 = new SortingHelper(randomPicks);
		
		s1.sort(0, randomPicks.length-1, c1);
		s1.printArray();
		
		s1.reverseOrderOfArray();
		System.out.println("print ordered list, ordered by name descending ----------------------");
		s1.printArray();
		
	}
	
	public void listFilesForFolder(final File folder) throws IOException {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	CustomFile custom = new CustomFile(fileEntry);
	        	this.listWithAllFiles.add(custom);
	        }
	    }
	}

}
