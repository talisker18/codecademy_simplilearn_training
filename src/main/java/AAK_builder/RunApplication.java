package AAK_builder;

public class RunApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomBuilder rand = new RandomBuilder();
		Integer [] arr = {1,7,5,9,677,44,656};
		
		Integer pick = (Integer) rand.pickRandomFromArray(arr);
		System.out.println(pick);

	}

}
