package ZAB_apps.file_app.comparators;

import java.util.Comparator;

import ZAB_apps.file_app.CustomFile;

public class FileCreationDateComparator implements Comparator<CustomFile>{


	@Override
	public int compare(CustomFile o1, CustomFile o2) {
		
		return Long.compare(
				o1.getFileDate().toMillis(), 
				o2.getFileDate().toMillis()
		);
	}
	
	

}
