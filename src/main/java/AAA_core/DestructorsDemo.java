package AAA_core;

/**
 * 
 * Destructor helps to de-allocate memory --> but java takes care automatically of memory management
 * 
 * but you can clear manually
 * 
 * The Java finalize() method of Object class is a method that the Garbage Collector 
 * always calls just before the deletion/destroying the object which is eligible for 
 * Garbage Collection to perform clean-up activity.
 * 
 * */

public class DestructorsDemo {
	
	int i1;
	
	protected void finalize() throws Throwable{
        try {
 
            System.out.println("inside demo's finalize()");
        }
        catch (Throwable e) {
 
            throw e;
        }
        finally {
 
            System.out.println("Calling finalize method"
                               + " of the Object class");
 
            // Calling finalize() of Object class
            super.finalize(); //call finalize method of Object...but its deprecated
        }
    }

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		DestructorsDemo d1 = new DestructorsDemo();
		
		d1.finalize();

	}

}
