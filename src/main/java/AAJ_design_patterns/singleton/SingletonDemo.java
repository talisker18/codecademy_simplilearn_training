package AAJ_design_patterns.singleton;

public class SingletonDemo {
	
	private static SingletonDemo SINGLETON_INSTANCE;
	public String info = "";
	
	private SingletonDemo() {
		//prevent instantiation
		this.info = "im one and only instance";
	}
	
	public static SingletonDemo getInstance() {
		if(SINGLETON_INSTANCE == null) {
			SINGLETON_INSTANCE = new SingletonDemo();
		}
		
		return SINGLETON_INSTANCE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingletonDemo s1 = SingletonDemo.getInstance();
		System.out.println(s1.info);
		
		SingletonDemo s2 = SingletonDemo.getInstance();
		System.out.println(s2.info);
		
		//also a way to check if 2 objects are same
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

	}

}
