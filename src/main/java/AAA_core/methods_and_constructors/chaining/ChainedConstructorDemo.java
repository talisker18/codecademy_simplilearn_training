package AAA_core.methods_and_constructors.chaining;

public class ChainedConstructorDemo {
	
	public String text;
	public String text2;
	
	public ChainedConstructorDemo() {
		this.text2 = "some text2";
	}
	
	public ChainedConstructorDemo(String text) {
		//invoke constructor without param first
		this();
		this.text = text;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChainedConstructorDemo d1 = new ChainedConstructorDemo("hello");
		
		System.out.println(d1.text2);

	}

}
