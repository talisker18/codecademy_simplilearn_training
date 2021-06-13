package AAE_packages.java_lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexOnString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//there are a lot more of regex for the matches() method
		String str = new String("Java String Methods");
		
	       System.out.println(str.matches("(.*)String(.*)")); //prints true
	       System.out.println(str.matches("(.*)Strings(.*)")); //prints false
	       
	       
	       //but its better to use the Pattern class for regex
	       
	       String url = "https://www.wog.ch/";
	       
	       //Here is a simple java regex example that uses a regular expression to check if a text contains the substring http://
	       String regex1 = ".*https://.*";
	       Pattern p1 = Pattern.compile(regex1);
	       
	       Matcher m1 = p1.matcher(url); //here put the inputstring
	       
	       /**
	        * The pattern variable contains the regular expression as a String. 
	        * The regular expression matches all texts which contains 
	        * one or more characters (.*) followed by the regex "http://" and
	        * followed by one or more characters (.*). 
	        * */
	       
	       if(m1.find()) {
	    	   System.out.println("input string contains regex .*https://.*");
	       }else {
	    	   System.out.println("input string DOES NOT contains regex .*https://.*");
	       }
	       
	       
	       //new regex. define new pattern and matcher!!!
	       String regex2 = ".*http://.*";
	       Pattern p2 = Pattern.compile(regex2);
	       Matcher m2 = p2.matcher(url);
	       
	       if(m2.find()) {
	    	   System.out.println("input string contains regex .*http://.*");
	       }else {
	    	   System.out.println("input string DOES NOT contains regex .*http://.*");
	       }
	       
	       
	       
	       /***another regex example with split****/
	       
	       String s1="java string split method sample";  
	       
	       String[] words=s1.split("\\s");//splits the string based on whitespace  
	       //using java foreach loop to print elements of string array  
	       
	       for(String w:words){
	    	   System.out.println(w);  
	       }  
	       

	}

}
