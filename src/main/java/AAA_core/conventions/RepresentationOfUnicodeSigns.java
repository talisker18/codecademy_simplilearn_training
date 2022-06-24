package AAA_core.conventions;

public class RepresentationOfUnicodeSigns {
	public static void main(String[] args) {
		//for this we need to use escaped sequences: \ u . . . .   --> the dots are hexadecimal numbers
		
		//examples
		
		System.out.println("\u0021"); // !
		System.out.println("\u0024"); // $
		System.out.println("\u0043"); // C
		
		String str = "\u0043\u0024";
		
		System.out.println(str); // C$
	}
}
