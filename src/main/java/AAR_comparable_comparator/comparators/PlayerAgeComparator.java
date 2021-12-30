package AAR_comparable_comparator.comparators;

import java.util.Comparator;

import AAR_comparable_comparator.Player;

/*
 * other way to compare Player objects: implement for each attribute a separate comparator class
 * 
 * 
 * */

public class PlayerAgeComparator implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
