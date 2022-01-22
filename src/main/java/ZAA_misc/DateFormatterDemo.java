package ZAA_misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatterDemo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		//create Date from String. First create SimpleDateFormat obj
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = format.parse("01/10/2022");
		
		//change format of that date to yyyy-MM-dd
		format = new SimpleDateFormat("yyyy-MM-dd");
		
		String converted = format.format(date);
		System.out.println(converted);

	}

}
