package AAA_core.generics_and_wildcards.lower_upper_bound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * see also: /KitchenStoryAuthServer/src/main/java/com/henz/auth/CustomUserDetailsService.java
 * 
 * --> super class is an interface instead of a Class. 
 * 
 * */

/**
 * 
 * In generics ? (called as unbounded wildcard) is used to accept just any type of object.
However, we can restrict this behaviour by applying a Lower-Bound or Upper-Bound to wildcard ?.
Upper-bound is when you specify (? extends Field) means argument can be any Field or subclass of Field.
Lower-bound is when you specify (? super Field) means argument can be any Field or superclass of Field.
Try following code: Uncomment the code and check if any error comes.
 * 
 * */


public class BounderGenericsDemo2 {

	public static void validateTillStringType(Collection<? super String> collection){
        //Wild card with Lower bound
        // Accept collection of objects of type string or SUPER-CLASS of String (like String, Object)
    }
	
	public static void validateStringTypes(Collection<? extends String> collection){
        //Wild card with Upper bound
        // Accept collection of objects of type string or SUB-CLASS of String (like String, SUB CLASSES of String)
    }

    
    
    /**
	 * We can also apply bounds to type variables as one parameter will depend on other parameter.
		A type variable ( usually T) is option for wildcard ?. Both of following two method signatures are equivalent to each other.
	 * 
	 * */
	
	//using wildcard '?'
	public static void validateTillStringTypeUsingWildCard(Collection<?> collection){ }
	
	//using type parameter
	public static <T> void validateTillStringTypeUsingTypeParameter(Collection<T> collection){ }
	
	/**
	 * How to put bounds for type variable?

	Suppose we have a method to copy elements at a destination from a given source. In this case we need to make sure that the source elements are compatible with destination elements. A.K.A. source element type extends destination element type, method would look like:
	 * 
	 * */
	//using upper bound
	public static <T> void copy(List<T> dest, List<? extends T> src) { }
	
	/**
	 * n above method we use a type variable T. With help of this declared T, we are able to apply an upper bound to wildcard of src.
		If we want to avoid the wildcard, we can declare one more type variable for second argument and apply bound in declaration place. Above method can be declared in new style as:
	 * 
	 * */
	//wilcard '?' replaced with type param 'V'
	public static <T,V extends T> void copy2(List<T> dest, List<V> src) { }
    
    public static void main(String[] args) {
    	BounderGenericsDemo2.validateTillStringType(new ArrayList<Object>());//OK

//      GenericsDemo.validateTillStringType(new ArrayList<Integer>());//Error

//      GenericsDemo.validateStringTypes(new ArrayList<Object>());//Error

    	BounderGenericsDemo2.validateStringTypes(new ArrayList<String>());//OK
    	
    	
    	
	}
}
