package AAA_core.static_and_modifiers;

public class StaticDemo {
	
	public static int num=1;
	public int num2;
	
	public void setNum(int newNum) {
		num=newNum;
	}
	
	public static void setNum2(int num) {
		num2=num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticDemo statDemo1= new StaticDemo();
		statDemo1.setNum(2); //we can access static class variables via non static methods
		
		//but we cant access non static variable in a static method, see setNum2() method
		//Cannot make a static reference to the non-static field num2
		
	}

}
