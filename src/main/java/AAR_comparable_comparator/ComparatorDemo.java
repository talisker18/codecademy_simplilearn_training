package AAR_comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import AAR_comparable_comparator.comparators.PlayerAgeComparator;
import AAR_comparable_comparator.comparators.PlayerNameComparator;
import AAR_comparable_comparator.comparators.PlayerRankingComparator;

public class ComparatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerRankingComparator c1 = new PlayerRankingComparator();
		
		Player a = new Player(5,"joel",34);
		Player b = new Player(2,"hans",40);
		Player c = new Player(1,"toby",33);
		Player d = new Player(4,"tim",33);
		
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(a);
		playerList.add(b);
		playerList.add(c);
		playerList.add(d);
		
		System.out.println("sort by ranking");
		
		Collections.sort(playerList,c1);
		System.out.println(playerList);
		
		PlayerAgeComparator c2 = new PlayerAgeComparator();
		
		System.out.println("sort by age");
		Collections.sort(playerList,c2);
		System.out.println(playerList);
		
		PlayerNameComparator c3 = new PlayerNameComparator();
		
		System.out.println("sort by name");
		Collections.sort(playerList,c3);
		System.out.println(playerList);
		
		

	}

}
