package AAA_core.static_and_modifiers.private_modifier_demo;

public class Application {
	
	private A a = new A();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application app = new Application();
		B b = new B();
		b.doSomething(app.a, 10); //this is possible because the passed app.a as argument is only a copy
		//pointing to the same object as the private A a (instance var)
		//so we can change the argument a in method outside this class 
		//this will also change the instance var private a, because this and the argument app.a are aliases
		
		System.out.println(app.a.getC());
	}

}
