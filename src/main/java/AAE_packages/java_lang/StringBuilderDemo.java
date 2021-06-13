package AAE_packages.java_lang;

public class StringBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		sb.append("helloworld"); //appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		sb.append("helloworld");//appends 10 characters
		
		System.out.println(sb); //when we print the reference var of StringBuilder object, we print the character sequence of this
		//string builder object. we can do .toString() if we want to print it as a normal string
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("test hello");
		sb2.reverse(); //dreht den string um
		
		
		System.out.println(sb2);

		
		//and a lot of more methods for StringBuilder, like insert(int offset, String s)
	}

}
