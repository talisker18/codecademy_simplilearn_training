package AAN_strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTraining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pattern searched is w3schools and it doesnt matter if small or capital letters
		//...there are different flags you can define for a pattern
		Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
		
		//in matcher, put the string you want to be searched for the defined pattern
	    Matcher matcher = pattern.matcher("Visit W3Schools!");
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      System.out.println("Match found");
	    } else {
	      System.out.println("Match not found");
	    }
	    
	    
	    /*
	     * 
	     * regular expression patterns
	     * 
	     * there is difference for find() and matches() method!!!!!!!!
	     * */
	    
	    //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[abc]"); //check if string contains at least one of them
	    
	    matcher = pattern.matcher("Visit W3Schools!");
	    matchFound = matcher.find();//true, it contains c
	    System.out.println("pattern matcher.find() = [abc], matcher = Visit W3Schools!__"+matchFound);	    
	    matcher = pattern.matcher("help!");
	    matchFound = matcher.find();//false
	    System.out.println("pattern matcher.find() = [abc], matcher = help!__"+matchFound);
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[^abc]"); //match will be found if all of these are NOT contained in string
	    
	    matcher = pattern.matcher("help");
	    matchFound = matcher.find(); //true
	    System.out.println("pattern matcher.find() = [^abc], matcher = help__"+matchFound);
	    matcher = pattern.matcher("ab");
	    matchFound = matcher.find(); //false
	    System.out.println("pattern matcher.find() = [^abc], matcher = ab__"+matchFound);
	    
	    //more than one patterns
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[abc|iop]"); 
	    
	    matcher = pattern.matcher("help");
	    matchFound = matcher.find(); //true, matching 2. pattern
	    System.out.println("pattern matcher.find() = [abc|iop], matcher = help__"+matchFound);
	    
	    //Find just one instance of any character with .
	    //. is just a placeholder for any sign. rest of pattern must correspond
	    //eg .s matches as,es,bs,us etc
	    //eg ..s matches ass, bds, mms, sss etc
	    //ATTENTION: here we use matches() method, not find() and we do not use [] for pattern
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile(".s");
	    
	    matcher = pattern.matcher("as");
	    matchFound = matcher.matches(); //true
	    System.out.println("pattern matches() = .s, matcher = as__"+matchFound);
	    matcher = pattern.matcher("ass");
	    matchFound = matcher.matches(); //false, because there are 3 chars and not 2
	    System.out.println("pattern matches() = .s, matcher = ass__"+matchFound);
	    matcher = pattern.matcher("mst");
	    matchFound = matcher.matches(); //false, because there are 3 chars and not 2
	    System.out.println("pattern matches() = .s, matcher = mst__"+matchFound);
	    matcher = pattern.matcher("ss");
	    matchFound = matcher.matches(); //true
	    System.out.println("pattern matches() = .s, matcher = ss__"+matchFound);
	    matcher = pattern.matcher("sss");
	    matchFound = matcher.matches(); //false, 3 instead of 2 chars
	    System.out.println("pattern matches() = .s, matcher = sss__"+matchFound);
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("..s");
	    
	    matcher = pattern.matcher("sss");
	    matchFound = matcher.matches(); //true,
	    System.out.println("pattern matches() = ..s, matcher = sss__"+matchFound);
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("a.s");
	    
	    matcher = pattern.matcher("sss");
	    matchFound = matcher.matches(); //false,
	    System.out.println("pattern matches() = a.s, matcher = sss__"+matchFound);
	    matcher = pattern.matcher("ass");
	    matchFound = matcher.matches(); //true,
	    System.out.println("pattern matches() = a.s, matcher = ass__"+matchFound);
	    matcher = pattern.matcher("sa.");
	    matchFound = matcher.matches(); //true,
	    System.out.println("pattern matches() = a.s, matcher = sa. __"+matchFound);
	    
	    System.out.println();
	    System.out.println();
	    System.out.println("info: difference between find() and match(), pattern without brackets");
	    
	    System.out.println("difference: matches returns true if the whole string matches the given pattern. find tries to find a substring that matches the pattern.");
	    
	    //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("amn");
	    matcher = pattern.matcher("amnamn123");
	    matchFound = matcher.matches(); 
	    System.out.println("pattern matches() = amn, matcher = amnamn123 __"+matchFound);
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = amn, matcher = amnamn123 __"+matchFound);
	    
	    System.out.println();
	    System.out.println();
	    System.out.println("info: difference between pattern in [ ] and without [ ]");
	    System.out.println("[ ] are used to define a character set, e.g. [A-Z] . Use here find() because match() does not make sense");
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[amn]"); //it will return true if a, m or n is in string
	    
	    matcher = pattern.matcher("amnamn123");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = [amn], matcher = amnamn123 __"+matchFound);
	    
	    matcher = pattern.matcher("123m6778");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = [amn], matcher = 123m6778 __"+matchFound);
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[A-Z]"); //it will return true if a big letter is in string
	    matcher = pattern.matcher("amnamn123");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = [A-Z], matcher = amnamn123 __"+matchFound);
	    
	    matcher = pattern.matcher("amnHmn123");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = [A-Z], matcher = amnHmn123 __"+matchFound);
	    
	    System.out.println("info: combine it with pipes, meaning OR");
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[A-Z|a-z]"); //it will return true if a letter is in string
	    
	    matcher = pattern.matcher("amnamn123");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = [A-Z|a-z], matcher = amnamn123 __"+matchFound);
	    
	    System.out.println("info: now if we do not use [ ], the string is only matched if it has same order like the pattern");
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("abc"); //restricted order abc. with find() it will return true if a substring contains abc
	    
	    matcher = pattern.matcher("123zhb456||abc||789"); //string contains substring abc
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = abc, matcher = 123zhb456||abc||789 __"+matchFound);
	    
	    matcher = pattern.matcher("123zhb456||acb||789"); //string contains substring acb but not abc
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = abc, matcher = 123zhb456||acb||789 __"+matchFound);
	    
	    System.out.println("info: but we can use wildcards with . ");
	
	    pattern = Pattern.compile("a.c"); //now abc and aac will match
	    
	    matcher = pattern.matcher("123zhb456||abc||789");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = a.c, matcher = 123zhb456||abc||789 __"+matchFound);
	    
	    matcher = pattern.matcher("123zhb456||aac||789");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = a.c, matcher = 123zhb456||aac||789 __"+matchFound);
	    
	    pattern = Pattern.compile("a.."); //now both abc and acb will match
	    
	    matcher = pattern.matcher("123zhb456||abc||789");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = a.., matcher = 123zhb456||abc||789 __"+matchFound);
	    
	    matcher = pattern.matcher("123zhb456||acb||789");
	    matchFound = matcher.find(); 
	    System.out.println("pattern find() = a.., matcher = 123zhb456||acb||789 __"+matchFound);
	    
	    
	    
	    
	    
	    //////////////////////////email regex. better to use match() here
	    
	    
	    
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[A-Z|a-z]+"); //with matches(): one or more (= +) letters from A - Z or a - z
	    matcher = pattern.matcher("aBcDDCzuesd");
	    matchFound = matcher.matches(); 
	    System.out.println("one or more letters aBcDDCzuesd : "+matchFound);
	    
	    matcher = pattern.matcher("aBcD7");
	    matchFound = matcher.matches(); 
	    System.out.println("one or more letters aBcD7 : "+matchFound);
	    
	    //now with digits too allowed -> use \d or 0-9
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[A-Z|a-z|\\d|äöüßÄÖÜ]+"); 
	    matcher = pattern.matcher("aBcDDCzuesd");
	    matchFound = matcher.matches(); 
	    System.out.println("one or more letters with 1 or more digits aBcDDCzuesd :"+matchFound);
	    
	    matcher = pattern.matcher("aBcDDCz889");
	    matchFound = matcher.matches(); 
	    System.out.println("one or more letters with 1 or more digits aBcDDCz889 :"+matchFound);
	    
	    matcher = pattern.matcher("aBcDDCz889Üüöä@?");
	    matchFound = matcher.matches(); 
	    System.out.println("one or more letters with 1 or more digits aBcDDCz889Üüöä@? :"+matchFound);
	    System.out.println("correct, because we do not want to have signs like @ ? etc");
	    
	    //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[A-Z|a-z|\\d|äöüßÄÖÜ|@?]+"); 
	    matcher = pattern.matcher("aBcDDCzüesd@?");
	    matchFound = matcher.matches(); 
	    System.out.println("pattern [A-Z|a-z|\\d|äöüßÄÖÜ|@?]+, String aBcDDCzüesd@? :"+matchFound);
	    
	    System.out.println("test: whitespace should not be allowed so far");
	    
	    matcher = pattern.matcher("aBcDDC  züesd@?");
	    matchFound = matcher.matches(); 
	    System.out.println("pattern [A-Z|a-z|\\d|äöüßÄÖÜ|@?]+, String 'aBcDDC  züesd@?' :"+matchFound);
	    
	    System.out.println("test: only small letters possible so far?");
	    
	    matcher = pattern.matcher("abc");
	    matchFound = matcher.matches(); 
	    System.out.println("pattern [A-Z|a-z|\\d|äöüßÄÖÜ|@?]+, String 'abc' :"+matchFound);
	    
	    //after first part, only @ is allowed
	  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
	    pattern = Pattern.compile("[A-Z|a-z|\\d|äöüßÄÖÜ]+@");
	    matcher = pattern.matcher("aBcDDCzüesd@");
	    matchFound = matcher.matches(); 
	    System.out.println("pattern [A-Z|a-z|\\d|äöüßÄÖÜ]+@+, String aBcDDCzüesd@ :"+matchFound);
	    
	    matcher = pattern.matcher("aBcDDCzüesd@?");
	    matchFound = matcher.matches(); 
	    System.out.println("pattern [[A-Z|a-z|\\d|äöüßÄÖÜ]+@]+, String aBcDDCzüesd@? :"+matchFound);
	    
	    
	  //after @ part, every letter or digit is allowed and after that, exactly 1 full stop is necessary
		  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
		    pattern = Pattern.compile("[A-Z|a-z|\\d|äöüßÄÖÜ]+[@][A-Z|a-z|\\d|äöüßÄÖÜ]+[.]");
		    matcher = pattern.matcher("aBcDDCzüesd@123.");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Z|a-z|\\d|äöüßÄÖÜ]+@[A-Z|a-z|\\d|äöüßÄÖÜ]+[.] , String aBcDDCzüesd@123. :"+matchFound);
		    
		    matcher = pattern.matcher("aBcDDCzüesd@123..");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Z|a-z|\\d|äöüßÄÖÜ]+@[A-Z|a-z|\\d|äöüßÄÖÜ]+[.] , String aBcDDCzüesd@123.. :"+matchFound);
		    
		    
		    //last part has to be a top level domain. not all countries are listed here
		    String [] topLevelDomains = {"ch","de","com","io","org","net","in","uk","us","ru","fr","it"};
		    
		  //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
		    pattern = Pattern.compile("[A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+.(ch|de|com|io|org|net|in|uk|us|ru|fr|it)"); //in the last part do not use [] because this means either...or
		    matcher = pattern.matcher("aBcDDCzüesd@123.ch");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String aBcDDCzüesd@123.ch :"+matchFound);
		    
		    matcher = pattern.matcher("hjoel87@gmx.ch");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String hjoel87@gmx.ch :"+matchFound);
		    
		    matcher = pattern.matcher("hjoel87@gmx.chh");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String hjoel87@gmx.chh :"+matchFound);
		    
		    matcher = pattern.matcher("hjoel87@gmx.chde");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String hjoel87@gmx.chde :"+matchFound);
		    
		    matcher = pattern.matcher("hjoel87@gmx:ch");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String hjoel87@gmx:ch :"+matchFound);
		    
		    matcher = pattern.matcher("hjoel87@gmx?ch");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String hjoel87@gmx?ch :"+matchFound);
		    
		    //we have to escape the .    without escape it means 'match any'
		    
		    //^^^^^^^^^^^^^^^compile^^^^^^^^^^^^^^
		    pattern = Pattern.compile("[A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+\\.(ch|de|com|io|org|net|in|uk|us|ru|fr|it)");
		    matcher = pattern.matcher("hjoel87@gmx?ch");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+\\.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String hjoel87@gmx?ch :"+matchFound);
		    
		    matcher = pattern.matcher("hjoel87@gmx.ch");
		    matchFound = matcher.matches(); 
		    System.out.println("pattern [A-Za-z\\däöüßÄÖÜ]+@[A-Za-z\\däöüßÄÖÜ]+\\.(ch|de|com|io|org|net|in|uk|us|ru|fr|it) , String hjoel87@gmx.ch :"+matchFound);
	    
	}

}
