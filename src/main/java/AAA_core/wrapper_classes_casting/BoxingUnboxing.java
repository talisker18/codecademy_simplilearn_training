package AAA_core.wrapper_classes_casting;

public class BoxingUnboxing {

	public static void main(String[] args) {
		
		/*
		 * before Java 5, automatic boxing and unboxing was not possible
		 * 
		 * to calculate with values in wrapper classes, we had to use for example intValue() to get the value of primitve datatype
		 * 
		 * 
		 * */
		
		//boxing int value into wrapper object
		Integer i = new Integer(2);
		Integer j = Integer.valueOf(4);
		
		//unbox the values
		System.out.println(i.intValue());
		System.out.println(j.intValue());
		
		//so since Java 5, boxing and unboxing is done automatically
		
		
		//automatic boxing
		int a = 10;
		Integer b = a;
		System.out.println(b);
		
		//automatic unboxing
		Integer c = Integer.valueOf(15);
		int d = c;
		System.out.println(d);
		
		System.out.println(a+c); //we can also calculate directly thanks to automatic boxing / unboxing
	}
}
