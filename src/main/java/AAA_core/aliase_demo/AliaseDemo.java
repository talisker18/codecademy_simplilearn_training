package AAA_core.aliase_demo;

public class AliaseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Alias a = new Alias(); //ref var a is pointing to object, lets say, A
		a.setNum(1);
		
		Alias b = a; //instead of creating new object on which ref var b is pointing, we make alias
		//now, ref var b is pointing to the same object which ref a is pointing, namely object A
		
		//lets change num of ref var a
		int newNum =2;
		System.out.println("change num of ref var a to "+newNum);
		a.setNum(newNum); //this changes also num of ref var b
		
		System.out.println("num value of ref var a is "+a.getNum());
		System.out.println("num value of ref var b is "+b.getNum());
		
		//lets change num of ref var b
		newNum =5;
		System.out.println("change num of ref var b to "+newNum);
		b.setNum(newNum); //this changes also num of ref var b
		
		System.out.println("num value of ref var a is "+a.getNum());
		System.out.println("num value of ref var b is "+b.getNum());

	}

}
