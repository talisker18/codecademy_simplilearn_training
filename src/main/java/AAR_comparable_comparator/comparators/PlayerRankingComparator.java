package AAR_comparable_comparator.comparators;

import java.util.Comparator;

import AAR_comparable_comparator.Player;

public class PlayerRankingComparator implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getRanking(), o2.getRanking());
	}

}
