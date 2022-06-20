package AAA_core.classes.inner_classes.local_inner_class;

/**
 * Local Inner Classes are the inner classes that are defined inside a block. Generally, this block is a method body. 
 * Sometimes this block can be a for loop or an if clause. Local Inner classes are not a member of any enclosing classes. 
 * They belong to the block they are defined within, due to which local inner classes cannot have any access modifiers associated 
 * with them. However, they can be marked as final or abstract. This class has access to the fields of the class enclosing it. 
 * Local inner class must be instantiated in the block they are defined in. 
 * 
 * 
 * 
 * What happens at compile time?

When a program containing a local inner class is compiled, the compiler generates two .class files, one for the outer class and the other for the inner class that has the reference to the outer class. The two files are named by the compiler as: 

    Outer.class
    Outer$1Inner.class
 * 
 * 
 * */

public class Outer {
	
	private void getValue(int divisor) {
		// Note that local variable(sum) must be final till JDK 7
        // hence this code will work only in JDK 8
        int sum = 20;
         
        // Local inner Class inside method
        class Inner //access modifiers not allowed for local inner classes
        {
            public int divisor;
            public int remainder;
             
            public Inner(int divisor)
            {
                this.divisor = divisor;
                remainder = sum%divisor;
            }
            private int getDivisor()
            {
                return divisor;
            }
            private int getRemainder()
            {
                return sum%divisor;
            }
            private int getQuotient()
            {
                System.out.println("Inside inner class");
                return sum / divisor;
            }
        }
         
        Inner inner = new Inner(divisor); //get the param from getValue() call
        System.out.println("Divisor = "+ inner.getDivisor());
        System.out.println("Remainder = " + inner.getRemainder());
        System.out.println("Quotient = " + inner.getQuotient());
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer();
        outer.getValue(4);
	}
}
