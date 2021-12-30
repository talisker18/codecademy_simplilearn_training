package AAR_comparable_comparator;

/*
 * on the class we want to compare, we can implement Comparable interface
 * 
 * disadvantage: we can only implement 1 compareTo method, thus we can compare only 1 kind of attribute, in this case 'ranking'
 * 
 * */


public class Player implements Comparable<Player> {
	
	private int ranking;
    private String name;
    private int age;
    
	public Player(int ranking, String name, int age) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.age = age;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "Player [ranking=" + ranking + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Player o) {
		return Integer.compare(this.getRanking(), o.getRanking());
	}
}
