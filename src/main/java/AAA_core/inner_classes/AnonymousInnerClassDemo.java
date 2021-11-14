package AAA_core.inner_classes;

public class AnonymousInnerClassDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//make an anonymous Inner Class
		AnonymousInnerClass i = new AnonymousInnerClass(){
			
			public void display() {
				System.out.println("hello");
			}
		}; //watch out: it needs an semicolon at the end
		
		i.display();
		
	}

}

//class is not an inner class here because its outside of AnonymousInnerClassDemo
abstract class AnonymousInnerClass {
	   public abstract void display();
}