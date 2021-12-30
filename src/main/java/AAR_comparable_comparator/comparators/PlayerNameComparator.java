package AAR_comparable_comparator.comparators;

import java.util.Comparator;

import AAR_comparable_comparator.Player;

public class PlayerNameComparator implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
