package AAA_core;

public class DemoChainedConstructor {
	
	public String text;
	public String text2;
	
	public DemoChainedConstructor() {
		this.text2 = "some text2";
	}
	
	public DemoChainedConstructor(String text) {
		//invoke constructor without param first
		this();
		this.text = text;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoChainedConstructor d1 = new DemoChainedConstructor("hello");
		
		System.out.println(d1.text2);

	}

}
