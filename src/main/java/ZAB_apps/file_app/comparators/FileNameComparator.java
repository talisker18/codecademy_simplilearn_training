package ZAB_apps.file_app.comparators;

import java.util.Comparator;

import ZAB_apps.file_app.CustomFile;

public class FileNameComparator implements Comparator<CustomFile>{

	@Override
	public int compare(CustomFile o1, CustomFile o2) {
		return o1.getFileName().compareToIgnoreCase(o2.getFileName());
	}

}
