package AAN_strings.string_stringbuilder_stringbuffer;

public class PerformanceDemo {
	
	public static void main(String[] args) {
		
		//in some cases, performance is better with stringbuilder and buffer
		//for example when appending a new signs to a string within a loop
		
		
		String str = "str";
		
		for(int i = 0; i<10; i++) {
			str = str + "*"; //here, a new String object gets generated within each iteration. only the pointer 'str' changes his position...this because strings are IMMUTABLE
		}
		
		//better way to do: use stringbuilder or buffer when appending new signs within loops. only 1 object gets created and NOT multiple
		
		StringBuffer buffer = new StringBuffer("str");
		
		for(int i = 0; i<10; i++) {
			buffer.append("*"); //stringbuffer is NOT immutable, so there is only 1 object with 'str'
		}
	}

}
