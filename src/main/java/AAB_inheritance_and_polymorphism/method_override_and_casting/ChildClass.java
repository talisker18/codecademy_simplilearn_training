package AAB_inheritance_and_polymorphism.method_override_and_casting;

public class ChildClass extends ParentClass {
	
	@Override
	public void doSomeStuff() {
		//call the super method
		super.doSomeStuff();
		System.out.println("from child");
	}
	
	public void doSomeStuffChildOnly() {
		System.out.println("child only");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildClass c = new ChildClass();
		System.out.println("calling method from parent AND child");
		c.doSomeStuff();
		System.out.println("----------------");
		//c.super.doSomeStuff(); --> but this does not work. super can be called only inside the child class and not on reference
		
		
		System.out.println("create ChildClass obj but with reference var of type ParentClass");
		//here we still call the doSomeStuff() method from ChildClass
		ParentClass p = new ChildClass();
		p.doSomeStuff();
		System.out.println("--> but we cant access methods defined only within ChildClass because the reference var only knows methods of ParentClass");
		System.out.println("--> in case of doSomeStuff(), there is a method in parent AND child. Since the obj saved in heap is of ChildClass(), the compiler checks if there is a doSomeStuff() method in ChildClass(). If yes (which is true in that case), JVM executes that method");
		System.out.println("--> next example shows calling a ParentClass method because this time, the method is not overriden by ChildClass");
		p.doSomeStuffParentOnly();
		
		
		//but we cant call the doSomeStuffChildOnly() method because this is only in ChildClass
		//p.doSomeStuffChildOnly(); --> The method doSomeStuffChildOnly() is undefined for the type ParentClass
		
		System.out.println("----------------");
		
		//upcast p to ParentClass object
		System.out.println("after upcasting p: ");
		p = new ParentClass();
		p.doSomeStuff(); //here we are just calling the method of ParentClass
		
		System.out.println("----------------");
		
		System.out.println("after downcasting back to ChildClass");
		
		p = new ChildClass();
		p.doSomeStuff();
		
		System.out.println("---------------");
		
		System.out.println("do some casting");
		
		//example explicit cast
		
		try {
			ChildClass c2 = (ChildClass) new ParentClass(); //this results in a ClassCastException. we can cast a child with (ChildClass) to a parent
		} catch (ClassCastException e) {
			System.out.println("ClassCastException was thrown");
		}
		
		//but we can always cast a parent to a child. in line 27, we did this implicitly. here, we do it explicitly
		ParentClass p3 = (ChildClass) new ChildClass();
		p3.doSomeStuff(); //again, compiler finds a doSomeStuff() method of ChildClass...so use that
		p3.doSomeStuffParentOnly(); //again
		//but still we cant access doSomeStuffChildOnly because reference var of type ParentClass does not know that method
		//but the reference var p3 is pointing to a ChildClass obj. And this object has
		

	}

}
