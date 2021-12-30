package AAR_comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player a = new Player(5,"joel",34);
		Player b = new Player(2,"hans",40);
		Player c = new Player(1,"toby",33);
		Player d = new Player(4,"tim",33);
		
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(a);
		playerList.add(b);
		playerList.add(c);
		playerList.add(d);
		
		//due to the comparable, we can now sort the list
		System.out.println("unsorted list: "+playerList);
		
		Collections.sort(playerList);
		
		System.out.println("sorted list: "+playerList);

	}

}
